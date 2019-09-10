package com.allen.library.shape

import android.content.Context
import android.support.v7.widget.AppCompatTextView
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
class ShapeTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : AppCompatTextView(context, attrs, defStyleAttr) {
    var shapeBuilder: ShapeBuilder = ShapeBuilder()

    init {
        shapeBuilder = AttributeSetHelper().initShapeBuilderFromAttributeSet(context, attrs)
        shapeBuilder.into(this)
    }
}