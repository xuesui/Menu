package com.mredrock.cyxbs.freshman.weight

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout
import com.mredrock.cyxbs.freshman.R

class AppShawdowLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    FrameLayout(context, attrs, defStyleAttr) {
    private val radii = FloatArray(8)   // top-left, top-right, bottom-right, bottom-left
    private var mClipPath: Path? = null                 // 剪裁区域路径
    private var mPaint: Paint? = null                   // 画笔
    private var mRoundAsCircle = false // 圆形
    private var mDefaultStrokeColor: Int = 0        // 默认阴影颜色
    private var mStrokeColor: Int = 0               // 阴影颜色
    private var mStrokeColorStateList: ColorStateList? = null// 阴影颜色的状态
    private var mStrokeWidth: Int = 0               // 阴影半径
    private var mAreaRegion: Region? = null             // 内容区域
    private var mLayer: RectF? = null                   // 画布图层大小
    var mClipBackground: Boolean = false        // 是否剪裁背景

    internal var clip = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)//裁剪背景所用模式
    internal var shadow = PorterDuffXfermode(PorterDuff.Mode.SRC_OVER)//画阴影所用模式

    init {
        initAttrs(context, attrs)//初始化工具以及自定义属性设置
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mLayer!!.set(0f, 0f, w.toFloat(), h.toFloat())//画布初始化
        //矩形区域的创建,padding的解决
        val areas = RectF()
        areas.left = paddingLeft.toFloat()
        areas.top = paddingTop.toFloat()
        areas.right = (w - paddingRight).toFloat()
        areas.bottom = (h - paddingBottom).toFloat()
        //path路径重置
        mClipPath!!.reset()
        //圆角和圆形属性的处理
        if (mRoundAsCircle) {
            val d = if (areas.width() >= areas.height()) areas.height() else areas.width()
            val r = d / 2
            val center = PointF((w / 2).toFloat(), (h / 2).toFloat())//中心点

            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.O_MR1) {
                mClipPath!!.addCircle(center.x, center.y, r, Path.Direction.CW)

                mClipPath!!.moveTo(0f, 0f)  // 通过空操作让Path区域占满画布
                mClipPath!!.moveTo(w.toFloat(), h.toFloat())
            } else {
                val y = h / 2 - r
                mClipPath!!.moveTo(areas.left, y)
                mClipPath!!.addCircle(center.x, y + r, r, Path.Direction.CW)
            }
        } else {
            mClipPath!!.addRoundRect(areas, radii, Path.Direction.CW)
        }
        val clip = Region(
            areas.left.toInt(), areas.top.toInt(),
            areas.right.toInt(), areas.bottom.toInt()
        )
        mAreaRegion!!.setPath(mClipPath, clip)
    }


    //在无背景的viewGroup跳过draw（），直接调用
    override fun dispatchDraw(canvas: Canvas) {
        canvas.saveLayer(mLayer, null, Canvas.ALL_SAVE_FLAG)
        super.dispatchDraw(canvas)
        if (mStrokeWidth > 0) {
            // 支持半透明描边，将与描边区域重叠的内容裁剪掉
            mPaint!!.xfermode = clip
            mPaint!!.color = Color.WHITE
            mPaint!!.strokeWidth = (mStrokeWidth * 2).toFloat()
            mPaint!!.style = Paint.Style.STROKE
            canvas.drawPath(mClipPath!!, mPaint!!)
            // 绘制描边
            mPaint!!.xfermode = shadow
            mPaint!!.color = mStrokeColor
            mPaint!!.style = Paint.Style.STROKE
            canvas.drawPath(mClipPath!!, mPaint!!)
        }
        mPaint!!.color = Color.WHITE
        mPaint!!.style = Paint.Style.FILL//画笔重置为默认状态

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.O_MR1) {
            mPaint!!.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
            canvas.drawPath(mClipPath!!, mPaint!!)
        } else {
            //裁剪背景
            mPaint!!.xfermode = clip
            val path = Path()
            path.addRect(
                0f,
                0f,
                mLayer!!.width().toInt().toFloat(),
                mLayer!!.height().toInt().toFloat(),
                Path.Direction.CW
            )
            path.op(mClipPath, Path.Op.DIFFERENCE)//做两个path的差集
            canvas.drawPath(path, mPaint!!)
        }
        canvas.restore()//回滚到上一次保存的状态
    }

    //在view或者有背景的情况下，先调用draw（），其中会调用ondraw和dispatchDraw
    override fun draw(canvas: Canvas) {
        if (mClipBackground) {
            canvas.save()
            canvas.clipPath(mClipPath!!)
            super.draw(canvas)
            canvas.restore()//背景裁剪
        } else {
            super.draw(canvas)
        }
    }


    //事件分发，用此方法判断是否处理touch事件，如为false，则向下传递,如为true,则找到需要的view
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        val action = ev.action
        if (action == MotionEvent.ACTION_DOWN && !mAreaRegion!!.contains(ev.x.toInt(), ev.y.toInt())) {
            return false
        }
        if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_UP) {
            refreshDrawableState()
        } else if (action == MotionEvent.ACTION_CANCEL) {
            isPressed = false
            refreshDrawableState()
        }
        return super.dispatchTouchEvent(ev)
    }

    private fun initAttrs(context: Context, attrs: AttributeSet?) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.AppShawdowLayout)
        mRoundAsCircle = ta.getBoolean(R.styleable.AppShawdowLayout_app_round_as_circle, false)
        mStrokeColorStateList = ta.getColorStateList(R.styleable.AppShawdowLayout_app_shadow_color)
        mClipBackground = ta.getBoolean(R.styleable.AppShawdowLayout_app_clip_background, false)
        if (null != mStrokeColorStateList) {
            mStrokeColor = mStrokeColorStateList!!.defaultColor
            mDefaultStrokeColor = mStrokeColorStateList!!.defaultColor
        } else {
            mStrokeColor = Color.WHITE
            mDefaultStrokeColor = Color.WHITE
        }
        mStrokeWidth = ta.getDimensionPixelSize(R.styleable.AppShawdowLayout_app_shadow_width, 0)
        val roundCorner = ta.getDimensionPixelSize(R.styleable.AppShawdowLayout_app_round_corner, 0)
        val roundCornerTopLeft = ta.getDimensionPixelSize(
            R.styleable.AppShawdowLayout_app_round_corner_top_left, roundCorner
        )
        val roundCornerTopRight = ta.getDimensionPixelSize(
            R.styleable.AppShawdowLayout_app_round_corner_top_right, roundCorner
        )
        val roundCornerBottomLeft = ta.getDimensionPixelSize(
            R.styleable.AppShawdowLayout_app_round_corner_bottom_left, roundCorner
        )
        val roundCornerBottomRight = ta.getDimensionPixelSize(
            R.styleable.AppShawdowLayout_app_round_corner_bottom_right, roundCorner
        )
        ta.recycle()//释放资源

        //为四个顶点坐标赋值(属性）
        radii[0] = roundCornerTopLeft.toFloat()
        radii[1] = roundCornerTopLeft.toFloat()

        radii[2] = roundCornerTopRight.toFloat()
        radii[3] = roundCornerTopRight.toFloat()

        radii[4] = roundCornerBottomRight.toFloat()
        radii[5] = roundCornerBottomRight.toFloat()

        radii[6] = roundCornerBottomLeft.toFloat()
        radii[7] = roundCornerBottomLeft.toFloat()

        mLayer = RectF()//创建区域矩形
        mClipPath = Path()
        mAreaRegion = Region()
        mPaint = Paint()
        mPaint!!.color = Color.WHITE//画笔默认为白色
        mPaint!!.isAntiAlias = true//抗锯齿
    }
}
