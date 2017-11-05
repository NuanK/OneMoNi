package com.bwie.test.onemoni;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBack;
    /**
     * 那些花儿
     */
    private TextView mTextTitle;
    private Button mTextRen;
    private RelativeLayout mActivityMain;

    private MyRoundProcess mRoundProcess;
    /**
     * 扫描二维码
     */
    private Button mZxing;
    private final static int SCANNIN_GREQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBack = (Button) findViewById(R.id.back);
        mBack.setOnClickListener(this);
        mTextTitle = (TextView) findViewById(R.id.text_title);
        mTextRen = (Button) findViewById(R.id.text_ren);
        mTextRen.setOnClickListener(this);
        mRoundProcess = (MyRoundProcess) findViewById(R.id.my_round_process);
        // 开启动画

        mZxing = (Button) findViewById(R.id.zxing);
        mZxing.setOnClickListener(this);

    }

    /**
     * Activity 销毁时，取消动画
     * (cancel animation when activity destoryed)
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mRoundProcess != null) {
            mRoundProcess.cancelAnimate();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                this.finish();
                break;
            case R.id.text_ren:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.zxing:
                mRoundProcess.runAnimate(100);
                Intent intent_zxing = new Intent(MainActivity.this, MipcaActivityCapture.class);
                intent_zxing.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(intent_zxing, 1);
                break;
        }
    }


}
