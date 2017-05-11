package com.example.mainguyen.sportshopapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.mainguyen.sportshopapp.Activities.EmployeeManagementActivity;
import com.example.mainguyen.sportshopapp.Activities.LoginActivity;
import com.example.mainguyen.sportshopapp.Activities.UserActivity;
import com.example.mainguyen.sportshopapp.App.AppController;
import com.example.mainguyen.sportshopapp.R;
import com.example.mainguyen.sportshopapp.Utils.Common;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by mai.nguyen on 26/04/2017.
 */

public class RegisterFragment extends Fragment {

    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_IDENTITYCARD = "identityCard";
    private static final String KEY_USERNAME = "userName";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_ROLE = "role";

    private static String url_register = Common.API_SERVER_IP + "api/user/registerPost";
    EditText edt_name;
    EditText edt_phone;
    EditText edt_address;
    Spinner edt_gender;
    EditText edt_identityCard;
    EditText edt_userName;
    EditText edt_password;
    Spinner edt_role;

    Button btn_register;
    Intent managementOfActivity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View register = inflater.inflate(R.layout.activity_register, container,false);

        edt_name = (EditText) register.findViewById(R.id.edt_fullname);
        edt_phone = (EditText) register.findViewById(R.id.edt_phone);
        edt_address = (EditText) register.findViewById(R.id.edt_Address);
        edt_gender = (Spinner) register.findViewById(R.id.spinner_gender);
        edt_identityCard = (EditText) register.findViewById(R.id.edt_identityCard);
        edt_userName = (EditText) register.findViewById(R.id.edt_userName);
        edt_password = (EditText) register.findViewById(R.id.edt_pass);
        edt_role = (Spinner) register.findViewById(R.id.spinner_role);
        btn_register = (Button) register.findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executePostDepartmentToServer();
            }
        });

        return register;
    }
    private void executePostDepartmentToServer() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_register,
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
                        Toast.makeText(getActivity(), LoginActivity.staff.getUsername(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Getting Image Name

                String name = edt_name.getText().toString().trim();
                String phone = edt_phone.getText().toString().trim();
                String address = edt_address.getText().toString().trim();
                String gender = edt_gender.getSelectedItem().toString().trim();
                String identityCard = edt_identityCard.getText().toString().trim();
                String userName = edt_userName.getText().toString().trim();
                String password = edt_password.getText().toString().trim();
                String role = edt_role.getSelectedItem().toString().trim();
                //Creating parameters
                Map<String, String> params = new Hashtable<String, String>();

                //Adding parameters
                params.put(KEY_NAME, name);
                params.put(KEY_PHONE, phone);
                params.put(KEY_ADDRESS, address);
                params.put(KEY_GENDER, gender);
                params.put(KEY_IDENTITYCARD, identityCard);
                params.put(KEY_USERNAME, userName);
                params.put(KEY_PASSWORD, password);
                params.put(KEY_ROLE, role);
                //returning parameters
                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(stringRequest);
    }
}
