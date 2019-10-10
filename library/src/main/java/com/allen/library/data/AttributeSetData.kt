package com.allen.library.data

import android.graphics.Color

/**
 * <pre>
 *      @author : Allen
 *      e-mail  : lygttpod@163.com
 *      date    : 2019/09/22
 *      desc    :
 * </pre>
 */
class AttributeSetData {
    var shapeType = -1
    var solidColor = -1

    var strokeWidth = -1
    var strokeColor = -1
    var strokeDashWidth = 0.0f
    var strokeDashGap = 0.0f

    var cornersRadius = 0.0f
    var cornersTopLeftRadius = 0.0f
    var cornersTopRightRadius = 0.0f
    var cornersBottomLeftRadius = 0.0f
    var cornersBottomRightRadius = 0.0f

    var gradientAngle = -1
    var gradientCenterX: Int = 0
    var gradientCenterY: Int = 0
    var gradientGradientRadius: Int = 0
    var gradientStartColor = -1
    var gradientCenterColor = -1
    var gradientEndColor = -1
    var gradientType: Int = 0
    var gradientUseLevel: Boolean = false

    var sizeWidth = -1
    var sizeHeight = -1

    var selectorPressedColor: Int = 0
    var selectorDisableColor: Int = 0
    var selectorNormalColor: Int = 0

    var useSelector: Boolean = false

    //////////阴影相关////////
    var showShadow: Boolean = false
    var shadowColor: Int = Color.GRAY
    var shadowColorAlpha: Float = 0.2f
    var shadowLeftWidth: Float = 0f
    var shadowTopWidth: Float = 0f
    var shadowRightWidth: Float = 0f
    var shadowBottomWidth: Float = 0f

    var shadowCornersRadius: Float = 0f
    var shadowCornersTopLeftRadius: Float = 0f
    var shadowCornersTopRightRadius: Float = 0f
    var shadowCornersBottomLeftRadius: Float = 0f
    var shadowCornersBottomRightRadius: Float = 0f
}