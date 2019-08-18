package com.mredrock.cyxbs.freshman.weight

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class AppChooseView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : View(context, attrs){
    private var backPaint=Paint()
    private var choosePaint=Paint()
    private var mWidth: Int=0
    private var mHeight:Int=0

    init {
        backPaint.color=Color.parseColor("#F5E261")
        backPaint.style=Paint.Style.FILL_AND_STROKE
        choosePaint.color=Color.parseColor("#4B4556")
        choosePaint.style=Paint.Style.FILL_AND_STROKE
        choosePaint.strokeWidth=5F
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth=w
        mHeight=h
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.translate((mWidth/2).toFloat(), (mHeight/2).toFloat())
        val radius=mHeight/2 - 10
        val rectF=RectF((-radius).toFloat(), (-radius).toFloat(), radius.toFloat(), radius.toFloat())
        canvas.drawArc(rectF, 0F, 360F,false,backPaint)
        canvas.drawLine((-7).toFloat(),9F, (-15).toFloat(),-7F,choosePaint)
        canvas.drawLine((-7).toFloat(),9F, 17F, (-15).toFloat(),choosePaint)
    }
}