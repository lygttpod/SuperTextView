package com.allen.supertextview

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_shadow.*
import java.lang.Exception

/**
 * <pre>
 *      @author : Allen
 *      e-mail  : lygttpod@163.com
 *      date    : 2019/09/21
 *      desc    :
 * </pre>
 */
class ShadowActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shadow)
        setShadowColor()

        shadow_color_alpha_sb.setOnSeekBarChangeListener(this)

        shadow_padding_left_sb.setOnSeekBarChangeListener(this)
        shadow_padding_top_sb.setOnSeekBarChangeListener(this)
        shadow_padding_right_sb.setOnSeekBarChangeListener(this)
        shadow_padding_bottom_sb.setOnSeekBarChangeListener(this)

        shadow_left_top_radius_sb.setOnSeekBarChangeListener(this)
        shadow_left_bottom_radius_sb.setOnSeekBarChangeListener(this)
        shadow_right_top_radius_sb.setOnSeekBarChangeListener(this)
        shadow_right_bottom_radius_sb.setOnSeekBarChangeListener(this)

        shadow_all_radius_sb.setOnSeekBarChangeListener(this)

        shape_view.shadowHelper?.let {
            it.setShadowAllRadius(10f)
                    .setShadowLeftWidth(20f)
                    .setShadowTopWidth(10f)
                    .setShadowBottomWidth(20f)
                    .setShadowRightWidth(10f)
                    .applyToView()
        }

    }

    private fun setShadowColor() {
        change_shadow_color_btn.setOnClickListener {
            val colorString = shadow_color_et.text.toString()
            if (colorString.length == 6 || colorString.length == 8) {
                try {
                    val color = Color.parseColor("#$colorString")
                    shape_view.shadowHelper?.setShadowColor(color)?.applyToView()
                } catch (e: Exception) {
                }
            }
        }
    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {

        val size = progress.toFloat()
        when (seekBar.id) {
            R.id.shadow_color_alpha_sb -> {
                shape_view.shadowHelper?.setShadowColorAlpha(size / 100)
            }
            R.id.shadow_padding_left_sb -> {
                shape_view.shadowHelper?.setShadowLeftWidth(size)
            }
            R.id.shadow_padding_top_sb -> {
                shape_view.shadowHelper?.setShadowTopWidth(size)
            }
            R.id.shadow_padding_right_sb -> {
                shape_view.shadowHelper?.setShadowRightWidth(size)
            }
            R.id.shadow_padding_bottom_sb -> {
                shape_view.shadowHelper?.setShadowBottomWidth(size)
            }
            R.id.shadow_left_top_radius_sb -> {
                shadow_all_radius_sb.progress = 0
                shape_view.shadowHelper?.setShadowLeftTopRadius(size)
            }
            R.id.shadow_left_bottom_radius_sb -> {
                shadow_all_radius_sb.progress = 0
                shape_view.shadowHelper?.setShadowLeftBottomRadius(size)
            }
            R.id.shadow_right_top_radius_sb -> {
                shadow_all_radius_sb.progress = 0
                shape_view.shadowHelper?.setShadowRightTopRadius(size)
            }
            R.id.shadow_right_bottom_radius_sb -> {
                shadow_all_radius_sb.progress = 0
                shape_view.shadowHelper?.setShadowRightBottomRadius(size)
            }
            R.id.shadow_all_radius_sb -> {
                shadow_left_top_radius_sb.progress = 0
                shadow_left_bottom_radius_sb.progress = 0
                shadow_right_top_radius_sb.progress = 0
                shadow_right_bottom_radius_sb.progress = 0
                shape_view.shadowHelper?.setShadowAllRadius(size)
            }
        }
        shape_view.shadowHelper?.applyToView()

    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }
}