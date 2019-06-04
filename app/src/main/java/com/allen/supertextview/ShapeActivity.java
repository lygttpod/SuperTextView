package com.allen.supertextview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.allen.library.utils.ShapeBuilder;

/**
 * <pre>
 *      @author : Allen
 *      e-mail  : lygttpod@163.com
 *      date    : 2019/05/31
 *      desc    :
 * </pre>
 */
public class ShapeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_shape);

        Button btn = findViewById(R.id.btn);
        TextView tv = findViewById(R.id.tv);
        View view = findViewById(R.id.view);
        LinearLayout linearLayout = findViewById(R.id.ll);

        getColorShape().into(btn);

        getColorShape().into(tv);

        getViewShape().into(view);

        getLinearLayoutShape().into(linearLayout);

    }

    private ShapeBuilder getNormalShape() {
        ShapeBuilder shapeBuilder = new ShapeBuilder()
                .setShapeType(ShapeBuilder.RECTANGLE)
                .setShapeSolidColor(getResources().getColor(R.color.colorAccent))
                .setShapeStrokeColor(getResources().getColor(R.color.colorPrimary))
                .setShapeStrokeWidth(2)
                .setShapeCornersRadius(10);
        return shapeBuilder;
    }

    private ShapeBuilder getColorShape() {
        ShapeBuilder shapeBuilder = getNormalShape()
                .setShapeUseSelector(true)
                .setShapeSelectorNormalColor(getResources().getColor(R.color.colorAccent))
                .setShapeSelectorDisableColor(getResources().getColor(R.color.colorPrimary))
                .setShapeSelectorPressedColor(getResources().getColor(R.color.common_pressed));
        return shapeBuilder;
    }

    private ShapeBuilder getLinearLayoutShape() {
        ShapeBuilder shapeBuilder = getNormalShape()
                .setShapeGradientAngle(45)
                .setShapeGradientStartColor(getResources().getColor(R.color.colorAccent))
                .setShapeGradientCenterColor(getResources().getColor(R.color.white))
                .setShapeGradientEndColor(getResources().getColor(R.color.colorPrimary));
        return shapeBuilder;
    }

    private ShapeBuilder getViewShape() {
        ShapeBuilder shapeBuilder = getNormalShape()
                .setShapeGradientAngle(315)
                .setShapeGradientCenterY(10)
                .setShapeGradientCenterX(10)
                .setShapeGradientStartColor(getResources().getColor(R.color.colorAccent))
                .setShapeGradientEndColor(getResources().getColor(R.color.white));
        return shapeBuilder;
    }

}
