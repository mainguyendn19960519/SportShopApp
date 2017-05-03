package com.example.mainguyen.sportshopapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mainguyen.sportshopapp.R;

/**
 * Created by mai.nguyen on 26/04/2017.
 */

public class ChangPasswordFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.acivity_changepasswork, container, false);
    }
}
