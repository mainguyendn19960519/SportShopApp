package com.example.mainguyen.sportshopapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mainguyen.sportshopapp.Models.Order;
import com.example.mainguyen.sportshopapp.R;

import java.util.List;

/**
 * Created by nhan.ly on 5/5/2017.
 */

public class OrderAdapter extends BaseAdapter{
    private Activity activity;
    private LayoutInflater inflater;
    private List<Order> ordersList;

    public OrderAdapter(Activity activity, List<Order> departmentList) {
        this.activity = activity;
        this.ordersList = departmentList;
    }

    @Override
    public int getCount() {
        return ordersList.size();
    }

    @Override
    public Object getItem(int i) {
        return ordersList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null)
            view = inflater.inflate(R.layout.list_order_row, null);
        TextView order_id = (TextView) view.findViewById(R.id.order_id);
        TextView address = (TextView) view.findViewById(R.id.address);
        TextView phone = (TextView) view.findViewById(R.id.phone);
        TextView orderDate = (TextView) view.findViewById(R.id.order_date);
        TextView total = (TextView) view.findViewById(R.id.total);
        TextView customerName = (TextView) view.findViewById(R.id.customer_name);
        TextView status = (TextView) view.findViewById(R.id.status);

        // getting movie data for the row
       Order ordersss = ordersList.get(position);
        // ID
        order_id.setText("Order Id: " + String.valueOf(ordersss.getOrderId()));

        // Address
        address.setText("Address: " + String.valueOf(ordersss.getAddress()));

        // Phone
        phone.setText("Phone: " + String.valueOf(ordersss.getPhone()));

        // OrderDate
        orderDate.setText("Order Date: " + String.valueOf(ordersss.getOrderDate()));

        status.setText("Status: " + String.valueOf(ordersss.getStatus()));

        // User name
        total.setText("Total: " + String.valueOf(ordersss.getTotal()));

        // customer name
        customerName.setText("Customer Name: " + String.valueOf(ordersss.getCustomer_name()));
        // get id
        return view;
    }
}
