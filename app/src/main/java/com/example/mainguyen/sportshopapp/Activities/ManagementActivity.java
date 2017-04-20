package com.example.mainguyen.sportshopapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mainguyen.sportshopapp.R;

/**
 * Created by ha.dinh on 4/12/2017.
 */

    public class ManagementActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_management);
            Button btNextScreenLogin =(Button) findViewById(R.id.btn_userManagement);

                    btNextScreenLogin.setOnClickListener(new View.OnClickListener(){
                       public void onClick(View arg0) {
                           Intent nextScreen = new Intent(getApplicationContext(), UserManagementActivity.class);
                           startActivity(nextScreen);
                       }
                    });
        }
    }