package com.example.mainguyen.sportshopapp.Activities;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.mainguyen.sportshopapp.Adapter.StaffAdapter;
import com.example.mainguyen.sportshopapp.Models.Staffs;
import com.example.mainguyen.sportshopapp.R;
import com.example.mainguyen.sportshopapp.Title.BaseActivity;
import com.example.mainguyen.sportshopapp.Utils.Common;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class ShowStaffActivity extends BaseActivity{

    // url to get all titles list
    private static String url_all_staff = Common.API_SERVER_IP+"api/user/showStaff";
    // Log tag
    private static final String TAG = ShowStaffActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private List<Staffs> staffsList = new ArrayList<Staffs>();
    private ListView listView;
    private StaffAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("loi","        ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_staff);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
Log.v("loi","        ");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        listView = (ListView) findViewById(R.id.lv_staff);
        adapter = new StaffAdapter(this, staffsList);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
//        pDialog.setMessage("Loading...");
        pDialog.show();

        // changing action bar color
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#1b1b1b")));

        // Creating volley request obj
        JsonArrayRequest departReq = new JsonArrayRequest(url_all_staff,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

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
                                Log.v("loi","        ");
                                // adding movie to movies array
                                staffsList.add(staffs);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();

            }
        });
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
