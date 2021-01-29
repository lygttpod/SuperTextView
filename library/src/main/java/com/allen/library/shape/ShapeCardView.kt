package com.allen.library.shape

import android.content.Context
import androidx.cardview.widget.CardView
import android.util.AttributeSet
import com.allen.library.data.AttributeSetData
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
class ShapeCardView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : androidx.cardview.widget.CardView(context, attrs, defStyleAttr) {
    var shapeBuilder: ShapeBuilder? = null
    var attributeSetData: AttributeSetData = AttributeSetData()

    init {
        attributeSetData = AttributeSetHelper().loadFromAttributeSet(context, attrs)
        shapeBuilder = ShapeBuilder()
        shapeBuilder?.init(this, attributeSetData)
    }
}