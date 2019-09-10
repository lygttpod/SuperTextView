package com.allen.library.helper

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import com.allen.library.R

/**
 * <pre>
 *      @author : Allen
 *      e-mail  : lygttpod@163.com
 *      date    : 2019/09/09
 *      desc    :
 * </pre>
 */
class AttributeSetHelper {

    private val defaultColor = 0x20000000
    private val defaultSelectorColor = 0x20000000

    fun initShapeBuilderFromAttributeSet(context: Context, attrs: AttributeSet?): ShapeBuilder {
        if (attrs == null) return ShapeBuilder()
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ShapeView)

        val shapeType = typedArray.getInt(R.styleable.ShapeView_shapeType, GradientDrawable.RECTANGLE)

        val solidColor = typedArray.getColor(R.styleable.ShapeView_shapeSolidColor, defaultColor)

        val selectorPressedColor = typedArray.getColor(R.styleable.ShapeView_shapeSelectorPressedColor, defaultSelectorColor)
        val selectorDisableColor = typedArray.getColor(R.styleable.ShapeView_shapeSelectorDisableColor, defaultSelectorColor)
        val selectorNormalColor = typedArray.getColor(R.styleable.ShapeView_shapeSelectorNormalColor, defaultSelectorColor)

        val cornersRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeCornersRadius, 0).toFloat()
        val cornersTopLeftRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeCornersTopLeftRadius, 0).toFloat()
        val cornersTopRightRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeCornersTopRightRadius, 0).toFloat()
        val cornersBottomLeftRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeCornersBottomLeftRadius, 0).toFloat()
        val cornersBottomRightRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeCornersBottomRightRadius, 0).toFloat()

        val strokeWidth = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeStrokeWidth, 0)
        val strokeDashWidth = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeStrokeDashWidth, 0).toFloat()
        val strokeDashGap = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeStrokeDashGap, 0).toFloat()

        val strokeColor = typedArray.getColor(R.styleable.ShapeView_shapeStrokeColor, defaultColor)

        val sizeWidth = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeSizeWidth, 0)
        val sizeHeight = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeSizeHeight, dip2px(context, 48f))

        val gradientAngle = typedArray.getFloat(R.styleable.ShapeView_shapeGradientAngle, -1f).toInt()
        val gradientCenterX = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeGradientCenterX, 0)
        val gradientCenterY = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeGradientCenterY, 0)
        val gradientGradientRadius = typedArray.getDimensionPixelSize(R.styleable.ShapeView_shapeGradientGradientRadius, 0)

        val gradientStartColor = typedArray.getColor(R.styleable.ShapeView_shapeGradientStartColor, -1)
        val gradientCenterColor = typedArray.getColor(R.styleable.ShapeView_shapeGradientCenterColor, -1)
        val gradientEndColor = typedArray.getColor(R.styleable.ShapeView_shapeGradientEndColor, -1)

        val gradientType = typedArray.getInt(R.styleable.ShapeView_shapeGradientType, 0)
        val gradientUseLevel = typedArray.getBoolean(R.styleable.ShapeView_shapeGradientUseLevel, false)

        val useSelector = typedArray.getBoolean(R.styleable.ShapeView_shapeUseSelector, false)

        typedArray.recycle()

        val shapeBuilder = ShapeBuilder()
        shapeBuilder
                .setShapeType(shapeType)
                .setShapeCornersRadius(cornersRadius)
                .setShapeCornersTopLeftRadius(cornersTopLeftRadius)
                .setShapeCornersTopRightRadius(cornersTopRightRadius)
                .setShapeCornersBottomRightRadius(cornersBottomRightRadius)
                .setShapeCornersBottomLeftRadius(cornersBottomLeftRadius)
                .setShapeSolidColor(solidColor)
                .setShapeStrokeColor(strokeColor)
                .setShapeStrokeWidth(strokeWidth)
                .setShapeStrokeDashWidth(strokeDashWidth)
                .setShapeStrokeDashGap(strokeDashGap)
                .setShapeUseSelector(useSelector)
                .setShapeSelectorNormalColor(selectorNormalColor)
                .setShapeSelectorPressedColor(selectorPressedColor)
                .setShapeSelectorDisableColor(selectorDisableColor)
                .setShapeSizeWidth(sizeWidth)
                .setShapeSizeHeight(sizeHeight)
                .setShapeGradientType(gradientType)
                .setShapeGradientAngle(gradientAngle)
                .setShapeGradientGradientRadius(gradientGradientRadius)
                .setShapeGradientUseLevel(gradientUseLevel)
                .setShapeGradientCenterX(gradientCenterX)
                .setShapeGradientCenterY(gradientCenterY)
                .setShapeGradientStartColor(gradientStartColor)
                .setShapeGradientCenterColor(gradientCenterColor)
                .setShapeGradientEndColor(gradientEndColor)

        return shapeBuilder
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