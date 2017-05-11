package com.example.mainguyen.sportshopapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.mainguyen.sportshopapp.Activities.EditActivity;
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
    Staffs staff;
    private static final String STAFF_ID = "staffId";
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String PHONE = "phone";
    private static final String IDENTITYCARD = "identityCard";
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
}
