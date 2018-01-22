package com.example.micha.funwithfragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.zip.Inflater;

public class AlertActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup view = findViewById(R.id.content);
        getLayoutInflater().inflate(R.layout.activity_alert, view);
    }

    public void callAlert(View view) {
        if (view.getId() == R.id.defaultAlert) {
            AlertDialog alert = new AlertDialog.Builder(this).create();
            alert.setMessage("This is an alert using the default layout");
            alert.setTitle("Basic Alert");
            alert.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            alert.show();
        } else if (view.getId() == R.id.customAlert) {
            final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            LayoutInflater inflater = this.getLayoutInflater();
            final View dialogView = inflater.inflate(R.layout.custom_alert, null);
            dialog.setView(dialogView);
            dialog.setTitle("Custom Dialog");
            dialog.setMessage("An Eclipse");
            dialog.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            dialog.show();

        } else if (view.getId() == R.id.choiceAlert) {
            final CharSequence[] options = getTitles();

            final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Pick a page");
            dialog.setItems(options, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (options[i].equals(getResources().getString(R.string.pdf))) {
                        Intent intent = new Intent(dialog.getContext(), PDFActivity.class);
                        startActivity(intent);
                    }

                    else if (options[i].equals(R.string.messenger)) {

                    }

                    else if (options[i].equals(R.string.timer)) {

                    }

                    else if (options[i].equals(R.string.notification)) {
                        Intent intent = new Intent(dialog.getContext(), NotificationActivity.class);
                        startActivity(intent);
                    }

                }
            });
            dialog.show();


        }
    }

    private CharSequence[] getTitles() {
        CharSequence[] activities = new CharSequence[]{getResources().getString(R.string.pdf),
                getResources().getString(R.string.notification), getResources().getString(R.string.timer),
                getResources().getString(R.string.messenger)};

        return activities;
    }
}
