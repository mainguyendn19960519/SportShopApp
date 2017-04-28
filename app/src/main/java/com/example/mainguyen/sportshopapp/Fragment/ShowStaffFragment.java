package com.example.mainguyen.sportshopapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mainguyen.sportshopapp.Activities.ShowStaffActivity;
import com.example.mainguyen.sportshopapp.R;

/**
 * Created by mai.nguyen on 26/04/2017.
 */

public class ShowStaffFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewAllStaff = inflater.inflate(R.layout.activity_all_staff, container, false);
        return viewAllStaff;

    }
}
