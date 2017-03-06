package com.raspieit.agung.raspieit.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raspieit.agung.raspieit.Activity.MainActivity;
import com.raspieit.agung.raspieit.R;

/**
 * Created by agung on 05/03/17.
 */

public class HomeFragment extends Fragment {

    public HomeFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

//        ((MainActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.app_name));

        return view;
    }
}
