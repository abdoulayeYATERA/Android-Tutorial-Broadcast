package com.yadevapp.tutorial.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private BroadcastReceiver mBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.yadevapp.tutorial.broadcast.intent.action.send");

        mBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d(TAG, "onReceive: ");
                String textToSend = intent.getStringExtra("text");
                Toast.makeText(context, textToSend, Toast.LENGTH_LONG).show();
            }
        };

        registerReceiver(mBroadcastReceiver, intentFilter);
    }


    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        unregisterReceiver(mBroadcastReceiver);
        super.onDestroy();
    }
}
