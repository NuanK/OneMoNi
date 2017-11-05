package com.bwie.test.onemoni;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBack;
    /**
     * 那些花儿
     */
    private TextView mTextTitle;
    private Button mTextRen;
    private RelativeLayout mActivityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();

    }

    private void initView() {
        mBack = (Button) findViewById(R.id.back);
        mBack.setOnClickListener(this);
        mTextTitle = (TextView) findViewById(R.id.text_title);
        mTextRen = (Button) findViewById(R.id.text_ren);
        mTextRen.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                Intent intent=new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.text_ren:
                break;
        }
    }
}
