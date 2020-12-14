package com.allen.library.helper

import android.R
import android.annotation.TargetApi
import android.os.Build
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.DrawableRes
import java.lang.reflect.Field


/**
 * @name SuperTextView
 * @author Realmo
 * @email   momo.weiye@gmail.com
 * @version 1.0.0
 * @time 2020/12/14 10:27
 * @describe
 */
object EditTextHelper {

    @TargetApi(Build.VERSION_CODES.O)
    fun setCursorDrawable(editText:EditText,@DrawableRes drawableRes:Int){
        try { //修改光标的颜色（反射）
            val f: Field = TextView::class.java.getDeclaredField("mCursorDrawableRes")
            f.setAccessible(true)
            f.set(editText, drawableRes)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}