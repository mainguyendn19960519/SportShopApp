package com.example.mainguyen.sportshopapp.Activities;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mainguyen.sportshopapp.R;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent i = getIntent();
        // Receiving the Data
        Button btnLogout=(Button) findViewById(R.id.btn_logout);
        Button btnLogin=(Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
//             if (textUserName.getText().equals("admin") && textPassWord.getText().equals("123456"))
//               {
                    Intent nextMNScreen = new Intent(getApplication(), ManagementActivity.class);
                   // Log.e("n", textUserName.getText() + ".=======================" + textPassWord.getText());
                    startActivity(nextMNScreen);
//                }else {
//                    Intent nextScreen = new Intent(getApplication(), UserActivity.class);
//                    startActivity(nextScreen);
//               }

            }
});
        // Binding Click event to Button
        btnLogout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                //Closing Main2Activity
                finish();
            }
        });
    }
}
