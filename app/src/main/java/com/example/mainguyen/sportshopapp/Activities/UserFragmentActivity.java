//package com.example.mainguyen.sportshopapp.Activities;
//
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
//import android.os.Bundle;
//import android.app.Fragment;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
//
//import com.example.mainguyen.sportshopapp.Fragment.ChangPasswordFragment;
//import com.example.mainguyen.sportshopapp.Fragment.DetailFragment;
//import com.example.mainguyen.sportshopapp.Fragment.RegisterFragment;
//import com.example.mainguyen.sportshopapp.Fragment.ShowStaffFragment;
//import com.example.mainguyen.sportshopapp.R;
//import com.example.mainguyen.sportshopapp.Title.BaseActivity;
//
//public class UserFragmentActivity extends BaseActivity{
//    DetailFragment frgDetail;
//    Button btnShow;
//    Button btnRegister;
//    Button btnChangePass;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user_fragment);
//
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        Fragment sf = new Fragment();
//        ft.add(R.id.myFragment, sf);
//        ft.commit();
//
//        btnShow = (Button) findViewById(R.id.btnShow);
//        btnRegister = (Button) findViewById(R.id.btnRegister);
//        btnChangePass = (Button) findViewById(R.id.btnChangPass);
//
//        btnShow.setOnClickListener(onButtonClick);
//        btnRegister.setOnClickListener(onButtonClick);
//        btnChangePass.setOnClickListener(onButtonClick);
//    }
//
//    Button.OnClickListener onButtonClick = new Button.OnClickListener(){
//        @Override
//        public void onClick(View v) {
//            frgDetail = (DetailFragment) getFragmentManager().findFragmentById(R.id.myFragment);
//            Fragment fragment = null;
//            if(frgDetail == null || !frgDetail.isInLayout()){
//                Toast.makeText(UserFragmentActivity.this, "Nham roi con",Toast.LENGTH_SHORT).show();
//            }else{
//                if(v == btnShow){
//                    fragment = new ShowStaffFragment();
//                }else if(v == btnRegister){
//                    fragment = new RegisterFragment();
//                }else if(v == btnChangePass){
//                    fragment = new ChangPasswordFragment();
//                }
//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                ft.replace(R.id.myFragment, fragment);
//                ft.commit();
//            }
//
//        }
//    };
//    @Override
//    public void onPermissionsGranted(int requestCode) {
//
//    }
//
//}
