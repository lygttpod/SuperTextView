package com.allen.supertextview;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.allen.supertextviewlibrary.SuperTextView;

public class MainActivity extends AppCompatActivity {

    private SuperTextView superTextView;

    private Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        superTextView = (SuperTextView) findViewById(R.id.super_tv);

    }

    /**
     * 可以通过链式设置大部分常用的属性值
     */
//    private void setSuperTextView() {
//        superTextView.setLeftIcon(drawable)
//                .setLeftString("")
//                .setLeftTVColor(0)
//                .setLeftTopString("")
//                .setLeftTopTVColor(0)
//                .setLeftBottomString("")
//                .setLeftBottomTVColor(0)
//                .setLeftBottomString2("")
//                .setLeftBottomTVColor2(0)
//                .setRightString("")
//                .setRightTVColor(0)
//                .setCbChecked(true)
//                .setCbBackground(drawable)
//                .setRightIcon(drawable)
//                .setRightString("")
//                .setRightTVColor(0)
//                .setLeftString("")
//                .setOnSuperTextViewClickListener(new SuperTextView.OnSuperTextViewClickListener() {
//                    @Override
//                    public void onSuperTextViewClick() {
//                        super.onSuperTextViewClick();
//                        //do something
//                    }
//
//                    @Override
//                    public void onLeftTopClick() {
//                        super.onLeftTopClick();
//                        //do something
//                    }
//
//                    @Override
//                    public void onLeftBottomClick() {
//                        super.onLeftBottomClick();
//                        //do something
//                    }
//
//                    @Override
//                    public void onLeftBottomClick2() {
//                        super.onLeftBottomClick2();
//                        //do something
//                    }
//                });
//    }
}
