package com.example.youngbeliever.ui;

import android.content.Intent;
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
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class StoriesActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    MaterialToolbar storiesToolbar;
    DrawerLayout storiesDrawer;
    NavigationView storiesNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_stories);

        storiesToolbar = findViewById(R.id.app_toolbar);
        storiesDrawer = findViewById(R.id.stories_drawer_layout);
        storiesNavigation = findViewById(R.id.stories_navigation_view);

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
        Intent intent;

        if(id == R.id.home_page)
        {
            intent = new Intent(this, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else if(id == R.id.holy_quran)
        {
            intent = new Intent(this, QuranActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else if(id == R.id.arkan_eslam)
        {
            intent = new Intent(this, ArkanActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else if(id == R.id.al_azkar)
        {
            intent = new Intent(this, AzkarActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else if(id == R.id.al_duas)
        {
            intent = new Intent(this, DuasActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else if(id == R.id.stories)
        {
            storiesDrawer.closeDrawers();
        }
        else if (id == R.id.asmaa_allah)
        {
            intent = new Intent(this, AsmaaAllahHosnaActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else { return true;}

        new Handler().postDelayed(() -> storiesDrawer.closeDrawers(),200);
        return true;
    }
}