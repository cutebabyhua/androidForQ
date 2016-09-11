package com.example.chenjinhua.testbroadcastreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by chenjinhua on 16/9/11.
 */
public class SecondActivity extends AppCompatActivity{
    public static final String COM_DIANPING_TEST_TI_XING_BROADCAST_RECEIVER = "com.dianping.test.tiXingBroadcastReceiver";
    private Button mTixingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        mTixingButton = (Button) findViewById(R.id.tixing_button);
        Button returnButton = (Button) findViewById(R.id.return_button);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        mTixingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //点击时发送广播
                Intent intent = new Intent();
                intent.setAction(COM_DIANPING_TEST_TI_XING_BROADCAST_RECEIVER);
                sendBroadcast(intent);
            }
        });
    }

}
