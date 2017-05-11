package com.example.mainguyen.sportshopapp.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
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
import com.example.mainguyen.sportshopapp.Adapter.ProductAdapter;
import com.example.mainguyen.sportshopapp.App.AppController;
import com.example.mainguyen.sportshopapp.Models.Product;
import com.example.mainguyen.sportshopapp.Title.BaseActivity;
import com.example.mainguyen.sportshopapp.Utils.Common;
import com.example.mainguyen.sportshopapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;


/**
 * Created by ha.dinh on 4/19/2017.
 */

public class ProductActivity extends BaseActivity {
    // url to get all titles list
    private static String url_all_departments = Common.API_SERVER_IP+"api/product/";
    private static String url_delete_product_id = Common.API_SERVER_IP+"api/product/delete";
    // Log tag
    private static final String TAG = ProductActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private List<Product> productsList = new ArrayList<Product>();
    private ListView listView;
    private ProductAdapter adapter;
    private static final String KEY_DEP_ID = "id";
    private String srtId="null";
    private static final String KEY_DEP_IID = "productId";
    private static final String KEY_DEP_NAME = "productName";
    private static final String KEY_DEP_QUANTITY = "quantity";
    private static final String KEY_DEP_PRICE = "price";
    private static final String KEY_DEP_DATE = "dateUpdate";
    private static final String KEY_DEP_DESC = "description";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_product);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button nextAddProduct=(Button) findViewById(R.id.btnAddProduct);
        nextAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(getApplicationContext(),AddNewProductActivity.class);
                startActivity(next);
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        listView = (ListView) findViewById(R.id.lv_product);
        adapter = new ProductAdapter(this, productsList);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        // changing action bar color
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#1b1b1b")));

        // Creating volley request obj
        JsonArrayRequest departReq = new JsonArrayRequest(url_all_departments,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Product product = new Product();
                                product.setProductId(obj.getInt("productId"));
                                product.setProductName(obj.getString("productName"));
                                product.setQuantity(obj.getInt("quantity"));
                                product.setPrice(obj.getLong("price"));
                                product.setDateUpdate(obj.getString("dateUpdate"));
                                product.setStatus(obj.getInt("status"));
                                product.setDescription( obj.getString("description"));
                                //product.setSize(a);
                                product.setImage(Common.SERVER_DEPARTMENT_IMAGE_RESOURCE+obj.getString("image"));
                                Log.v("",Common.SERVER_DEPARTMENT_IMAGE_RESOURCE+obj.getString("image"));
                              // Log.v("sdsd",sizeObject.getString("typeOfSize"));

                                // adding movie to movies array
                                productsList.add(product);

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

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(departReq);

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
    public void OnclickDeleteProduct(View view){
        View parentRow = (View) view.getParent();

        ListView listView1 = (ListView) parentRow.getParent();

        final int position = listView1.getPositionForView(parentRow);

        srtId=String.valueOf(productsList.get(position).getProductId());
//        Log.v("In ra gia tri",srtId);
//
        executePostDataToServerToUpdate();
//        productsList.remove(position);
//
//        adapter.notifyDataSetChanged();

    }
private void executePostDataToServerToUpdate(){

    final ProgressDialog loading = ProgressDialog.show(this,"Uploading...","Please wait...",false,false);

    StringRequest stringRequest = new StringRequest(Request.Method.POST, url_delete_product_id,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {
                    //Disimissing the progress dialog
                    loading.dismiss();
                    //Showing toast message of the response
                    // Toast.makeText(ShowStaffActivity.this, s , Toast.LENGTH_LONG).show();
                    Toast.makeText(ProductActivity.this, "Delete Product Success!", Toast.LENGTH_LONG).show();
                    Intent backShowProduct=new Intent(getApplicationContext(),ProductActivity.class);
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
                    Toast.makeText(ProductActivity.this, "Delete Product Not Success!", Toast.LENGTH_LONG).show();
                }
            }){
        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            //Creating parameters
            Map<String,String> params = new Hashtable<String, String>();
            //Adding parameters

            Log.v("loi o day",srtId);
            params.put(KEY_DEP_ID, srtId);
            //returning parameters
            return params;
        }
    };
    AppController.getInstance().addToRequestQueue(stringRequest);}
    public void OnclickEditProduct(View view) {
            View parentRow = (View) view.getParent();

            ListView listView1 = (ListView) parentRow.getParent();

            final int position = listView1.getPositionForView(parentRow);

            Intent intent = new Intent(getApplicationContext(),EditProductActivity.class);
            intent.putExtra(KEY_DEP_IID,String.valueOf(productsList.get(position).getProductId()));
            intent.putExtra(KEY_DEP_NAME,productsList.get(position).getProductName());
            intent.putExtra(KEY_DEP_QUANTITY,String.valueOf(productsList.get(position).getQuantity()));
            intent.putExtra(KEY_DEP_PRICE,String.valueOf(productsList.get(position).getPrice()));
            intent.putExtra(KEY_DEP_DATE,productsList.get(position).getDateUpdate());
            intent.putExtra(KEY_DEP_DESC,productsList.get(position).getDescription());
            startActivity(intent);

        }
}
