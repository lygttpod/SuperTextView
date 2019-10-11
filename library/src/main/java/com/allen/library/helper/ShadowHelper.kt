package com.allen.library.helper

import android.graphics.*
import android.view.View
import com.allen.library.data.AttributeSetData
import kotlin.math.min

/**
 * <pre>
 *      @author : Allen
 *      e-mail  : lygttpod@163.com
 *      date    : 2019/09/22
 *      desc    :
 * </pre>
 */
class ShadowHelper {

    private var targetView: View? = null

    var attributeSetData: AttributeSetData = AttributeSetData()

    private var width: Int = 0
    private var height: Int = 0

    private var cornersPathList: MutableList<Path> = mutableListOf()

    private var leftTopCornersPath: Path = Path()
    private var leftBottomCornersPath: Path = Path()
    private var rightTopCornersPath: Path = Path()
    private var rightBottomCornersPath: Path = Path()

    private var allRadius: Float = 0f

    private var leftTopRadius: Float = 0f
    private var leftBottomRadius: Float = 0f
    private var rightTopRadius: Float = 0f
    private var rightBottomRadius: Float = 0f

    private var shadowLeftWidth: Float = 0f
    private var shadowRightWidth: Float = 0f
    private var shadowTopWidth: Float = 0f
    private var shadowBottomWidth: Float = 0f

    private var contentCornersArcRectF: RectF = RectF()

    private var contentCornersColor: Int = Color.WHITE
    private var paint: Paint = Paint()

    private var shadowStrokeWidth = 1f

    private var shadowAreaPath = Path()
    private var shadowOuterRect = RectF()
    private var shadowInnerRect = RectF()

    private var shadowColorRect = RectF()
    private var shadowColorPathList: MutableList<Path> = mutableListOf()

    private var shadowRadii: FloatArray = floatArrayOf()

    private var shadowMaxWidth = 0f

    private var shadowColor = Color.GRAY

    private var shadowColorAlpha = 0f

    private var shadowColorAlphaList: MutableList<Int> = mutableListOf()

    //修复圆角部分变粗的问题
    private var fixBorder = 0f

    private var maxRadius = 0f


    fun init(targetView: View?, attributeSetData: AttributeSetData) {
        this.attributeSetData = attributeSetData
        this.targetView = targetView
        //设置软件渲染类型(不设置的话在列表中使用会卡顿)
        //硬件加速详细介绍请参考 https://hencoder.com/ui-1-8/
        targetView?.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        initParams()
    }

    private fun initParams() {
        initColor()
        initRadius()
        initShadowWidth()
        initPaint()
    }

    private fun initColor() {
        shadowColor = attributeSetData.shadowColor
        shadowColorAlpha = attributeSetData.shadowColorAlpha
        setShadowColor()
    }

    private fun initRadius() {
        allRadius = attributeSetData.shadowCornersRadius
        leftTopRadius = attributeSetData.shadowCornersTopLeftRadius
        leftBottomRadius = attributeSetData.shadowCornersBottomLeftRadius
        rightTopRadius = attributeSetData.shadowCornersTopRightRadius
        rightBottomRadius = attributeSetData.shadowCornersBottomRightRadius
    }

    private fun initShadowWidth() {
        shadowLeftWidth = attributeSetData.shadowLeftWidth
        shadowTopWidth = attributeSetData.shadowTopWidth
        shadowRightWidth = attributeSetData.shadowRightWidth
        shadowBottomWidth = attributeSetData.shadowBottomWidth
    }


    private fun initPaint() {
        paint.color = contentCornersColor
        paint.isAntiAlias = true
        paint.strokeWidth = 0f
        paint.style = Paint.Style.FILL
    }

    private fun setShadowColor() {
        val colorAlpha = Color.alpha(shadowColor)
        if (colorAlpha != 255) {
            shadowColorAlpha = colorAlpha / 255.0f
        }
    }

    private fun resetData() {
        setShadowColor()

        setShadowWidthAndContentPadding()

        setRadius()
        setCornersPath()

        setShadowAreaPath()
        setShadowColorPathList()
    }

