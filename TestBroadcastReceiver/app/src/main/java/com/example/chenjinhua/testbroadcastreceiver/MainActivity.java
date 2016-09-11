package com.example.chenjinhua.testbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mShowTextView;
    private BroadcastReceiver mBroadcastReceiver;
    private Button mEnterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowTextView = (TextView) findViewById(R.id.show_textView);
        mShowTextView.setText("还没有设置提醒");
        mEnterButton = (Button) findViewById(R.id.enter_button);
        mEnterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        mBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if(intent != null){
                    if (TextUtils.equals(intent.getAction(),SecondActivity.COM_DIANPING_TEST_TI_XING_BROADCAST_RECEIVER)){
                        mShowTextView.setText("已设置提醒");
                    }
                }

            }
        };

    }
    @Override
    protected void onStart() {
        super.onStart();

        //动态注册广播
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SecondActivity.COM_DIANPING_TEST_TI_XING_BROADCAST_RECEIVER);
        registerReceiver(mBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        unregisterReceiver(mBroadcastReceiver);
    }
}
