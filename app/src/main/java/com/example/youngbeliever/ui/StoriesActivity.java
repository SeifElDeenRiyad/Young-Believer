package com.example.youngbeliever.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.youngbeliever.R;
import com.example.youngbeliever.utils.ActivityManager;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class StoriesActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    MaterialToolbar storiesToolbar;
    DrawerLayout storiesDrawer;
    NavigationView storiesNavigation;
    ActivityManager activityManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_stories);

        storiesToolbar = findViewById(R.id.app_toolbar);
        storiesDrawer = findViewById(R.id.stories_drawer_layout);
        storiesNavigation = findViewById(R.id.stories_navigation_view);
        activityManager = (ActivityManager) getApplication();

        setSupportActionBar(storiesToolbar);

        storiesNavigation.bringToFront();

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                storiesDrawer,
                storiesToolbar,
                R.string.openNavigationDrawer,
                R.string.closeNavigationDrawer
        );

        storiesDrawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        storiesNavigation.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed()
    {
        if(storiesDrawer.isDrawerOpen(GravityCompat.START))
        {
            storiesDrawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
    @Override
    public void onResume()
    {
        super.onResume();
        storiesNavigation.setCheckedItem(R.id.stories);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        int id = menuItem.getItemId();
        if(id == R.id.home_page)
        {
            activityManager.openActivityRemovingDuplicate(HomeActivity.class);
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
            storiesDrawer.closeDrawers();
        } else { return true;}

        new Handler().postDelayed(() -> storiesDrawer.closeDrawers(),200);
        return true;
    }
}