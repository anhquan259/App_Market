package com.naq.anhquan.app_market_kt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.naq.anhquan.app_market_kt.fragment.CartFragment;
import com.naq.anhquan.app_market_kt.fragment.FavoriteFragment;
import com.naq.anhquan.app_market_kt.fragment.HistoryFragment;
import com.naq.anhquan.app_market_kt.fragment.HomeFragment;
import com.naq.anhquan.app_market_kt.fragment.MyProfileFragment;
import com.naq.anhquan.app_market_kt.fragment.NoticeFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private TabLayout mTabLayout;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;
    //private ViewPager2 mViewPager2;
    //private MyViewPager2Adapter myViewPager2Adapter;

    public static final int FRAGMENT_HOME = 1;
    public static final int FRAGMENT_FAVORITE = 2;
    public static final int FRAGMENT_HISTORY = 3;
    public static final int FRAGMENT_MY_PROFILE = 4;
    public static final int FRAGMENT_NOTICE = 5;
    public static final int FRAGMENT_CART = 6;

    private int mCurrentFragment = FRAGMENT_HOME;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();

        /*myViewPager2Adapter = new MyViewPager2Adapter(this);
        mViewPager2.setAdapter(myViewPager2Adapter);*/

        navigationView.setNavigationItemSelectedListener(this);
        setSupportActionBar(toolbar);

        //start app
        replaceFragment(new HomeFragment());
        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
        bottomNavigationView.getMenu().findItem(R.id.bottom_home).setChecked(true);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id == R.id.bottom_home) {
                    openHomeFragment();

                    navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);

                } else if (id == R.id.bottom_notice) {
                    openNoticeFragment();
                    disableCheckedMenuNav(0);

                } else if (id == R.id.bottom_cart) {
                    openCartFragment();
                    disableCheckedMenuNav(0);

                } else if (id == R.id.bottom_my_profile) {
                    openProfileFragment();
                    disableCheckedMenuNav(0);
                }

                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        //menu_toolbar_nav
        if (id == R.id.menu_toolbar) {
            mDrawerLayout.openDrawer(GravityCompat.END);
        }

        //menu_toolbar_message
        if (id == R.id.menu_message) {
            //code...
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            openHomeFragment();

            bottomNavigationView.getMenu().findItem(R.id.bottom_home).setChecked(true);
            navigationView.getMenu().findItem(R.id.nav_my_profile).setChecked(false);

        } else if (id == R.id.nav_favorite) {
            openFavoriteFragment();
            disableCheckedBottomNav();

        } else if (id == R.id.nav_history) {
            openHistoryFragment();
            disableCheckedBottomNav();

        } else if (id == R.id.nav_my_profile) {
            openProfileFragment();
            disableCheckedBottomNav();

            navigationView.getMenu().findItem(R.id.nav_home).setChecked(false);
            navigationView.getMenu().findItem(R.id.nav_favorite).setChecked(false);
            navigationView.getMenu().findItem(R.id.nav_history).setChecked(false);

        } else if (id == R.id.nav_change_info) {
            //code...
            disableCheckedBottomNav();

        } else if (id == R.id.nav_logout) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));

        } else if (id == R.id.nav_exit) {

            //close app + release memory
            finishAffinity();
            System.exit(0);
        }

        mDrawerLayout.closeDrawer(GravityCompat.END);

        return true;
    }

    //------- open fragment -------//
    private void openHomeFragment() {

        if (mCurrentFragment != FRAGMENT_HOME) {
            replaceFragment(new HomeFragment());
            //mViewPager2.setCurrentItem(0);
            mCurrentFragment = FRAGMENT_HOME;
        }
    }

    private void openFavoriteFragment() {

        if (mCurrentFragment != FRAGMENT_FAVORITE) {
            replaceFragment(new FavoriteFragment());
            mCurrentFragment = FRAGMENT_FAVORITE;
        }
    }

    private void openHistoryFragment() {

        if (mCurrentFragment != FRAGMENT_HISTORY) {
            replaceFragment(new HistoryFragment());
            mCurrentFragment = FRAGMENT_HISTORY;
        }
    }

    private void openProfileFragment() {

        if (mCurrentFragment != FRAGMENT_MY_PROFILE) {
            replaceFragment(new MyProfileFragment());
            //mViewPager2.setCurrentItem(3);
            mCurrentFragment = FRAGMENT_MY_PROFILE;
        }
    }

    private void openNoticeFragment() {

        if (mCurrentFragment != FRAGMENT_NOTICE) {
            replaceFragment(new NoticeFragment());
            //mViewPager2.setCurrentItem(2);
            mCurrentFragment = FRAGMENT_NOTICE;
        }
    }

    private void openCartFragment() {

        if (mCurrentFragment != FRAGMENT_CART) {
            replaceFragment(new CartFragment());
            //mViewPager2.setCurrentItem(1);
            mCurrentFragment = FRAGMENT_CART;
        }
    }
    //-------------//

    //-------------//
    private void disableCheckedMenuNav(int code) {

        if (code == 0) {
            navigationView.getMenu().findItem(R.id.nav_home).setChecked(false);
            navigationView.getMenu().findItem(R.id.nav_favorite).setChecked(false);
            navigationView.getMenu().findItem(R.id.nav_history).setChecked(false);
            navigationView.getMenu().findItem(R.id.nav_my_profile).setChecked(false);
        }

        if (code == 1) {
            navigationView.getMenu().findItem(R.id.nav_home).setChecked(false);
            navigationView.getMenu().findItem(R.id.nav_favorite).setChecked(false);
            navigationView.getMenu().findItem(R.id.nav_history).setChecked(false);
            navigationView.getMenu().findItem(R.id.nav_my_profile).setChecked(true);
        }
    }

    private void disableCheckedBottomNav() {

        bottomNavigationView.getMenu().findItem(R.id.bottom_home).setChecked(false);
        bottomNavigationView.getMenu().findItem(R.id.bottom_cart).setChecked(false);
        bottomNavigationView.getMenu().findItem(R.id.bottom_notice).setChecked(false);
        bottomNavigationView.getMenu().findItem(R.id.bottom_my_profile).setChecked(false);

    }
    //-------------//

    private void replaceFragment(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.END)) {
            mDrawerLayout.closeDrawer(GravityCompat.END);

        } else {
            super.onBackPressed();
        }
    }

    private void Mapping() {

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        //mViewPager2 = (ViewPager2) findViewById(R.id.view_pager_2);
    }
}