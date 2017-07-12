package com.allen.supertextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.allen.library.SuperTextView;

public class ClickActivity extends AppCompatActivity {

    private SuperTextView superTextView;

    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);

        superTextView = (SuperTextView) findViewById(R.id.super_tv);

        /**
         * 根据实际需求对需要的View设置点击事件
         */
        superTextView.setOnSuperTextViewClickListener(new SuperTextView.OnSuperTextViewClickListener() {
            @Override
            public void onClickListener() {
                string = "整个item的点击事件";
                Toast.makeText(ClickActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        }).setLeftTopTvClickListener(new SuperTextView.OnLeftTopTvClickListener() {
            @Override
            public void onClickListener() {
                string = superTextView.getLeftTopString();
                Toast.makeText(ClickActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        }).setLeftTvClickListener(new SuperTextView.OnLeftTvClickListener() {
            @Override
            public void onClickListener() {
                string = superTextView.getLeftString();
                Toast.makeText(ClickActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        }).setLeftBottomTvClickListener(new SuperTextView.OnLeftBottomTvClickListener() {
            @Override
            public void onClickListener() {
                string = superTextView.getLeftBottomString();
                Toast.makeText(ClickActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        }).setCenterTopTvClickListener(new SuperTextView.OnCenterTopTvClickListener() {
            @Override
            public void onClickListener() {
                string = superTextView.getCenterTopString();
                Toast.makeText(ClickActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        }).setCenterTvClickListener(new SuperTextView.OnCenterTvClickListener() {
            @Override
            public void onClickListener() {
                string = superTextView.getCenterString();
                Toast.makeText(ClickActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        }).setCenterBottomTvClickListener(new SuperTextView.OnCenterBottomTvClickListener() {
            @Override
            public void onClickListener() {
                string = superTextView.getCenterBottomString();
                Toast.makeText(ClickActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        }).setRightTopTvClickListener(new SuperTextView.OnRightTopTvClickListener() {
            @Override
            public void onClickListener() {
                string = superTextView.getRightTopString();
                Toast.makeText(ClickActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        }).setRightTvClickListener(new SuperTextView.OnRightTvClickListener() {
            @Override
            public void onClickListener() {
                string = superTextView.getRightString();
                Toast.makeText(ClickActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        }).setRightBottomTvClickListener(new SuperTextView.OnRightBottomTvClickListener() {
            @Override
            public void onClickListener() {
                string = superTextView.getRightBottomString();
                Toast.makeText(ClickActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        }).setSwitchCheckedChangeListener(new SuperTextView.OnSwitchCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            }
        }).setCheckBoxCheckedChangeListener(new SuperTextView.OnCheckBoxCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        }).setLeftImageViewClickListener(new SuperTextView.OnLeftImageViewClickListener() {
            @Override
            public void onClickListener() {
            }
        }).setRightImageViewClickListener(new SuperTextView.OnRightImageViewClickListener() {
            @Override
            public void onClickListener() {

            }
        });

    }
}
