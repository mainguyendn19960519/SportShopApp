package com.example.mainguyen.sportshopapp.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mainguyen.sportshopapp.R;
import com.example.mainguyen.sportshopapp.Title.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    }
}

