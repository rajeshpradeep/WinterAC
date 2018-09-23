package com.winterac.winter.ui.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


import com.winterac.winter.R;
import com.winterac.winter.adapter.SideMenuAdapter;
import com.winterac.winter.interfaces.INavigationListener;
import com.winterac.winter.ui.fragment.HomeFragment;
import com.winterac.winter.ui.fragment.ProductsFragment;
import com.winterac.winter.ui.fragment.ServicesFragment;
import com.winterac.winter.ui.fragment.SettingsFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NavigationActivity extends BaseActivity implements INavigationListener {

    private String TAG = getClass().getSimpleName();

    Toolbar toolbar;
    private DrawerLayout drawerLayout;
    Button loginButton;
    RecyclerView sideMenuRecyclerView;
    TextView toolbar_titleTextView, toolbar_sub_title;

    String[] menuTitle;
    List<String> menuTitleArrayList;
    SideMenuAdapter sideMenuAdapter;
    ArrayList<Integer> iconArrayList;

    public static final String BACK_STACK_ROOT_TAG = "root_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
        setContentView(R.layout.activity_navigation);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer);
        loginButton = findViewById(R.id.loginButton);
        sideMenuRecyclerView = findViewById(R.id.nav_menu_list);
        toolbar_titleTextView = findViewById(R.id.toolbar_title);
        toolbar_sub_title = findViewById(R.id.toolbar_sub_title);
//        toolbar.setNavigationIcon(R.drawable.ic_hamburger);
        setSupportActionBar(toolbar);

        iconArrayList = new ArrayList<>();
        iconArrayList.add(R.drawable.ic_home);
        iconArrayList.add(R.drawable.ic_services);
        iconArrayList.add(R.drawable.ic_products);
        iconArrayList.add(R.drawable.ic_settings);
        iconArrayList.add(R.drawable.ic_contacts);

        menuTitleArrayList = Arrays.asList(getResources().getStringArray(R.array.nav_title));

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        final ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.empty_value,  R.string.empty_value) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);

                setStatusBar();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }

            @SuppressLint("ResourceType")
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);

                try {
                    //int currentapiVersion = android.os.Build.VERSION.SDK_INT;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        // Do something for lollipop and above versions

                        Window window = getWindow();

                        // clear FLAG_TRANSLUCENT_STATUS flag:
                        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

                        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

                        // finally change the color to any color with transparency

                        window.setStatusBarColor(getResources().getColor(Color.TRANSPARENT));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        drawerLayout.requestLayout();
        setFragment();
        initSideMenuList(menuTitleArrayList);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toastMessage(NavigationActivity.this, "Phase 2");
            }
        });
    }

    //setting launching  fragment to dashboard
    public void setFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Log.e(TAG, "Set Dashboard Frag");
        HomeFragment home_fragment = new HomeFragment();
        FragmentTransaction home_fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        dash_fragmentTransaction.addToBackStack(null);
//        fragmentManager.popBackStack(Constants.BACK_STACK_ROOT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//        dash_fragmentTransaction.addToBackStack("no root");
        home_fragmentTransaction.replace(R.id.frame, home_fragment);
        home_fragmentTransaction.commit();
    }

    private void initSideMenuList(List<String> menuTitleArrayList) {
        sideMenuAdapter = new SideMenuAdapter(NavigationActivity.this, menuTitleArrayList, iconArrayList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(NavigationActivity.this);
        sideMenuRecyclerView.setLayoutManager(mLayoutManager);
        sideMenuRecyclerView.setItemAnimator(new DefaultItemAnimator());
        sideMenuRecyclerView.setAdapter(sideMenuAdapter);
        sideMenuRecyclerView.setNestedScrollingEnabled(false);
    }

    private void setStatusBar() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                // Do something for lollipop and above versions

                Window window = getWindow();

                // clear FLAG_TRANSLUCENT_STATUS flag:
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

                // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

                // finally change the color again
                window.setStatusBarColor(getResources().getColor(R.color.white));
            }
        } catch (Exception e) {
        }
    }

    private void onItemClick(int position) {
        drawerLayout.closeDrawers();
        switch (position) {
            case 0:
                replaceFragment(new HomeFragment());
                break;
            case 1:
                replaceFragment(new ServicesFragment());
                break;
            case 2:
                replaceFragment(new ProductsFragment());
                break;
            case 3:
                replaceFragment(new SettingsFragment());
                break;
            case 4:
                replaceFragment(new ServicesFragment());
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.frame);

        /*if (!currentFragment.getClass().equals(fragment.getClass())) {
            fragmentTransaction.addToBackStack(BACK_STACK_ROOT_TAG);
        }*/
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void menuSelected(int position, String menuTitle) {
        if(position == 0)
            toolbar_sub_title.setVisibility(View.VISIBLE);
        else
            toolbar_sub_title.setVisibility(View.GONE);
        onItemClick(position);
        toolbar_titleTextView.setText(menuTitle);
    }
}
