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

public class ArkanActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    MaterialToolbar arkanToolbar;
    DrawerLayout arkanDrawer;
    NavigationView arkanNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_arkan);

        arkanToolbar = findViewById(R.id.app_toolbar);
        arkanDrawer = findViewById(R.id.arkan_drawer_layout);
        arkanNavigation = findViewById(R.id.arkan_navigation_view);

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
    }

    @Override
    public void onBackPressed()
    {
        if(arkanDrawer.isDrawerOpen(GravityCompat.START))
        {
            arkanDrawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
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
            arkanDrawer.closeDrawers();
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
            intent = new Intent(this, StoriesActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else if (id == R.id.asmaa_allah)
        {
            intent = new Intent(this, AsmaaAllahHosnaActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else { return true;}

        new Handler().postDelayed(() -> arkanDrawer.closeDrawers(),200);
        return true;
    }
}