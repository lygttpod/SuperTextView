package com.allen.library.helper

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import com.allen.library.R
import com.allen.library.data.AttributeSetData

/**
 * <pre>
 *      @author : Allen
 *      e-mail  : lygttpod@163.com
 *      date    : 2019/09/09
 *      desc    :
 * </pre>
 */
class AttributeSetHelper {

    private val defaultColor = 0xffffff
    private val defaultSelectorColor = 0x20000000

    fun loadFromAttributeSet(context: Context, attrs: AttributeSet?): AttributeSetData {
        val attributeSetData = AttributeSetData()

        if (attrs == null) return attributeSetData

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ShapeView)

        attributeSetData.shapeType = typedArray.getInt(R.styleable.ShapeView_shapeType, GradientDrawable.RECTANGLE)

        attributeSetData.solidColor = typedArray.getColor(R.styleable.ShapeView_shapeSolidColor, defaultColor)

        attributeSetData.selectorPressedColor = typedArray.getColor(R.styleable.ShapeView_shapeSelectorPressedColor, defaultSelectorColor)
        attributeSetData.selectorDisableColor = typedArray.getColor(R.styleable.ShapeView_shapeSelectorDisableColor, defaultSelectorColor)
        attributeSetData.selectorNormalColor = typedArray.getColor(R.styleable.ShapeView_shapeSelectorNormalColor, defaultSelectorColor)

        attributeSetData.cornersRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeCornersRadius, 0).toFloat()
        attributeSetData.cornersTopLeftRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeCornersTopLeftRadius, 0).toFloat()
        attributeSetData.cornersTopRightRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeCornersTopRightRadius, 0).toFloat()
        attributeSetData.cornersBottomLeftRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeCornersBottomLeftRadius, 0).toFloat()
        attributeSetData.cornersBottomRightRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeCornersBottomRightRadius, 0).toFloat()

        attributeSetData.strokeWidth = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeStrokeWidth, 0)
        attributeSetData.strokeDashWidth = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeStrokeDashWidth, 0).toFloat()
        attributeSetData.strokeDashGap = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeStrokeDashGap, 0).toFloat()

        attributeSetData.strokeColor = typedArray.getColor(R.styleable.ShapeView_shapeStrokeColor, defaultColor)

        attributeSetData.sizeWidth = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeSizeWidth, 0)
        attributeSetData.sizeHeight = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeSizeHeight, dip2px(context, 48f))

        attributeSetData.gradientAngle = typedArray.getFloat(R.styleable.ShapeView_shapeGradientAngle, -1f).toInt()
        attributeSetData.gradientCenterX = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeGradientCenterX, 0)
        attributeSetData.gradientCenterY = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeGradientCenterY, 0)
        attributeSetData.gradientGradientRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeGradientGradientRadius, 0)

        attributeSetData.gradientStartColor = typedArray.getColor(R.styleable.ShapeView_shapeGradientStartColor, -1)
        attributeSetData.gradientCenterColor = typedArray.getColor(R.styleable.ShapeView_shapeGradientCenterColor, -1)
        attributeSetData.gradientEndColor = typedArray.getColor(R.styleable.ShapeView_shapeGradientEndColor, -1)

        attributeSetData.gradientType = typedArray.getInt(R.styleable.ShapeView_shapeGradientType, 0)
        attributeSetData.gradientUseLevel = typedArray.getBoolean(R.styleable.ShapeView_shapeGradientUseLevel, false)

        attributeSetData.useSelector = typedArray.getBoolean(R.styleable.ShapeView_shapeUseSelector, false)


        attributeSetData.showShadow = typedArray.getBoolean(R.styleable.ShapeView_showShadow, false)
        attributeSetData.shadowColor = typedArray.getColor(R.styleable.ShapeView_shadowColor, Color.GRAY)
        attributeSetData.shadowColorAlpha = typedArray.getFloat(R.styleable.ShapeView_shadowColorAlpha, 0.2f)
        attributeSetData.shadowLeftWidth = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shadowLeftWidth, 0).toFloat()
        attributeSetData.shadowTopWidth = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shadowTopWidth, 0).toFloat()
        attributeSetData.shadowRightWidth = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shadowRightWidth, 0).toFloat()
        attributeSetData.shadowBottomWidth = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shadowBottomWidth, 0).toFloat()
        attributeSetData.shadowCornersRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shadowCornersRadius, 0).toFloat()
        attributeSetData.shadowCornersTopLeftRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shadowCornersTopLeftRadius, 0).toFloat()
        attributeSetData.shadowCornersTopRightRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shadowCornersTopRightRadius, 0).toFloat()
        attributeSetData.shadowCornersBottomLeftRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shadowCornersBottomLeftRadius, 0).toFloat()
        attributeSetData.shadowCornersBottomRightRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shadowCornersBottomRightRadius, 0).toFloat()

        typedArray.recycle()

        return attributeSetData
    }


    /**
     * 单位转换工具类
     *
     * @param context  上下文对象
     * @param dipValue 值
     * @return 返回值
     */
    private fun dip2px(context: Context, dipValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dipValue * scale + 0.5f).toInt()
    }
}