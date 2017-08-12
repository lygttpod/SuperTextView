package com.allen.supertextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.allen.library.SuperButton;

/**
 * Created by allen on 2017/7/10.
 */
public class SuperButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.super_button_layout);


        SuperButton superButton = new SuperButton(this);

        /**
         * 所有属性均可用代码动态实现
         * 以下只是展示部分方法 可根据需求选择不同的方法
         */
        superButton.setShapeType(SuperButton.RECTANGLE)
                .setShapeCornersRadius(20)
                .setShapeSolidColor(getResources().getColor(R.color.colorAccent))
                .setShapeStrokeColor(getResources().getColor(R.color.colorPrimary))
                .setShapeStrokeWidth(1)
                .setShapeSrokeDashWidth(2)
                .setShapeStrokeDashGap(5)
                .setTextGravity(SuperButton.TEXT_GRAVITY_RIGHT)
                .setShapeUseSelector(true)
                .setShapeSelectorPressedColor(getResources().getColor(R.color.gray))
                .setShapeSelectorNormalColor(getResources().getColor(R.color.red_btn))
                .setShapeSelectorDisableColor(getResources().getColor(R.color.colorPrimary))
                .setUseShape();
        // TODO: 2017/8/12 动态设置切记需要在最后调用 setUseShape 才能对设置的参数生效

    }

}
