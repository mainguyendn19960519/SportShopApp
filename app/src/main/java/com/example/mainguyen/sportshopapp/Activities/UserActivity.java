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
    EditText edEmail;
    EditText edPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent i = getIntent();
        // Receiving the Data
        Button btnLogout=(Button) findViewById(R.id.btn_logout);
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

        edEmail = (EditText) findViewById(R.id.tv_inputEmai);
        edPass = (EditText) findViewById(R.id.tv_inputPassword);


        Button btnlogin= (Button) findViewById(R.id.btn_login);

        Button btncancel = (Button) findViewById(R.id.btn_cancel);
        btnlogin.setOnClickListener(new View.OnClickListener() {

            public  void onClick(View arg0){
                String email = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
                if(edEmail.getText().toString().length() == 0){
                    edEmail.setError("Email not entered!");
                    edEmail.requestFocus();
                }
                else if (!edEmail.getText().toString().contains("@") || !edEmail.getText().toString().contains(".")){
                    edEmail.setError("Please check your email! ");

                    edEmail.requestFocus();
                }
                else if(!edEmail.getText().toString().matches(email)){
                    edEmail.setError("Email don't exist Special charactors");
                    edEmail.requestFocus();
                }
                else if(edPass.getText().toString().length() == 0){
                    edPass.setError("Password not entered!");
                    edPass.requestFocus();
                }
                else if(edPass.getText().toString().length() < 8  ){
                    edPass.setError("Password should be atleast of 8 charactors!");

                    edPass.requestFocus();
                }

            }
        });
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
