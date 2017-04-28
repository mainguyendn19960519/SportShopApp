package com.example.mainguyen.sportshopapp.Activities;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mainguyen.sportshopapp.Fragment.RegisterFragment;
import com.example.mainguyen.sportshopapp.Fragment.User_Fragment_test;
import com.example.mainguyen.sportshopapp.R;

public class User_Activity_Test extends AppCompatActivity implements User_Fragment_test.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_test);

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
            Intent intent = new Intent(this, Activity_Fragment_Test.class);
            startActivity(intent);

        }
    }
}
