package com.example.mainguyen.sportshopapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mainguyen.sportshopapp.Models.Staffs;
import com.example.mainguyen.sportshopapp.R;

import java.util.List;

/**
 * Created by mai.nguyen on 19/04/2017.
 */

public class StaffAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Staffs> staffsList;

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
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (inflater == null)
            inflater = (LayoutInflater)activity
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
}
