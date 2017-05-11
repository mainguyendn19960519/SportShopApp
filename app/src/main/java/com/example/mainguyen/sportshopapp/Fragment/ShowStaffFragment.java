package com.example.mainguyen.sportshopapp.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.mainguyen.sportshopapp.Adapter.StaffAdapter;
import com.example.mainguyen.sportshopapp.App.AppController;
import com.example.mainguyen.sportshopapp.Models.Staffs;
import com.example.mainguyen.sportshopapp.R;
import com.example.mainguyen.sportshopapp.Utils.Common;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by mai.nguyen on 26/04/2017.
 */

public class ShowStaffFragment extends Fragment {
    // url to get all titles list
    private static String url_all_staff = Common.API_SERVER_IP+"api/user/showStaff";
    private static String url_deleteacount_id = Common.API_SERVER_IP+"api/user/delete";
    // Log tag
    private static final String TAG = ShowStaffFragment.class.getSimpleName();
    private static final String STAFF_ID="staff_Id";

    private List<Staffs> staffsList = new ArrayList<Staffs>();
    private ListView listView;
    private StaffAdapter adapter;
    public String strId;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View viewAllStaff = inflater.inflate(R.layout.activity_all_staff, container, false);

        listView = (ListView) viewAllStaff.findViewById(R.id.lv_staff);
        adapter = new StaffAdapter(getActivity(), staffsList);
        listView.setAdapter(adapter);

        JsonArrayRequest staffReq = new JsonArrayRequest(url_all_staff,
                new Response.Listener<JSONArray>(){
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                Staffs staffs = new Staffs();
                                staffs.setStaffId(obj.getInt("staffId"));
                                staffs.setName(obj.getString("name"));
                                staffs.setAddress(obj.getString("address"));
                                staffs.setPhone( obj.getString("phone"));
                                staffs.setIdentityCard( obj.getString("identityCard"));
                                staffs.setUsername( obj.getString("userName"));
                                staffs.setPassword( obj.getString("descriptionPassword"));
                                staffsList.add(staffs);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        Button btndelete =(Button) viewAllStaff.findViewById(R.id.bntDelete);
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View parentRow = (View) view.getParent();

                ListView listView1 = (ListView) parentRow.getParent();

                final int position = listView1.getPositionForView(parentRow);

                strId=String.valueOf(staffsList.get(position).getStaffId());

                executePostDataToServerToUpdate1();
                staffsList.remove(position);

                adapter.notifyDataSetChanged();

            }
        });
        AppController.getInstance().addToRequestQueue(staffReq);
        return viewAllStaff;

    }
    private void executePostDataToServerToUpdate1(){

        final ProgressDialog loading = ProgressDialog.show(getContext()
                ,"Uploading...","Please wait...",false,false);


        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_deleteacount_id,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        //Disimissing the progress dialog
                        loading.dismiss();
                        //Showing toast message of the response
                        // Toast.makeText(ShowStaffActivity.this, s , Toast.LENGTH_LONG).show();
                        Toast.makeText(getContext(), "Delete  User Success!", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        //Dismissing the progress dialog
                        loading.dismiss();

                        //Showing toast
                        Toast.makeText(getContext(), volleyError.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Creating parameters
                Map<String,String> params = new Hashtable<String, String>();
                //Adding parameters

                params.put(STAFF_ID, strId);
                //  params.put(IDENTITYCARD, valueIdentitycard);
                //returning parameters
                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(stringRequest);}


}
