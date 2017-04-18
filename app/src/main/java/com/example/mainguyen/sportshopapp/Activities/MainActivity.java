package com.example.mainguyen.sportshopapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.example.mainguyen.sportshopapp.R;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    @Override
    protected void onResume() {
        Log.v("Test onResume","Test onResume");
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("Home").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Login").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Search").setTabListener(this));
    }

    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        int nTabSelected = tab.getPosition();
        switch(nTabSelected){
            case 0:
                setContentView(R.layout.activity_main);
                break;
            case 1:
//                setContentView(R.layout.activity_login);
                Intent nextScreen = new Intent(getApplicationContext(), UserActivity.class);
                startActivity(nextScreen);

//                Button btNextScreenLogin =(Button) findViewById(R.id.btn_login);
//
//                btNextScreenLogin.setOnClickListener(new View.OnClickListener(){
//                   public void onClick(View arg0) {
//                       Intent nextScreen = new Intent(getApplicationContext(), UserActivity.class);
//                       startActivity(nextScreen);
//                   }
//                });
                break;
            case 2:
                setContentView(R.layout.activity_search);
                break;
        }
    }
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
