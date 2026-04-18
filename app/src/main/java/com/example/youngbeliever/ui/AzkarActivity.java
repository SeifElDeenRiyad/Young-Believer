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

public class AzkarActivity extends AppCompatActivity
{
    DrawerNavigationAppBarManager drawerNavigationAppBarManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.azkar_activity);

        ViewPager2 viewPager = findViewById(R.id.azkar_view_pager);
        TabLayout tabLayout = findViewById(R.id.azkar_tabs);

        BackButtonManager backButtonManager = new BackButtonManager();
        drawerNavigationAppBarManager = new DrawerNavigationAppBarManager();

        drawerNavigationAppBarManager.initialize(this, R.id.azkar_drawer_layout,
                R.id.azkar_navigation_view, R.id.app_toolbar, R.id.al_azkar);

        AzkarFragmentAdapter adapter = new AzkarFragmentAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) ->
                {
                    switch (position)
                    {
                        case 0 -> tab.setText(getString(R.string.sbah_zekr)); // title for first tab
                        case 1 -> tab.setText(getString(R.string.msaa_zekr)); // second tab
                    }
                }).attach();

        backButtonManager.simpleBackFromActivity(this, drawerNavigationAppBarManager.getDrawer());
    }
    @Override
    public void onResume()
    {
        super.onResume();
        drawerNavigationAppBarManager.syncCheckedItem();
    }
}