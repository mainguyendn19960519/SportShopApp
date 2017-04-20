package com.example.mainguyen.sportshopapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mainguyen.sportshopapp.R;
import com.example.mainguyen.sportshopapp.Title.BaseActivity;

public class ManagementUserActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Button showStaff = (Button) findViewById(R.id.twshow);

        showStaff.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                Intent showStaff = new Intent(getApplicationContext(), ShowStaffActivity.class);
                startActivity(showStaff);
            }
        });
    }

    @Override
    public void onPermissionsGranted(int requestCode) {

    }
}
