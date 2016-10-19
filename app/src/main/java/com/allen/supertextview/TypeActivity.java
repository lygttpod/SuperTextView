package com.allen.supertextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by allen on 2016/10/19.
 */
public class TypeActivity extends AppCompatActivity {

    private int type;

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
                break;
            case 6:
                setContentView(R.layout.layout6);
                break;
        }

    }
}
