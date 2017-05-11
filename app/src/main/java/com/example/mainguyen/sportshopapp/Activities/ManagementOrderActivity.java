package com.example.mainguyen.sportshopapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mainguyen.sportshopapp.R;
import com.example.mainguyen.sportshopapp.Title.BaseActivity;

/**
 * Created by nhan.ly on 5/8/2017.
 */

public class ManagementOrderActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Button orderproduct = (Button) findViewById(R.id.twdshowOrder);

        orderproduct.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                Intent showOrder = new Intent(getApplicationContext(), ShowOrderActivity.class);
                startActivity(showOrder);
            }
        });


    }
    @Override
    public void onPermissionsGranted(int requestCode) {

    }

}
