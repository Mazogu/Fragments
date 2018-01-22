package com.example.micha.funwithfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

public class PDFActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup view = findViewById(R.id.content);
        getLayoutInflater().inflate(R.layout.activity_pdf,view);
    }
}
