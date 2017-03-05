package com.raspieit.agung.raspieit;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.raspieit.agung.raspieit.Adapters.ViewPageAdapter;
import com.raspieit.agung.raspieit.Views.HomeFragment;
import com.raspieit.agung.raspieit.Views.ImageFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewpage = (ViewPager)findViewById(R.id.viewPager);
        setupPageView(viewpage);

        TabLayout tabs = (TabLayout)findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewpage);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
//                        callFragment(new HomeFragment());
                        return true;
                    case R.id.navigation_dashboard:
//                        mTextMessage.setText(R.string.title_dashboard);
                        return true;
                    case R.id.navigation_notifications:
//                        mTextMessage.setText(R.string.title_notifications);
                        return true;
                    case R.id.navigation_image:
//                        mTextMessage.setText(R.string.title_image);
                        return true;
                }
                return false;
            }

        });
    }

    private void callFragment(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.content,fragment);
        transaction.commit();
    }

    // slide tab fragment
    public void setupPageView(ViewPager viewpage) {
        ViewPageAdapter viewpageadapter = new ViewPageAdapter(getSupportFragmentManager());
        viewpageadapter.addFragment(new HomeFragment(), "Home");
        viewpageadapter.addFragment(new ImageFragment(), "Image");
        viewpageadapter.addFragment(new HomeFragment(), "Image2");
        viewpageadapter.addFragment(new ImageFragment(), "Image3");
        viewpage.setAdapter(viewpageadapter);
    }
}
