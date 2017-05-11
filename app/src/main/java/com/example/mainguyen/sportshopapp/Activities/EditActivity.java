package com.example.mainguyen.sportshopapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.mainguyen.sportshopapp.App.AppController;
import com.example.mainguyen.sportshopapp.Fragment.ShowStaffFragment;
import com.example.mainguyen.sportshopapp.R;
import com.example.mainguyen.sportshopapp.Utils.Common;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by nhan.ly on 4/24/2017.
 */

public class EditActivity extends AppCompatActivity {


    private static String url_edit_InfoStaff = Common.API_SERVER_IP + "api/user/editInforfStaff/";
    private static final String STAFF_ID = "staffId";
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String PHONE = "phone";
    private static final String IDENTITYCARD = "identityCard";

    TextView id;
    EditText name;
    EditText phone;
    EditText password;
    EditText address;
    EditText username;
    TextView identitycard;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        Button btnEdit = (Button) findViewById(R.id.edit);

                id = (TextView) findViewById(R.id.staffId);
                name = (EditText) findViewById(R.id.edName);
                password = (EditText) findViewById(R.id.edPass);
                address = (EditText) findViewById(R.id.edAđress);
                username = (EditText) findViewById(R.id.edUserName);
                phone = (EditText) findViewById(R.id.edPhone);
                identitycard = (TextView) findViewById(R.id.identityCard);
                Intent item = getIntent();

                id.setText((item.getStringExtra(STAFF_ID)));
                name.setText(item.getStringExtra(NAME));
                password.setText(item.getStringExtra(PASSWORD));
                address.setText(item.getStringExtra(ADDRESS));
                username.setText(item.getStringExtra(USERNAME));
                phone.setText(item.getStringExtra(PHONE));
                identitycard.setText("IDENTITYCARD: " + item.getStringExtra(IDENTITYCARD));

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valueId = id.getText().toString().trim();
                String valueName = name.getText().toString().trim();
                String valuePass = password.getText().toString().trim();
                String valueAddr = address.getText().toString().trim();
                String valueUsername = username.getText().toString().trim();
                String valuePhone = phone.getText().toString().trim();

                executePostDataToServerToUpdate(valueId,valueName,valuePass, valueAddr, valueUsername, valuePhone);
            }
        });
    }

    private void executePostDataToServerToUpdate(final String valueId, final String valueName,
                                                 final String valuePass, final String valueAddr,
                                                 final String valueUsername, final String valuePhone) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_edit_InfoStaff,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        try {
                            JSONObject result = new JSONObject(s);
                            int status = result.getInt("status");
                            String message = result.getString("message");
                            if (status == 1) {
                                FrameLayout frame = (FrameLayout) findViewById(R.id.frg_edit);
                                ShowStaffFragment showStaffFragment = new ShowStaffFragment();
                                frame.removeAllViews();
                                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                                ft.replace(R.id.frg_edit, showStaffFragment);
                                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                                ft.commit();
                            }
                            Toast.makeText(EditActivity.this, message, Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(EditActivity.this, "Exception", Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        //Dismissing the progress dialog
                        Toast.makeText(EditActivity.this, "Error, Try Again!", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Creating parameters
                Map<String, String> params = new Hashtable<String, String>();
                Intent intent = getIntent();
                //Adding parameters
                params.put(STAFF_ID, valueId);
                params.put(ADDRESS, valueAddr);
                params.put(NAME, valueName);
                params.put(USERNAME, valueUsername);
                params.put(PASSWORD, valuePass);
                params.put(PHONE, valuePhone);
                return params;
            }
        };
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(stringRequest);
    }
}


