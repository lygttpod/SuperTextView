package com.allen.supertextview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button button0, button1, button2, button3,
            button4, button5, button6, button7,button8, list_button, click_button,super_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        list_button = (Button) findViewById(R.id.list_button);
        click_button = (Button) findViewById(R.id.click_button);
        super_button = (Button) findViewById(R.id.super_button);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        list_button.setOnClickListener(this);
        click_button.setOnClickListener(this);
        super_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.button0:
                intent.setClass(this, TypeActivity.class);
                intent.putExtra("type", 0);
                startActivity(intent);
                break;
            case R.id.button1:
                intent.setClass(this, TypeActivity.class);
                intent.putExtra("type", 1);
                startActivity(intent);
                break;
            case R.id.button2:
                intent.setClass(this, TypeActivity.class);
                intent.putExtra("type", 2);
                startActivity(intent);
                break;
            case R.id.button3:
                intent.setClass(this, TypeActivity.class);
                intent.putExtra("type", 3);
                startActivity(intent);
                break;
            case R.id.button4:
                intent.setClass(this, TypeActivity.class);
                intent.putExtra("type", 4);
                startActivity(intent);
                break;
            case R.id.button5:
                intent.setClass(this, TypeActivity.class);
                intent.putExtra("type", 5);
                startActivity(intent);
                break;
            case R.id.button6:
                intent.setClass(this, TypeActivity.class);
                intent.putExtra("type", 6);
                startActivity(intent);
                break;
            case R.id.button7:
                intent.setClass(this, TypeActivity.class);
                intent.putExtra("type", 7);
                startActivity(intent);
                break;
            case R.id.button8:
                intent.setClass(this, TypeActivity.class);
                intent.putExtra("type", 8);
                startActivity(intent);
                break;
            case R.id.list_button:
                intent.setClass(this, ListActivity.class);
                startActivity(intent);
                break;
            case R.id.click_button:
                intent.setClass(this, ClickActivity.class);
                startActivity(intent);
                break;
            case R.id.super_button:
                intent.setClass(this, SuperButtonActivity.class);
                startActivity(intent);
                break;
        }
    }

}
