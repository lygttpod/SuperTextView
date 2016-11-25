package com.allen.supertextview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by allen on 2016/11/22.
 */

public class CommonTextViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_textview_layout);


//        Glide.with(this).load("url").placeholder(R.drawable.head_default)
//                .into(new SimpleTarget<GlideDrawable>() {
//                    @Override
//                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
//                        commonTextView.setLeftDrawableLeft(resource);
//                    }
//                });
    }
}
