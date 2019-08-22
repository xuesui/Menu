package com.mredrock.cyxbs.freshman.weight

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.mredrock.cyxbs.freshman.R

class AppStrokeTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet) :
    View(context, attrs) {
    private val paint = Paint()
    private var paintColor: Int = 0
    private var text: String = ""
    private var mWidth: Int=0
    private var mHeight:Int=0

    init {
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.strokeWidth=8f
        paint.textSize= 100F
        initAttributes(context,attrs)
    }

    private fun initAttributes(context: Context, attrs: AttributeSet) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.AppStrokeTextView)
        paintColor=ta.getInteger(R.styleable.AppStrokeTextView_app_paint_color,Color.parseColor("#3D325B"))
        text=ta.getString(R.styleable.AppStrokeTextView_app_text)
        ta.recycle()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth=w
        mHeight=h
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.translate((mWidth/2).toFloat(), (mHeight/2).toFloat())
        canvas.drawText(text, (-mWidth* 0.15).toFloat(), (mHeight/4).toFloat(),paint)
    }
}