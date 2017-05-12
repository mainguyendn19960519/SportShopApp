package com.example.mainguyen.sportshopapp.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.mainguyen.sportshopapp.App.AppController;
import com.example.mainguyen.sportshopapp.Models.Staffs;
import com.example.mainguyen.sportshopapp.R;
import com.example.mainguyen.sportshopapp.Title.BaseActivity;
import com.example.mainguyen.sportshopapp.Utils.Common;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Hashtable;
import java.util.Map;

public class LoginActivity extends BaseActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private static final String KEY_DEP_CODE = "email";
    private static final String KEY_DEP_NAME = "pass";
    private ProgressDialog pDialog;

    private static String url_login = Common.API_SERVER_IP+"api/user/login";
    EditText email;
    EditText password;
    Button btn_login;
    public static Staffs staff;

    Intent managementOfActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.tv_inputEmai);
        password = (EditText) findViewById(R.id.tv_inputPassword);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executePostDepartmentToServer();
            }
        });

    }

    private void  executePostDepartmentToServer() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_login,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        // Parse the JSON:
                        Log.d(TAG, s.toString());
                        hidePDialog();
                        try {

                            JSONObject result = new JSONObject(s);
                            String message = result.getString("message");
                            JSONObject dataObject = result.getJSONObject("dataObject");
                            JSONObject role = dataObject.getJSONObject("role");

                            staff = new Staffs(
                                    dataObject.getInt("staffId"),
                                    dataObject.getString("name"),
                                    dataObject.getString("address"),
                                    dataObject.getString("phone"),
                                    dataObject.getString("identityCard"),
                                    dataObject.getString("userName"),
                                    role.getInt("roleId"),
                                    message
                            );
                            if(staff.getRoleId() == 2){
                                Toast.makeText(LoginActivity.this, staff.getMessage(), Toast.LENGTH_LONG).show();
                                managementOfActivity = new Intent(getApplicationContext(), BossManagementActivity.class);
                                startActivity(managementOfActivity);
                            }else if(staff.getRoleId() == 3){
                                Toast.makeText(LoginActivity.this, staff.getMessage(), Toast.LENGTH_LONG).show();
                                managementOfActivity = new Intent(getApplicationContext(), EmployeeManagementActivity.class);
                                startActivity(managementOfActivity);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(LoginActivity.this, "Exception" , Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        hidePDialog();
                        Toast.makeText(LoginActivity.this, "Please check again!" , Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Getting Image Name
                String name = email.getText().toString().trim();
                String pass = password.getText().toString().trim();
                //Creating parameters
                Map<String,String> params = new Hashtable<String, String>();

                //Adding parameters
                params.put(KEY_DEP_CODE, name);
                params.put(KEY_DEP_NAME, pass);

                //returning parameters
                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(stringRequest);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
    @Override
    public void onPermissionsGranted(int requestCode) {

    }
}
