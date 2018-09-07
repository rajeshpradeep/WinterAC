package com.winterac.winter.ui.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


import com.winterac.winter.R;
import com.winterac.winter.adapter.SideMenuAdapter;

import java.util.Arrays;
import java.util.List;


public class NavigationActivity extends BaseActivity {

    private String TAG = getClass().getSimpleName();

    Toolbar toolbar;
    private DrawerLayout drawerLayout;
    Button loginButton;
    RecyclerView sideMenuRecyclerView;

    String[] menuTitle;
    List<String> menuTitleArrayList;
    SideMenuAdapter sideMenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
        setContentView(R.layout.activity_navigation);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer);
        loginButton = findViewById(R.id.loginButton);
        sideMenuRecyclerView = findViewById(R.id.nav_menu_list);
        setSupportActionBar(toolbar);

        menuTitleArrayList = Arrays.asList(getResources().getStringArray(R.array.nav_title));

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0) {

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

        initSideMenuList(menuTitleArrayList);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toastMessage(NavigationActivity.this, "Phase 2");
            }
        });
    }

    private void initSideMenuList(List<String> menuTitleArrayList) {
        sideMenuAdapter = new SideMenuAdapter(NavigationActivity.this, menuTitleArrayList);
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
}
