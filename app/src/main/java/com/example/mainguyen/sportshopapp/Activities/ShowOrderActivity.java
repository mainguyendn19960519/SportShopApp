package com.example.mainguyen.sportshopapp.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.mainguyen.sportshopapp.Adapter.OrderAdapter;
import com.example.mainguyen.sportshopapp.App.AppController;
import com.example.mainguyen.sportshopapp.Models.Order;
import com.example.mainguyen.sportshopapp.R;
import com.example.mainguyen.sportshopapp.Title.BaseActivity;
import com.example.mainguyen.sportshopapp.Utils.Common;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by nhan.ly on 5/5/2017.
 */

public class ShowOrderActivity extends BaseActivity {
    private static String url_all_order = Common.API_SERVER_IP+"api/product/order";
    private static String url_delete_order_id = Common.API_SERVER_IP+"api/product/deleteOrder";
    private  static  final String STAFF_ID = "staffId";
    private  static  final String ORDER_ID = "order_id";
    private  static  final String ORDER_DATE = "order_date";
    private  static  final  String STATUS ="status";
    private  static  final  String TOTAL = "total";
    private static final String CUSTOMER_NAME = "customer_name";
    private static final String ADDRESS="address";
    private static final String PHONE="phone";
    private static final String KEY_ORDER_ID="orderId";

    // Log tag
    private static final String TAG = UserActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private List<Order> ordersList = new ArrayList<Order>();
    private ListView listView;
    private OrderAdapter adapter;
    Order orders;
    String orderID;
    private Button btDelete;
    TextView getID;
    int i=0;
    Button btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getID=(TextView) findViewById(R.id.get_order_id);
        setContentView(R.layout.activity_all_order);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Log.v("sdfdfdf","dfdfdfdfdfd");
        listView = (ListView) findViewById(R.id.lv_order);
        adapter = new OrderAdapter(this, ordersList);
        listView.setAdapter(adapter);
        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();
        JsonArrayRequest orderRequest = new JsonArrayRequest(url_all_order,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Order order_cus = new Order();
                                order_cus.setOrderId(obj.getInt("orderId"));
                                order_cus.setOrderDate(obj.getString("orderDate"));
                                order_cus.setStatus(obj.getBoolean("status"));
                                order_cus.setTotal(obj.getDouble("total"));
                                order_cus.setCustomer_name(obj.getString("customerName"));
                                order_cus.setAddress(obj.getString("address"));
                                order_cus.setPhone(obj.getString("phone"));

                                Log.v("sdfdfdf",obj.getString("phone"));
                                Log.v("sdfdfdf",obj.getString("customerName"));
                                Log.v("sdfdfdf",obj.getString("orderDate"));
                                Log.v("sdfdfdf",obj.getString("address"));
                                ordersList.add(order_cus);

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
                Log.v("sdfdfdf","dfdfdfdfdfghfghfgfgfgfgfgfgfgfgfgfgfgfgfgfgd");
                hidePDialog();
            }
        });
        AppController.getInstance().addToRequestQueue(orderRequest);
    };
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

    public void OnclickDeleteOrder(View view){
        View parentRow = (View) view.getParent();

        ListView listView1 = (ListView) parentRow.getParent();

        final int position = listView1.getPositionForView(parentRow);

        orderID=String.valueOf(ordersList.get(position).getOrderId());
//        Log.v("In ra gia tri",srtId);
//
        executePostDataToServerToUpdate();
//        productsList.remove(position);
//
//        adapter.notifyDataSetChanged();

    }
    private void executePostDataToServerToUpdate(){

        final ProgressDialog loading = ProgressDialog.show(this,"Uploading...","Please wait...",false,false);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_delete_order_id,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        //Disimissing the progress dialog
                        loading.dismiss();
                        //Showing toast message of the response
                        // Toast.makeText(ShowStaffActivity.this, s , Toast.LENGTH_LONG).show();
                        Toast.makeText(ShowOrderActivity.this, "Delete Order Success!", Toast.LENGTH_LONG).show();
                        Intent backShowProduct=new Intent(getApplicationContext(),ShowOrderActivity.class);
                        startActivity(backShowProduct);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        //Dismissing the progress dialog
                        loading.dismiss();

                        //Showing toast
                        //Toast.makeText(ProductActivity.this, volleyError.getMessage().toString(), Toast.LENGTH_LONG).show();
                        Toast.makeText(ShowOrderActivity.this, "Delete Product Not Success!", Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Creating parameters
                Map<String,String> params = new Hashtable<String, String>();
                //Adding parameters

                Log.v("loi o day",orderID);
                params.put(KEY_ORDER_ID, orderID);
                //returning parameters
                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(stringRequest);}
    @Override
    public void onPermissionsGranted(int requestCode) {

    }
}
