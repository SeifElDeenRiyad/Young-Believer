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

public class DuasActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    MaterialToolbar duasToolbar;
    DrawerLayout duasDrawer;
    NavigationView duasNavigation;
    ActivityManager activityManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.duas_activity);

        duasToolbar = findViewById(R.id.app_toolbar);
        duasDrawer = findViewById(R.id.duas_drawer_layout);
        duasNavigation = findViewById(R.id.duas_navigation_view);
        ViewPager2 viewPager = findViewById(R.id.duas_view_pager);
        TabLayout tabLayout = findViewById(R.id.duas_tabs);
        activityManager = (ActivityManager) getApplication();

        setSupportActionBar(duasToolbar);

        duasNavigation.bringToFront();

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                duasDrawer,
                duasToolbar,
                R.string.openNavigationDrawer,
                R.string.closeNavigationDrawer
        );

        duasDrawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        duasNavigation.setNavigationItemSelectedListener(this);

        DuasFragmentsAdapter adapter = new DuasFragmentsAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0 -> tab.setText(getString(R.string.quran_dua)); // title for first tab
                        case 1 -> tab.setText(getString(R.string.rasol_dua)); // second tab
                        case 2 -> tab.setText(getString(R.string.rosl_dua));  // third tab
                    }
                }
        ).attach();

        //Handles Back Behavior
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true)
        {
            @Override
            public void handleOnBackPressed()
            {
                if (duasDrawer.isDrawerOpen(GravityCompat.START))
                {
                    duasDrawer.closeDrawer(GravityCompat.START);

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
        duasNavigation.setCheckedItem(R.id.al_duas);
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
            duasDrawer.closeDrawers();
        }
        else if(id == R.id.stories)
        {
            activityManager.openActivityRemovingDuplicate(StoriesActivity.class);
        }
        else if (id == R.id.asmaa_allah)
        {
            activityManager.openActivityRemovingDuplicate(AsmaaAllahHosnaActivity.class);
        } else { return true;}

        new Handler().postDelayed(() -> duasDrawer.closeDrawers(),200);
        return true;
    }
}