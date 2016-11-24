package com.allen.supertextview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.allen.library.CommonTextView;

/**
 * Created by allen on 2016/11/22.
 */

public class CommonTextViewActivity extends AppCompatActivity {
    private CommonTextView commonTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_textview_layout);
        commonTextView.getLeftTextString();
        commonTextView.getCenterTextString();
        commonTextView.getRightTextString();
    }
}
