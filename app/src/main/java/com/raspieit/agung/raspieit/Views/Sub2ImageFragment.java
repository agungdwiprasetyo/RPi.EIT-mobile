package com.raspieit.agung.raspieit.Views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raspieit.agung.raspieit.R;

/**
 * Created by agung on 05/03/17.
 */

public class Sub2ImageFragment extends Fragment{
    public Sub2ImageFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_2, container, false);
        return view;
    }
}
