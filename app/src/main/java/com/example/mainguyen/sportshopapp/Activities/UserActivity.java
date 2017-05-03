package com.example.mainguyen.sportshopapp.Activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v4.app.FragmentTransaction;
import com.example.mainguyen.sportshopapp.Fragment.UserFragment;
import com.example.mainguyen.sportshopapp.R;

public class UserActivity extends AppCompatActivity implements UserFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_management);
    }

    @Override
    public void onFragmentInteraction(Fragment fragment) {

        View fragmentContainer = findViewById(R.id.detail_container);
        if(fragmentContainer != null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.detail_container, fragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }else{
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            RegisterFragment registerFragment = new RegisterFragment();
//            ft.replace(R.id.idUserFragment, registerFragment);
//            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//            ft.commit();
        }
    }
}
