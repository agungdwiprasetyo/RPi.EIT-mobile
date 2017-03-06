package com.raspieit.agung.raspieit.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.raspieit.agung.raspieit.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by agung on 05/03/17.
 */

public class InfoFragment extends Fragment {
    private String imageURL = "https://github.com/agungdwiprasetyo/EIT/raw/master/pic/inverseproblem.png";
    private ProgressBar spinner;
    private ImageView imgView;

    public InfoFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
//        getActivity().setTitle(getResources().getString(R.string.fragment3));

        imgView = (ImageView)view.findViewById(R.id.showImage);
        spinner = (ProgressBar)view.findViewById(R.id.progress_bar);
        spinner.setVisibility(View.VISIBLE);

        Picasso.with(getContext()).load(imageURL).into(imgView, new Callback() {
            @Override
            public void onSuccess() {
                spinner.setVisibility(View.GONE);
            }

            @Override
            public void onError() {
                //
            }
        });

        return view;
    }
}
