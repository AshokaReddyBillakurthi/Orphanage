package com.orphanage.apps;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orphanage.apps.adapters.MenuItemAdapter;
import com.orphanage.apps.fragments.DonorRegistrationFragment;
import com.orphanage.apps.fragments.DonateFragment;
import com.orphanage.apps.fragments.GalleryFragment;
import com.orphanage.apps.fragments.HomeFragment;
import com.orphanage.apps.fragments.OurWorkFragment;
import com.orphanage.apps.fragments.RegisterFragment;
import com.orphanage.apps.fragments.VolunteerRegistrationFragment;
import com.orphanage.apps.model.MenuItem;
import com.orphanage.apps.utils.AppConstents;
import com.orphanage.apps.utils.DataManager;

import java.util.List;
import java.util.Stack;

public class HomeActivity extends BaseActivity {

    private DrawerLayout drawer;
    public LinearLayout llMenu;
    public LinearLayout llBack;
    private RecyclerView rvMenuList;
    private MenuItemAdapter menuAdapter;
    public BottomNavigationView navigation;
    public Stack<Fragment> fragmentStack = null;
    public String name = "";
    public TextView tvScreenTitle;
    private boolean doubleBackToExitPressedOnce = false;

    @Override
    int getRootLayout() {
        return R.layout.activity_dash_board;
    }

    @Override
    void initGUI() {
        drawer = findViewById(R.id.drawer);
        llMenu = findViewById(R.id.llMenu);
        llBack = findViewById(R.id.llBack);
        rvMenuList = findViewById(R.id.rvMenuList);
        rvMenuList.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
        menuAdapter = new MenuItemAdapter();
        rvMenuList.setAdapter(menuAdapter);

        tvScreenTitle = findViewById(R.id.tvScreenTitle);

        navigation = findViewById(R.id.navigationView);

        fragmentStack = new Stack<>();

        loadFragment(new HomeFragment());

        List<MenuItem> menuItemList = DataManager.getInstance(HomeActivity.this).getAllMenuItems();
        menuAdapter.refresh(menuItemList);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer,
                null, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };

        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        llMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(Gravity.LEFT);
                } else {
                    drawer.openDrawer(Gravity.LEFT);
                }
            }
        });

        llBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        setMenuVisible();
                        fragment = new HomeFragment();
                        name = AppConstents.HOME;
                        break;
                    case R.id.navigation_work:
                        setBackVisible();
                        fragment = new OurWorkFragment();
                        name = AppConstents.OUR_WORK;
                        break;
                    case R.id.navigation_donate:
                        setBackVisible();
                        fragment = new DonorRegistrationFragment();
                        name = AppConstents.DONATE;
                        break;
                    case R.id.navigation_gallery:
                        setBackVisible();
                        fragment = new GalleryFragment();
                        name = AppConstents.GALLERY;
                        break;
                    case R.id.navigation_user:
                        setBackVisible();
                        fragment = new VolunteerRegistrationFragment();
                        name = AppConstents.REGISTER;
                        break;
                }
                return loadFragment(fragment);
            }
        });

    }

    @Override
    void initData() {

    }

    public boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.slide_up_in, R.anim.slide_up_out)
                    .replace(R.id.container, fragment)
                    .commit();
            fragmentStack.add(fragment);
            return true;
        }
        return false;
    }

    public void openDrawer(){
        drawer.openDrawer(Gravity.LEFT);
    }

    public void closeDrawer(){
        drawer.closeDrawer(Gravity.LEFT);
    }

    @Override
    public void onBackPressed() {
        if (null!=fragmentStack&&!fragmentStack.isEmpty()&&fragmentStack.size()>1) {
            Fragment fragment = fragmentStack.pop();
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
            Fragment frag = fragmentStack.peek();
            if(frag instanceof HomeFragment){
                navigation.setSelectedItemId(R.id.navigation_home);
            }
            else if(frag instanceof OurWorkFragment){
                navigation.setSelectedItemId(R.id.navigation_work);
            }
            else if(frag instanceof DonateFragment){
                navigation.setSelectedItemId(R.id.navigation_donate);
            }
            else if(frag instanceof GalleryFragment){
                navigation.setSelectedItemId(R.id.navigation_gallery);
            }
            else if(frag instanceof RegisterFragment){
                navigation.setSelectedItemId(R.id.navigation_user);
            }
            else{
                loadFragment(frag);
            }
            fragmentStack.pop();
        }
        else{
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }
            this.doubleBackToExitPressedOnce = true;
            showToast("Please click BACK again to exit");
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }
    }

    public void setBackVisible(){
        llBack.setVisibility(View.VISIBLE);
        llMenu.setVisibility(View.GONE);
    }

    public void setMenuVisible(){
        llMenu.setVisibility(View.VISIBLE);
        llBack.setVisibility(View.GONE);
    }
}
