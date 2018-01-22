package com.example.micha.funwithfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class MessengerActivity extends BaseActivity {

    private EditText text;
    private EditText phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup view = findViewById(R.id.content);
        getLayoutInflater().inflate(R.layout.activity_messenger, view);

        phoneNo = findViewById(R.id.phoneNumber);
        text = findViewById(R.id.messageText);
    }

    public void sendText(View view) {
        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage(phoneNo.getText().toString(),null,text.getText().toString(),
                null,null);

    }
}
