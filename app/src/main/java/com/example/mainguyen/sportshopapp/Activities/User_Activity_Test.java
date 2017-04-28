package com.example.mainguyen.sportshopapp.Activities;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mainguyen.sportshopapp.Fragment.RegisterFragment;
import com.example.mainguyen.sportshopapp.Fragment.UserFragment;
import com.example.mainguyen.sportshopapp.R;

public class User_Activity_Test extends AppCompatActivity implements UserFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_management);

        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        UserFragment userFragment = new UserFragment();
        ft.replace(R.id.idUserFragment, userFragment, "userFragment");
        ft.commit();
    }

    @Override
    public void onFragmentInteraction() {

        View fragment = findViewById(R.id.detail_container);
        if(fragment != null){
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            RegisterFragment registerFragment = new RegisterFragment();
            ft.replace(R.id.detail_container, registerFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }else{
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            Fragment userFragment = getSupportFragmentManager().findFragmentByTag("userFragment");
            if(userFragment != null)
                getSupportFragmentManager().beginTransaction().remove(userFragment).commit();
            RegisterFragment registerFragment = new RegisterFragment();
            ft.replace(R.id.idUserFragment, registerFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();

        }
    }
}
