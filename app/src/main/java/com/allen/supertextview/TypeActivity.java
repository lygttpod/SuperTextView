package com.allen.supertextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.allen.library.SuperTextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.squareup.picasso.Picasso;

/**
 * Created by allen on 2016/10/19.
 */
public class TypeActivity extends AppCompatActivity {

    private int type;
    private SuperTextView superTextView, superTextView2, superTextView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
            case 7:
                setContentView(R.layout.layout7);
                break;
            case 8:
                setContentView(R.layout.layout8);
                break;

        }

    }

    private void setData() {
        superTextView = (SuperTextView) findViewById(R.id.super_tv1);
        superTextView2 = (SuperTextView) findViewById(R.id.super_tv2);
        superTextView3 = (SuperTextView) findViewById(R.id.super_tv3);

        Picasso.with(this).load("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3860616424,1789830124&fm=80&w=179&h=119&img.PNG")
                .placeholder(R.drawable.head_default).into(superTextView.getLeftIconIV());
        Glide.with(this).load("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=219781665,3032880226&fm=80&w=179&h=119&img.JPEG")
                .placeholder(R.drawable.head_default).fitCenter().into(superTextView2.getRightIconIV());

        Glide.with(this).load("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3860616424,1789830124&fm=80&w=179&h=119&img.PNG")
                .placeholder(R.drawable.head_default)
                .into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        superTextView3.setRightTvDrawableRight(resource);
                    }
                });
    }


}
