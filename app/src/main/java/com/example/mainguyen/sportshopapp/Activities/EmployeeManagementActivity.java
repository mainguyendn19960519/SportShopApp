package com.example.mainguyen.sportshopapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mainguyen.sportshopapp.Fragment.EmployeeFragment;
import com.example.mainguyen.sportshopapp.Fragment.UserFragment;
import com.example.mainguyen.sportshopapp.R;

/**
 * Created by ha.dinh on 4/26/2017.
 */

public class EmployeeManagementActivity extends AppCompatActivity implements EmployeeFragment.OnFragmentInteractionListener{

    View idEmployeeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_management);
        idEmployeeFragment = findViewById(R.id.idEmployeeFragment);
        if(idEmployeeFragment != null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            EmployeeFragment menuFragment = new EmployeeFragment();
            ft.replace(R.id.idEmployeeFragment, menuFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
    }
    @Override
    public void onFragmentInteraction(Fragment fragment) {
        if(idEmployeeFragment != null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.idEmployeeFragment, fragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }else{
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.detail_container, fragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }

    }

}
