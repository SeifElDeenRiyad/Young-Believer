package com.example.youngbeliever.utils;

import android.content.Intent;
import android.os.Handler;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.HomeModel;
import com.example.youngbeliever.ui.ArkanEslamActivity;
import com.example.youngbeliever.ui.AsmaaAllahHosnaActivity;
import com.example.youngbeliever.ui.AzkarActivity;
import com.example.youngbeliever.ui.DuasActivity;
import com.example.youngbeliever.ui.HomeActivity;
import com.example.youngbeliever.ui.QuranActivity;
import com.example.youngbeliever.ui.StoriesActivity;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

//helper class that connects the drawer with the action bar and the navigation UI
//and is responsible for the navigation logic between activities
public class DrawerNavigationAppBarManager implements NavigationView.OnNavigationItemSelectedListener
{
    private ActivityManager activityManager;
    private DrawerLayout drawer;
    private NavigationView navigation;
    private int currentItemId;

    public void setup(AppCompatActivity activity,DrawerLayout drawer,
                      NavigationView navigation, MaterialToolbar toolbar,
                      int currentItemId)
    {
        this.drawer = drawer;
        this.navigation = navigation;
        this.currentItemId = currentItemId;
        this.activityManager = (ActivityManager) activity.getApplication();

        activity.setSupportActionBar(toolbar);
        navigation.bringToFront();

        //connects the drawer layout with the menu icon in action bar
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                activity,
                drawer,
                toolbar,
                R.string.openNavigationDrawer,
                R.string.closeNavigationDrawer
        );
        //adds listener and is synced with user interactions
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigation.setNavigationItemSelectedListener(this);
    }

    //function to maintain the checked state when the activity is resumed
    public void syncCheckedItem()
    {
        navigation.setCheckedItem(currentItemId);
    }

    //function handles home sections navigation
    public void homeNavigation(HomeModel homeModel)
    {
        if(homeModel.getSectionName() == R.string.holy_quran)
        {
            activityManager.openActivityRemovingDuplicate(QuranActivity.class);
        }
        else if(homeModel.getSectionName() == R.string.islam_pillars)
        {
            activityManager.openActivityRemovingDuplicate(ArkanEslamActivity.class);
        }
        else if(homeModel.getSectionName() == R.string.al_azkar)
        {
            activityManager.openActivityRemovingDuplicate(AzkarActivity.class);
        }
        else if(homeModel.getSectionName() == R.string.duas)
        {
            activityManager.openActivityRemovingDuplicate(DuasActivity.class);
        }
        else if(homeModel.getSectionName() == R.string.prophets_stories)
        {
            activityManager.openActivityRemovingDuplicate(StoriesActivity.class);
        }
        else if(homeModel.getSectionName() == R.string.asmaa_allah_hosna)
        {
            activityManager.openActivityRemovingDuplicate(AsmaaAllahHosnaActivity.class);
        }
    }
    //function handles the navigation logic between activities
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        int id = menuItem.getItemId();

        if(id == currentItemId)
        {
            drawer.closeDrawers();
        }
        else if(id == R.id.home_page)
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
            activityManager.openActivityRemovingDuplicate(AsmaaAllahHosnaActivity.class);
        } else { return true;}

        new Handler().postDelayed(() -> drawer.closeDrawers(),200);
        return true;
    }
}