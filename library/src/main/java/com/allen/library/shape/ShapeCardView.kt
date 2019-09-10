package com.allen.library.shape

import android.content.Context
import android.support.v7.widget.CardView
import android.util.AttributeSet
import com.allen.library.helper.AttributeSetHelper
import com.allen.library.helper.ShapeBuilder

/**
 * <pre>
 *      @author : Allen
 *      e-mail  : lygttpod@163.com
 *      date    : 2019/09/09
 *      desc    :
 * </pre>
 */
class ShapeCardView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : CardView(context, attrs, defStyleAttr) {
    private var shapeBuilder: ShapeBuilder = ShapeBuilder()

    init {
        shapeBuilder = AttributeSetHelper().initShapeBuilderFromAttributeSet(context, attrs)
        shapeBuilder.into(this)
    }
}