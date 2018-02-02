package com.initpointdk.mintain_v1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private NoSwipePager pager;
    private BottomBarAdapter pagerAdapter;

    private static final int NUM_PAGES = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav_view);
        pager = (NoSwipePager) findViewById(R.id.viewpager_fragmentholder);
        pager.setPagingEnabled(false);
        pager.setOffscreenPageLimit(4);
        pagerAdapter = new BottomBarAdapter(getSupportFragmentManager(), NUM_PAGES);
        buildFragmentsList();
        pager.setAdapter(pagerAdapter);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.bottom_nav_view_discover_btn:
                                switchFragments(0);
                                return true;
                            case R.id.bottom_nav_view_library_btn:
                                switchFragments(1);
                                return true;
                            case R.id.bottom_nav_view_activity_btn:
                                switchFragments(2);
                                return true;
                            case R.id.bottom_nav_view_profile_btn:
                                switchFragments(3);
                                return true;
                        }
                        return false;
                    }
                });
    }
    private void buildFragmentsList() {
        Fragment discover = new DiscoverFragment();
        Fragment library = BlankFragment.newInstance("Library");
        Fragment activity = new ActivitiesFragment();
        Fragment profile = new ProfileFragment();

        pagerAdapter.addFragments(discover);
        pagerAdapter.addFragments(library);
        pagerAdapter.addFragments(activity);
        pagerAdapter.addFragments(profile);
    }

    public class BottomBarAdapter extends SmartFragmentStatePagerAdapter {
        private final List<Fragment> fragments = new ArrayList<>();

        public BottomBarAdapter(FragmentManager fragmentManager, int numPages) {
            super(fragmentManager, numPages);
        }
        public void addFragments(Fragment fragment) {
            fragments.add(fragment);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    public void switchFragments(final int pos){
        if(pos == pager.getCurrentItem())
            return;

        pager.getRootView().post(new Runnable() {
            @Override
            public void run() {
                pager.setCurrentItem(pos);
                if(pos == 0)
                    setSupportActionBar(DiscoverFragment.toolbar);
                else if(pos == 2)
                    setSupportActionBar(ActivitiesFragment.toolbar);
                else if(pos == 3)
                    setSupportActionBar(ProfileFragment.toolbar);
            }
        });
    }
}
