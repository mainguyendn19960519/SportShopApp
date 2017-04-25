package com.example.mainguyen.sportshopapp.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mainguyen.sportshopapp.R;
import com.example.mainguyen.sportshopapp.Title.BaseActivity;

<<<<<<< HEAD
public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    @Override
    protected void onResume() {
        Log.v("Test onResume","Test onResume");
        super.onResume();
    }
=======
public class MainActivity extends BaseActivity {

>>>>>>> 351003f3cae4164f770f6f555c80ebdd7b3c590b
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("Home").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Login").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Search").setTabListener(this));
  }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        int nTabSelected = tab.getPosition();
        switch(nTabSelected){
            case 0:
                setContentView(R.layout.activity_main);
                break;
            case 1:
                Intent nextScreen = new Intent(getApplicationContext(), UserActivity.class);
                startActivity(nextScreen);
                break;
            case 2:
                setContentView(R.layout.activity_search);
                break;
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
=======

        Button btNextScreenLogin =(Button) findViewById(R.id.btLogin);

        btNextScreenLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
//                Intent userActivity = new Intent(getApplicationContext(), UserActivity.class);
//                startActivity(userActivity);
                Intent userActivity = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(userActivity);
            }
        });
    }

    @Override
    public void onPermissionsGranted(int requestCode) {
>>>>>>> 351003f3cae4164f770f6f555c80ebdd7b3c590b

    }
}

