package com.example.micha.funwithfragments;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.TimerTask;

public class BaseActivity extends AppCompatActivity {

    protected ListView list;
    protected DrawerLayout drawer;
    protected ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawer = findViewById(R.id.drawerLayout);
        list = findViewById(R.id.drawerID);
        final String title = getTitle().toString();
        addDrawer();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String select = ((TextView) view).getText().toString();
                if(select.equals(getResources().getString(R.string.pdf))){
                    Intent intent = new Intent(getApplicationContext(), PDFActivity.class);
                    startActivity(intent);
                }
                else if(select.equals(getResources().getString(R.string.messenger))){
                    Intent intent = new Intent(getApplicationContext(), MessengerActivity.class);
                    startActivity(intent);
                }
                else if(select.equals(getResources().getString(R.string.alert))){
                    Intent intent = new Intent(getApplicationContext(), AlertActivity.class);
                    startActivity(intent);
                }
                else if(select.equals(getResources().getString(R.string.notification))){
                    Intent intent = new Intent(getApplicationContext(),NotificationActivity.class);
                    startActivity(intent);
                }
                else if(select.equals(getResources().getString(R.string.timer))){
                    Intent intent = new Intent(getApplicationContext(), TimerActivity.class);
                    startActivity(intent);
                }

            }
        });

        toggle = new ActionBarDrawerToggle(this,drawer, R.string.onOpen,R.string.onClose){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(R.string.nav);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle(title);
                invalidateOptionsMenu();
            }
        };

        toggle.setDrawerIndicatorEnabled(true);
        drawer.addDrawerListener(toggle);

    }
    public void addDrawer(){
        String[] strings = getResources().getStringArray(R.array.activities);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,strings);
        list.setAdapter(adapter);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
