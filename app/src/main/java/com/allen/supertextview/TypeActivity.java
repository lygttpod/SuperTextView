package com.allen.supertextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.allen.library.SuperTextView;
import com.squareup.picasso.Picasso;

/**
 * Created by allen on 2016/10/19.
 */
public class TypeActivity extends AppCompatActivity {

    private int type;
    private SuperTextView superTextView,superTextView2,superTextView3;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getIntent().getIntExtra("type", 0);
        switch (type) {
            case 0:
                setContentView(R.layout.main);
                break;
            case 1:
                setContentView(R.layout.layout1);
                break;
            case 2:
                setContentView(R.layout.layout2);
                break;
            case 3:
                setContentView(R.layout.layout3);
                break;
            case 4:
                setContentView(R.layout.layout4);
                break;
            case 5:
                setContentView(R.layout.layout5);
                setData();
                break;
            case 6:
                setContentView(R.layout.layout6);
                break;
        }



    }

    private void setData() {
        superTextView = (SuperTextView) findViewById(R.id.super_tv1);
        superTextView2 = (SuperTextView) findViewById(R.id.super_tv2);

        superTextView.setLeftTopString("姓名").setLeftBottomString("188********");
        superTextView2.setLeftTopString("姓名").setLeftBottomString("181********");


        Picasso.with(this).load("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3860616424,1789830124&fm=80&w=179&h=119&img.PNG")
                .placeholder(R.drawable.head_default).into((ImageView) superTextView.getView(SuperTextView.leftImageViewId));
        Picasso.with(this).load("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=219781665,3032880226&fm=80&w=179&h=119&img.JPEG")
                .placeholder(R.drawable.head_default).into((ImageView) superTextView2.getView(SuperTextView.rightImageViewId));

    }


}
