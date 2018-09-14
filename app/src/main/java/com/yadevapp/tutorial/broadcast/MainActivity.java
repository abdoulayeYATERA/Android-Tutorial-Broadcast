package com.yadevapp.tutorial.broadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private EditText mEditText;
    private Button mSendBroadcastButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.activity_main_edittext);
        mSendBroadcastButton = findViewById(R.id.activity_main_button);

        mSendBroadcastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                String textToSend = mEditText.getText().toString();
                Intent broadcastIntent = new Intent("com.yadevapp.tutorial.broadcast.intent.action.send");
                broadcastIntent.putExtra("text", textToSend);
                sendBroadcast(broadcastIntent);
            }
        });
    }
}
