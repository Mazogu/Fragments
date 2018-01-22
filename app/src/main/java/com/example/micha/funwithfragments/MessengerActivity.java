package com.example.micha.funwithfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class MessengerActivity extends AppCompatActivity {

    private EditText text;
    private EditText phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
        phoneNo = findViewById(R.id.phoneNumber);
        text = findViewById(R.id.messageText);
    }

    public void sendText(View view) {
        SmsManager manager = SmsManager.getDefault();
    }
}
