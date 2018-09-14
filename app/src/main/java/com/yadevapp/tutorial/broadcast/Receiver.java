package com.yadevapp.tutorial.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {
    private final String TAG = getClass().getSimpleName();
    
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: ");
        String textToSend = intent.getStringExtra("text");
        Toast.makeText(context, textToSend, Toast.LENGTH_LONG);
    }
}
