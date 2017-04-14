package com.example.mainguyen.sportshopapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mainguyen.sportshopapp.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btNextScreenLogin =(Button) findViewById(R.id.btLogin);

        btNextScreenLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), UserActivity.class);
               // Log.e("n", inputName.getText() + "." + inputEmail.getText());

                startActivity(nextScreen);

            }
        });


    }
}
