package com.example.youngbeliever.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.example.youngbeliever.R;
import com.example.youngbeliever.utils.ActivityManager;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ArkanEslamActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    MaterialToolbar arkanToolbar;
    DrawerLayout arkanDrawer;
    NavigationView arkanNavigation;
    ActivityManager activityManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arkan_activity);

        arkanToolbar = findViewById(R.id.app_toolbar);
        arkanDrawer = findViewById(R.id.arkan_drawer_layout);
        arkanNavigation = findViewById(R.id.arkan_navigation_view);
        ViewPager2 viewPager = findViewById(R.id.arkan_view_pager);
        TabLayout tabLayout = findViewById(R.id.arkan_tabs);
        activityManager = (ActivityManager) getApplication();

        setSupportActionBar(arkanToolbar);

        arkanNavigation.bringToFront();

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                arkanDrawer,
                arkanToolbar,
                R.string.openNavigationDrawer,
                R.string.closeNavigationDrawer
        );

        arkanDrawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        arkanNavigation.setNavigationItemSelectedListener(this);

        ArkanFragmentsAdapter adapter = new ArkanFragmentsAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0 -> tab.setText(getString(R.string.islam_pillar1)); // title for first tab
                        case 1 -> tab.setText(getString(R.string.islam_pillar2)); // second tab
                        case 2 -> tab.setText(getString(R.string.islam_pillar3));  // third tab
                        case 3 -> tab.setText(getString(R.string.islam_pillar4));  // fourth tab
                        case 4 -> tab.setText(getString(R.string.islam_pillar5));  // fifth tab
                    }
                }
        ).attach();

        //Handles Back Behavior
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed()
            {
                if (arkanDrawer.isDrawerOpen(GravityCompat.START))
                {
                    arkanDrawer.closeDrawer(GravityCompat.START);

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
        arkanNavigation.setCheckedItem(R.id.arkan_eslam);
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
            arkanDrawer.closeDrawers();
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

        new Handler().postDelayed(() -> arkanDrawer.closeDrawers(),200);
        return true;
    }
}