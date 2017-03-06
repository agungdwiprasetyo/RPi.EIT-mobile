package com.raspieit.agung.raspieit.Activity;

import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.raspieit.agung.raspieit.Adapters.ViewPageAdapter;
import com.raspieit.agung.raspieit.R;
import com.raspieit.agung.raspieit.Fragment.HomeFragment;
import com.raspieit.agung.raspieit.Fragment.ImageFragment;
import com.raspieit.agung.raspieit.Fragment.InfoFragment;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabs;
    private Toolbar toolbar;
    private int[] tabIcons = {
            R.drawable.ic_home_black_24dp,
            R.drawable.ic_image,
            R.drawable.ic_dashboard_black_24dp,
            R.drawable.ic_desktop_mac_black_24dp
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));

        ViewPager viewpage = (ViewPager)findViewById(R.id.viewPager);
        setupPagerView(viewpage);

        tabs = (TabLayout)findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewpage);
        tabs.setOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(viewpage){
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);
                        int tabIconColor = ContextCompat.getColor(getBaseContext(), R.color.colorPrimary);
                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        super.onTabUnselected(tab);
                        int tabIconColor = ContextCompat.getColor(getBaseContext(), R.color.tabUnselectColor);
                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        super.onTabReselected(tab);
                    }
                }
        );
        setupTabIcons();
    }


    private void setupTabIcons() {
        tabs.getTabAt(0).setIcon(tabIcons[0]);
        tabs.getTabAt(1).setIcon(tabIcons[1]);
        tabs.getTabAt(2).setIcon(tabIcons[2]);
        tabs.getTabAt(3).setIcon(tabIcons[3]);
    }

    public void setupPagerView(ViewPager viewpage) {
        ViewPageAdapter viewpageadapter = new ViewPageAdapter(getSupportFragmentManager());
        viewpageadapter.addFragment(new HomeFragment(), getResources().getString(R.string.fragment1));
        viewpageadapter.addFragment(new ImageFragment(), getResources().getString(R.string.fragment2));
        viewpageadapter.addFragment(new InfoFragment(), getResources().getString(R.string.fragment3));
        viewpageadapter.addFragment(new ImageFragment(), getResources().getString(R.string.fragment4));
        viewpage.setAdapter(viewpageadapter);
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}
