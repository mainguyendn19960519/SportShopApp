package com.example.mainguyen.sportshopapp.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.mainguyen.sportshopapp.Activities.BossManagementActivity;
import com.example.mainguyen.sportshopapp.Activities.EmployeeManagementActivity;
import com.example.mainguyen.sportshopapp.Activities.LoginActivity;
import com.example.mainguyen.sportshopapp.Activities.UserActivity;
import com.example.mainguyen.sportshopapp.App.AppController;
import com.example.mainguyen.sportshopapp.Models.Staffs;
import com.example.mainguyen.sportshopapp.R;
import com.example.mainguyen.sportshopapp.Utils.Common;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by mai.nguyen on 26/04/2017.
 */

public class ChangPasswordFragment extends Fragment {

    private static final String KEY_USER_NAME = "userName";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_NEW_PASS = "newPassword";
    private static final String KEY_CONFIRM_PASS = "confirmPassword";

    private static String url_changePassword = Common.API_SERVER_IP + "api/user/changePasswordPost";
    EditText edt_oldPass;
    EditText edt_newPass;
    EditText edt_confirmPass;
    Button btn_changePass;
    Intent managementOfActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View changePass = inflater.inflate(R.layout.acivity_changepasswork, container, false);
        edt_oldPass = (EditText) changePass.findViewById(R.id.edt_oldPass);
        edt_newPass = (EditText) changePass.findViewById(R.id.edt_newPass);
        edt_confirmPass = (EditText) changePass.findViewById(R.id.edt_confirmPass);
        btn_changePass = (Button) changePass.findViewById(R.id.btn_ChangePass);
        btn_changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executePostDepartmentToServer();
            }
        });

        return changePass;
    }

    private void executePostDepartmentToServer() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_changePassword,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        // Parse the JSON:
                        try {
                            JSONObject result = new JSONObject(s);
                            int status = result.getInt("status");
                            String message = result.getString("message");
                            if(status == 1){
                                if(LoginActivity.staff.getRoleId() == 2){
                                    managementOfActivity = new Intent(getActivity(), UserActivity.class);
                                    startActivity(managementOfActivity);
                                }else if(LoginActivity.staff.getRoleId() == 3){
                                    managementOfActivity = new Intent(getActivity(), EmployeeManagementActivity.class);
                                    startActivity(managementOfActivity);
                                }
                            }
                            Toast.makeText(getActivity(), message , Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getActivity(), "Exception", Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(getActivity(), "Error, Please try again", Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Getting Image Name
                String userName = LoginActivity.staff.getUsername().toString().trim();
                String pass = edt_oldPass.getText().toString().trim();
                String newPass = edt_newPass.getText().toString().trim();
                String confirmPass = edt_confirmPass.getText().toString().trim();
                //Creating parameters
                Map<String, String> params = new Hashtable<String, String>();

                //Adding parameters
                params.put(KEY_USER_NAME, userName);
                params.put(KEY_PASSWORD, pass);
                params.put(KEY_NEW_PASS, newPass);
                params.put(KEY_CONFIRM_PASS, confirmPass);

                //returning parameters
                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(stringRequest);
    }
}