    private fun setShadowWidthAndContentPadding() {
        targetView?.setPadding(shadowLeftWidth.toInt(), shadowTopWidth.toInt(), shadowRightWidth.toInt(), shadowBottomWidth.toInt())
        shadowMaxWidth = listOf(shadowLeftWidth, shadowRightWidth, shadowTopWidth, shadowBottomWidth).max()
                ?: 0f
        maxRadius = (height - shadowTopWidth - shadowBottomWidth) / 2
    }

    private fun setRadius() {
        if (maxRadius > 0f) {
            allRadius = min(allRadius, maxRadius)
            if (allRadius > 0f) {
                leftTopRadius = allRadius
                leftBottomRadius = allRadius
                rightTopRadius = allRadius
                rightBottomRadius = allRadius
            } else {
                leftTopRadius = min(leftTopRadius, maxRadius)
                leftBottomRadius = min(leftBottomRadius, maxRadius)
                rightTopRadius = min(rightTopRadius, maxRadius)
                rightBottomRadius = min(rightBottomRadius, maxRadius)
            }
        } else {
            if (allRadius > 0f) {
                leftTopRadius = allRadius
                leftBottomRadius = allRadius
                rightTopRadius = allRadius
                rightBottomRadius = allRadius
            }
        }
    }

    private fun setCornersPath() {
        cornersPathList.clear()
        contentCornersArcRectF.setEmpty()
        if (leftTopRadius > 0) {
            leftTopCornersPath.reset()
            leftTopCornersPath.moveTo(shadowLeftWidth, shadowTopWidth)
            contentCornersArcRectF.set(shadowLeftWidth, shadowTopWidth, shadowLeftWidth + leftTopRadius * 2, shadowTopWidth + leftTopRadius * 2)
            leftTopCornersPath.arcTo(contentCornersArcRectF, 270f, -90f)
            cornersPathList.add(leftTopCornersPath)
        }
        if (leftBottomRadius > 0) {
            leftBottomCornersPath.reset()
            leftBottomCornersPath.moveTo(shadowLeftWidth, height - shadowBottomWidth)
            contentCornersArcRectF.set(shadowLeftWidth, height - shadowBottomWidth - leftBottomRadius * 2, shadowLeftWidth + leftBottomRadius * 2, height - shadowBottomWidth)
            leftBottomCornersPath.arcTo(contentCornersArcRectF, 180f, -90f)
            cornersPathList.add(leftBottomCornersPath)
        }
        if (rightTopRadius > 0) {
            rightTopCornersPath.reset()
            rightTopCornersPath.moveTo(width - shadowRightWidth, shadowTopWidth)
            contentCornersArcRectF.set(width - shadowRightWidth - rightTopRadius * 2, shadowTopWidth, width - shadowRightWidth, shadowTopWidth + rightTopRadius * 2)
            rightTopCornersPath.arcTo(contentCornersArcRectF, 0f, -90f)
            cornersPathList.add(rightTopCornersPath)
        }
        if (rightBottomRadius > 0) {
            rightBottomCornersPath.reset()
            rightBottomCornersPath.moveTo(width - shadowRightWidth, height - shadowBottomWidth)
            contentCornersArcRectF.set(width - shadowRightWidth - rightBottomRadius * 2, height - shadowBottomWidth - rightBottomRadius * 2, width - shadowRightWidth, height - shadowBottomWidth)
            rightBottomCornersPath.arcTo(contentCornersArcRectF, 90f, -90f)
            cornersPathList.add(rightBottomCornersPath)
        }
    }

    private fun setShadowAreaPath() {
        shadowAreaPath.reset()
        shadowOuterRect.set(fixBorder, fixBorder, width - fixBorder, height - +fixBorder)
        shadowAreaPath.addRect(shadowOuterRect, Path.Direction.CW)
        shadowInnerRect.set(shadowLeftWidth + fixBorder, shadowTopWidth + fixBorder, width - shadowRightWidth - fixBorder, height - shadowBottomWidth - fixBorder)
        shadowRadii = floatArrayOf(leftTopRadius, leftTopRadius, rightTopRadius, rightTopRadius, rightBottomRadius, rightBottomRadius, leftBottomRadius, leftBottomRadius)
        shadowAreaPath.addRoundRect(shadowInnerRect, shadowRadii, Path.Direction.CCW)
    }

