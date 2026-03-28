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

public class AzkarActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    MaterialToolbar azkarToolbar;
    DrawerLayout azkarDrawer;
    NavigationView azkarNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_azkar);

        azkarToolbar = findViewById(R.id.app_toolbar);
        azkarDrawer = findViewById(R.id.azkar_drawer_layout);
        azkarNavigation = findViewById(R.id.azkar_navigation_view);

        setSupportActionBar(azkarToolbar);

        azkarNavigation.bringToFront();

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                azkarDrawer,
                azkarToolbar,
                R.string.openNavigationDrawer,
                R.string.closeNavigationDrawer
        );

        azkarDrawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        azkarNavigation.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed()
    {
        if(azkarDrawer.isDrawerOpen(GravityCompat.START))
        {
            azkarDrawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
    @Override
    public void onResume()
    {
        super.onResume();
        azkarNavigation.setCheckedItem(R.id.al_azkar);
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
            azkarDrawer.closeDrawers();
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

        new Handler().postDelayed(() -> azkarDrawer.closeDrawers(),200);
        return true;
    }
}