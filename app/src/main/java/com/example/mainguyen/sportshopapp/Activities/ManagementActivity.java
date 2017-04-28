package com.example.mainguyen.sportshopapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mainguyen.sportshopapp.R;
import com.example.mainguyen.sportshopapp.Title.BaseActivity;

/**
 * Created by ha.dinh on 4/12/2017.
 */

public class ManagementActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);

        Button btUserManagement = (Button) findViewById(R.id.btnUserManagement);

        btUserManagement.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
//                Intent managementUserActivity = new Intent(getApplicationContext(), ManagementUserActivity.class);
//                startActivity(managementUserActivity);

                Intent managementUserActivity = new Intent(getApplicationContext(), UserFragmentActivity.class);
                startActivity(managementUserActivity);
            }
        });
    }

    @Override
    public void onPermissionsGranted(int requestCode) {

    }
}