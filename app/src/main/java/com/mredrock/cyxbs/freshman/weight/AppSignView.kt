package com.mredrock.cyxbs.freshman.weight

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.mredrock.cyxbs.freshman.R

class AppSignView @JvmOverloads constructor(context: Context, attrs: AttributeSet) :
    View(context, attrs) {
    private var progressBarPaint= Paint()
    private var progressPaint=Paint()
    private var textPaint=Paint()
    private var mWidth: Int=0
    private var mHeight:Int=0
    private var text: String = ""

    init {
        progressBarPaint.color= Color.parseColor("#443168")
        progressBarPaint.style=Paint.Style.STROKE
        progressBarPaint.strokeWidth=20F
        progressPaint.color=Color.parseColor("#F5E261")
        progressPaint.style=Paint.Style.FILL_AND_STROKE
        textPaint.color=Color.parseColor("#3D325B")
        textPaint.textSize= 40F
        textPaint.style=Paint.Style.FILL_AND_STROKE
        textPaint.strokeWidth= 2F
        initAttributes(context,attrs)
    }


    private fun initAttributes(context: Context, attrs: AttributeSet) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.AppSignView)
        text=ta.getString(R.styleable.AppSignView_app_text_sign)
        ta.recycle()
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
        val progressbarRect=RectF((-mWidth * 0.375).toFloat(), (-mHeight/3).toFloat(),
            (mWidth * 0.375).toFloat(), (mHeight/3).toFloat()
        )

        val progressRect=RectF((-mWidth * 0.375+40).toFloat(), (-mHeight/3-30).toFloat(),
            (mWidth * 0.375+40).toFloat(), (mHeight/3-30).toFloat())
        canvas.drawRoundRect(progressRect, 90F, 90F,progressPaint)
        canvas.drawRoundRect(progressbarRect, 90F, 90F,progressBarPaint)


        canvas.drawText(text, (-mWidth /16).toFloat(), (mHeight/16).toFloat(),textPaint)
    }
}