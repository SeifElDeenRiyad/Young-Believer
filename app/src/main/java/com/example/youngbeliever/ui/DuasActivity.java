package com.example.youngbeliever.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.example.youngbeliever.R;
import com.example.youngbeliever.utils.BackButtonManager;
import com.example.youngbeliever.utils.DrawerNavigationAppBarManager;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class DuasActivity extends AppCompatActivity
{
    DrawerNavigationAppBarManager drawerNavigationAppBarManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.duas_activity);

        MaterialToolbar duasToolbar = findViewById(R.id.app_toolbar);
        DrawerLayout duasDrawer = findViewById(R.id.duas_drawer_layout);
        NavigationView duasNavigation = findViewById(R.id.duas_navigation_view);
        ViewPager2 viewPager = findViewById(R.id.duas_view_pager);
        TabLayout tabLayout = findViewById(R.id.duas_tabs);

        BackButtonManager backButtonManager = new BackButtonManager();

        drawerNavigationAppBarManager = new DrawerNavigationAppBarManager();
        drawerNavigationAppBarManager.setup(this, duasDrawer, duasNavigation, duasToolbar, R.id.al_duas);

        DuasFragmentsAdapter adapter = new DuasFragmentsAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) ->
                {
                    switch (position)
                    {
                        case 0 -> tab.setText(getString(R.string.quran_dua)); // title for first tab
                        case 1 -> tab.setText(getString(R.string.rasol_dua)); // second tab
                        case 2 -> tab.setText(getString(R.string.rosl_dua));  // third tab
                    }
                }
        ).attach();
        backButtonManager.backFromActivity(this, duasDrawer);
    }
    @Override
    public void onResume()
    {
        super.onResume();
        drawerNavigationAppBarManager.syncCheckedItem();
    }
}