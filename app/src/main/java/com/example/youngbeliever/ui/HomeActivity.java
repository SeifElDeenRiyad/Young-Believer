package com.example.youngbeliever.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.youngbeliever.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.example.youngbeliever.utils.ActivityManager;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    MaterialToolbar homeToolbar;
    DrawerLayout homeDrawer;
    NavigationView homeNavigation;
    ActivityManager activityManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.home_activity);

        homeToolbar = findViewById(R.id.app_toolbar);
        homeDrawer = findViewById(R.id.home_drawer_layout);
        homeNavigation = findViewById(R.id.home_navigation_view);
        activityManager = (ActivityManager) getApplication();

        setSupportActionBar(homeToolbar);

        homeNavigation.bringToFront();

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                homeDrawer,
                homeToolbar,
                R.string.openNavigationDrawer,
                R.string.closeNavigationDrawer
        );

        homeDrawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        homeNavigation.setNavigationItemSelectedListener(this);

        //Handles Back Behavior
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true)
        {
            @Override
            public void handleOnBackPressed()
            {
                if (homeDrawer.isDrawerOpen(GravityCompat.START))
                {
                    homeDrawer.closeDrawer(GravityCompat.START);

                }
                else
                {
                    // default behavior (like old super.onBackPressed)
                    setEnabled(false);
                    getOnBackPressedDispatcher().onBackPressed();
                }
            }
        });
    }

    @Override
    public void onResume()
    {
        super.onResume();
        homeNavigation.setCheckedItem(R.id.home_page);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        int id = menuItem.getItemId();

        if(id == R.id.home_page)
        {
            homeDrawer.closeDrawers();
        }
        else if(id == R.id.holy_quran)
        {
            activityManager.openActivityRemovingDuplicate(QuranActivity.class);
        }
        else if(id == R.id.arkan_eslam)
        {
            activityManager.openActivityRemovingDuplicate(ArkanEslamActivity.class);
        }
        else if(id == R.id.al_azkar)
        {
            activityManager.openActivityRemovingDuplicate(AzkarActivity.class);
        }
        else if(id == R.id.al_duas)
        {
            activityManager.openActivityRemovingDuplicate(DuasActivity.class);
        }
        else if(id == R.id.stories)
        {
            activityManager.openActivityRemovingDuplicate(StoriesActivity.class);
        }
        else if (id == R.id.asmaa_allah)
        {
            activityManager.openActivityRemovingDuplicate(AsmaaAllahHosnaActivity.class);
        } else { return true;}

        new Handler().postDelayed(() -> homeDrawer.closeDrawers(),200);
        return true;
    }
}