package com.raspieit.agung.raspieit.Views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raspieit.agung.raspieit.Adapters.ViewPageAdapter;
import com.raspieit.agung.raspieit.R;

/**
 * Created by agung on 05/03/17.
 */

public class ImageFragment extends Fragment {

    public ImageFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);

        ViewPager viewpage = (ViewPager)view.findViewById(R.id.viewPager);
        setupPageView(viewpage);

        TabLayout tabs = (TabLayout)view.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewpage);
        return view;
    }

    // add fragment to list in adapters
    public void setupPageView(ViewPager viewpage) {
        ViewPageAdapter viewpageadapter = new ViewPageAdapter(getChildFragmentManager());
        viewpageadapter.addFragment(new Sub1ImageFragment(), "Data");
        viewpageadapter.addFragment(new Sub2ImageFragment(), "Progress");
        viewpageadapter.addFragment(new Sub1ImageFragment(), "Hasil");
        viewpageadapter.addFragment(new Sub2ImageFragment(), "Galeri");
        viewpage.setAdapter(viewpageadapter);
    }
}
