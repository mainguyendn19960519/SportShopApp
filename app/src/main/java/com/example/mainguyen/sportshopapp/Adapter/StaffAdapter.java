package com.example.mainguyen.sportshopapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.mainguyen.sportshopapp.Activities.EditActivity;
import com.example.mainguyen.sportshopapp.App.AppController;
import com.example.mainguyen.sportshopapp.Fragment.ShowStaffFragment;
import com.example.mainguyen.sportshopapp.Models.Staffs;
import com.example.mainguyen.sportshopapp.R;
import com.example.mainguyen.sportshopapp.Utils.Common;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by mai.nguyen on 19/04/2017.
 */

public class StaffAdapter extends BaseAdapter {
    private static String url_deleteacount_id = Common.API_SERVER_IP + "api/user/delete/";
    private Activity activity;
    private LayoutInflater inflater;
    private List<Staffs> staffsList;
    private static final String STAFF_ID = "staffId";
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String PHONE = "phone";
    private static final String IDENTITYCARD = "identityCard";

    public String strId;
//    private Context context;
    public StaffAdapter(Activity activity, List<Staffs> departmentList) {
        this.activity = activity;
        this.staffsList = departmentList;
    }

    @Override
    public int getCount() {
        return staffsList.size();
    }

    @Override
    public Object getItem(int i) {
        return staffsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null)
            view = inflater.inflate(R.layout.list_staff_row, null);

        TextView staffId = (TextView) view.findViewById(R.id.staffId);
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView address = (TextView) view.findViewById(R.id.address);
        TextView phone = (TextView) view.findViewById(R.id.phone);
        TextView identityCard = (TextView) view.findViewById(R.id.identityCard);
        TextView userName = (TextView) view.findViewById(R.id.userName);
        TextView password = (TextView) view.findViewById(R.id.password);
        Button btndelete=(Button) view.findViewById(R.id.bntDelete);
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View parentRow = (View) view.getParent();

                ListView listView1 = (ListView) parentRow.getParent();

                final int position = listView1.getPositionForView(parentRow);

                strId = String.valueOf(staffsList.get(position).getStaffId());

                executePostDataToServerToUpdate1();

                upload(position);

            }
        });

        Button bntEdit = (Button) view.findViewById(R.id.btnEdit);
        bntEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),EditActivity.class);
                intent.putExtra(STAFF_ID,String.valueOf(staffsList.get(position).getStaffId()));
                intent.putExtra(NAME,staffsList.get(position).getName());
                intent.putExtra(ADDRESS,staffsList.get(position).getAddress());
                intent.putExtra(PHONE,staffsList.get(position).getPhone());
                intent.putExtra(IDENTITYCARD,staffsList.get(position).getIdentityCard());
                intent.putExtra(USERNAME,staffsList.get(position).getUsername());
                intent.putExtra(PASSWORD,staffsList.get(position).getPassword());
                view.getContext().startActivity(intent);
            }
        });

        // getting movie data for the row
        Staffs staffs = staffsList.get(position);

        // Id
        staffId.setText("ID: " + String.valueOf(staffs.getStaffId()));

        // Name
        name.setText("Name: " + String.valueOf(staffs.getName()));

        // Address
        address.setText("Address: " + String.valueOf(staffs.getAddress()));

        // Phone
        phone.setText("Phone: " + String.valueOf(staffs.getPhone()));

        // IdentityCard
        identityCard.setText("Identity Card: " + String.valueOf(staffs.getIdentityCard()));

        // User name
        userName.setText("User name: " + String.valueOf(staffs.getUsername()));

        // Password
        password.setText("Password: " + String.valueOf(staffs.getPassword()));

        return view;
    }

    public synchronized void upload(int postision){

        staffsList.remove(postision);
        notifyDataSetChanged();

    }
    ///
    private void executePostDataToServerToUpdate1(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_deleteacount_id,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        try {
                            JSONObject result = new JSONObject(s);
                            String message = result.getString("message");
                            Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(activity, "Exception", Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        Toast.makeText(activity, "Error, Tray Again!", Toast.LENGTH_LONG).show();
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
