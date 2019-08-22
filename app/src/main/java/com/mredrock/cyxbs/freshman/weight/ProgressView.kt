package com.mredrock.cyxbs.freshman.weight

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import kotlinx.android.synthetic.main.app_activity_flash.view.*

class ProgressView@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : View(context, attrs){
    private val progressbarPaint =Paint()
    private val progressPaint=Paint()
    private var mWidth: Int=0
    private var mHeight:Int=0
    private var stratWidth=0
    private var target:Float=0F
    private var isAnimation = false

    init {
        progressbarPaint.style=Paint.Style.STROKE
        progressbarPaint.strokeWidth=20f
        progressbarPaint.color=Color.parseColor("#594D77")
        progressPaint.style=Paint.Style.FILL_AND_STROKE
        progressPaint.color=Color.parseColor("#FFCF32")
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

        val progress =RectF((-mWidth* 0.375 +10).toFloat(), (-80).toFloat(), (stratWidth-mWidth * 0.375+20).toFloat(), 20F)
        canvas.drawRoundRect(progress, 45F, 45F,progressPaint)

        val progressbar =RectF((-mWidth * 0.375).toFloat(), (-40).toFloat(), (mWidth * 0.375).toFloat(), 40F)
        canvas.drawRoundRect(progressbar, 60F, 60F,progressbarPaint)

        if (isAnimation==false){
            doAnimation()
            isAnimation=true
        }

    }

    private fun doAnimation(){
        target= (mWidth * 0.75).toFloat()
        val animator=ValueAnimator.ofInt(0, target.toInt())
        animator.duration=2500
        animator.addUpdateListener {
            stratWidth=it.animatedValue as Int
            invalidate()
        }
        animator.start()
    }
}