package com.raspieit.agung.raspieit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.raspieit.agung.raspieit.Adapters.ViewPageAdapter;
import com.raspieit.agung.raspieit.Views.HomeFragment;
import com.raspieit.agung.raspieit.Views.ImageFragment;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment;
    private FragmentManager fragmentManager;
    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ViewPager viewpage = (ViewPager)findViewById(R.id.viewPager);
//        setupPageView(viewpage);
//
//        TabLayout tabs = (TabLayout)findViewById(R.id.tabs);
//        tabs.setupWithViewPager(viewpage);

        fragmentManager = getSupportFragmentManager();
        fragment = new HomeFragment();
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.content, fragment).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
//                        callFragment(new HomeFragment());
                        fragment = new HomeFragment();
                        break;
                    case R.id.navigation_dashboard:
//                        mTextMessage.setText(R.string.title_dashboard);
                        fragment = new ImageFragment();
                        break;
                    case R.id.navigation_notifications:
//                        mTextMessage.setText(R.string.title_notifications);
                        return true;
                    case R.id.navigation_image:
//                        mTextMessage.setText(R.string.title_image);
                        return true;
                }
                final FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.content, fragment).commit();
                return true;
            }

        });
    }
}
