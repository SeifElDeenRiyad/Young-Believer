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

public class ArkanEslamActivity extends AppCompatActivity
{
    DrawerNavigationAppBarManager drawerNavigationAppBarManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arkan_activity);

        MaterialToolbar arkanToolbar = findViewById(R.id.app_toolbar);
        DrawerLayout arkanDrawer = findViewById(R.id.arkan_drawer_layout);
        NavigationView arkanNavigation = findViewById(R.id.arkan_navigation_view);
        ViewPager2 viewPager = findViewById(R.id.arkan_view_pager);
        TabLayout tabLayout = findViewById(R.id.arkan_tabs);

        BackButtonManager backButtonManager = new BackButtonManager();

        drawerNavigationAppBarManager = new DrawerNavigationAppBarManager();
        drawerNavigationAppBarManager.setup(this, arkanDrawer, arkanNavigation, arkanToolbar, R.id.arkan_eslam);

        ArkanFragmentsAdapter adapter = new ArkanFragmentsAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) ->
                {
                    switch (position)
                    {
                        case 0 -> tab.setText(getString(R.string.islam_pillar1)); // title for first tab
                        case 1 -> tab.setText(getString(R.string.islam_pillar2)); // second tab
                        case 2 -> tab.setText(getString(R.string.islam_pillar3));  // third tab
                        case 3 -> tab.setText(getString(R.string.islam_pillar4));  // fourth tab
                        case 4 -> tab.setText(getString(R.string.islam_pillar5));  // fifth tab
                    }
                }
        ).attach();
        backButtonManager.simpleBackFromActivity(this, arkanDrawer);
    }
    @Override
    public void onResume()
    {
        super.onResume();
        drawerNavigationAppBarManager.syncCheckedItem();
    }
}