    private fun setShadowColorPathList() {
        shadowColorPathList.clear()
        shadowColorAlphaList.clear()
        for (i in shadowMaxWidth.toInt() downTo 0) {
            val shadowColorPath = Path()
            shadowColorRect.set(i + fixBorder, i + fixBorder, width - i - fixBorder, height - i - fixBorder)
            shadowColorPath.addRoundRect(shadowColorRect, shadowRadii, Path.Direction.CW)
            shadowColorPathList.add(shadowColorPath)
            shadowColorAlphaList.add((shadowColorAlpha * 255 * i / shadowMaxWidth).toInt())
        }
    }

    fun onSizeChanged(w: Int, h: Int) {
        width = w
        height = h
        fixBorder = shadowStrokeWidth / 2

        resetData()
    }

    fun drawBefore(canvas: Canvas) {
        canvas.save()
        canvas.saveLayer(0f, 0f, width.toFloat(), height.toFloat(), null, Canvas.ALL_SAVE_FLAG)
    }

    fun drawOver(canvas: Canvas) {
        drawContent(canvas)
        drawShadow(canvas)
    }

    /**
     * draw content corners
     */
    private fun drawContent(canvas: Canvas) {
        paint.color = contentCornersColor
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 0f
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
        for (path in cornersPathList) {
            canvas.drawPath(path, paint)
        }
        canvas.restore()
        paint.xfermode = null
    }

    /**
     * draw shadow
     */
    private fun drawShadow(canvas: Canvas) {
        canvas.clipPath(shadowAreaPath)

        paint.color = shadowColor
        paint.strokeWidth = shadowStrokeWidth
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE

        shadowColorPathList.forEachIndexed { index, path ->
            paint.alpha = shadowColorAlphaList[index]
            canvas.drawPath(path, paint)
        }
    }


    ////////////////////////对外暴露的api////////////////////////

    fun setShadowLeftWidth(shadowLeftWidth: Float): ShadowHelper {
        this.shadowLeftWidth = shadowLeftWidth
        return this
    }

    fun setShadowTopWidth(shadowTopWidth: Float): ShadowHelper {
        this.shadowTopWidth = shadowTopWidth
        return this
    }

    fun setShadowRightWidth(shadowRightWidth: Float): ShadowHelper {
        this.shadowRightWidth = shadowRightWidth
        return this
    }

    fun setShadowBottomWidth(shadowBottomWidth: Float): ShadowHelper {
        this.shadowBottomWidth = shadowBottomWidth
        return this
    }

    fun setShadowLeftTopRadius(leftTopRadius: Float): ShadowHelper {
        this.leftTopRadius = leftTopRadius
        return this
    }

    fun setShadowLeftBottomRadius(leftBottomRadius: Float): ShadowHelper {
        this.leftBottomRadius = leftBottomRadius
        return this
    }

    fun setShadowRightTopRadius(rightTopRadius: Float): ShadowHelper {
        this.rightTopRadius = rightTopRadius
        return this
    }

    fun setShadowRightBottomRadius(rightBottomRadius: Float): ShadowHelper {
        this.rightBottomRadius = rightBottomRadius
        return this
    }

    fun setShadowAllRadius(allRadius: Float): ShadowHelper {
        this.allRadius = allRadius
        return this
    }

    fun setShadowColor(shadowColor: Int): ShadowHelper {
        this.shadowColor = shadowColor
        return this
    }

    /**
     * set the alpha component [0..1]
     */
    fun setShadowColorAlpha(shadowColorAlphaPercent: Float): ShadowHelper {
        when {
            shadowColorAlpha < 0 -> this.shadowColorAlpha = 0f
            shadowColorAlpha > 1 -> this.shadowColorAlpha = 1f
            else -> this.shadowColorAlpha = shadowColorAlphaPercent
        }
        return this
    }

    fun applyToView() {
        resetData()
        targetView?.invalidate()
    }
}