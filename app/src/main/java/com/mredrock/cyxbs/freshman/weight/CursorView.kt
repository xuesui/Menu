package com.mredrock.cyxbs.freshman.weight

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.mredrock.cyxbs.freshman.R

class CursorView : View {
    private var cursorColor = Color.parseColor("#1296db") // 线的颜色
    private var counts = 4 // 被分成了几块
    private var posX = 0f // 当前X坐标的位置
    private var paint: Paint? = null

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context) : super(context) {
        init()
    }

    private fun init() {
        // 初始化画笔
        paint = Paint()
        paint!!.isAntiAlias = true//边缘相对清晰一点,锯齿痕迹不那么明显
        paint!!.isDither = true//设置防抖动
        paint!!.color = cursorColor//画笔颜色
    }


    fun setCounts(counts: Int) {
        this.counts = counts
    }


    fun setColor(cursorColor: Int) {
        this.cursorColor = cursorColor
    }


    fun setXY(pos: Int, rate: Float) {
        val single = measuredWidth / counts
        posX = pos * single + single * rate
        invalidate()//重新绘制
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint!!.strokeWidth = (measuredHeight + 5).toFloat()
        val width = measuredWidth / counts//下划线长度
        canvas.drawLine(posX, 0f, posX + width, 0f, paint!!)
    }

}
