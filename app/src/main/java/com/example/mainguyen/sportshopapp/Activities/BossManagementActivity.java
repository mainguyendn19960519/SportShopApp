package com.example.mainguyen.sportshopapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mainguyen.sportshopapp.R;
import com.example.mainguyen.sportshopapp.Title.BaseActivity;

/**
 * Created by ha.dinh on 4/12/2017.
 */

public class BossManagementActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boss_management);

        Button btUserManagement = (Button) findViewById(R.id.btnUserManagement);

        btUserManagement.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                Intent managementUserActivity = new Intent(getApplicationContext(), UserActivity.class);
                startActivity(managementUserActivity);
            }
        });
        Button btProductManagement = (Button) findViewById(R.id.btnProductManagement);

        btProductManagement.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                Intent managementProductActivity = new Intent(getApplicationContext(), ProductActivity.class);
                startActivity(managementProductActivity);
            }
        });
    }

    @Override
    public void onPermissionsGranted(int requestCode) {

    }
}