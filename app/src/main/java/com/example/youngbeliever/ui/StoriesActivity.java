package com.example.youngbeliever.ui;

import android.content.Intent;
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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.StoriesModel;
import com.example.youngbeliever.utils.ActivityManager;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class StoriesActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    MaterialToolbar storiesToolbar;
    DrawerLayout storiesDrawer;
    NavigationView storiesNavigation;
    ActivityManager activityManager;
    StoriesViewModel storiesViewModel;
    RecyclerView storiesRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.stories_activity);

        storiesToolbar = findViewById(R.id.app_toolbar);
        storiesDrawer = findViewById(R.id.stories_drawer_layout);
        storiesNavigation = findViewById(R.id.stories_navigation_view);
        storiesRecycler = findViewById(R.id.stories_recycler);
        activityManager = (ActivityManager) getApplication();

        storiesViewModel = new ViewModelProvider(this).get(StoriesViewModel.class);

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
        storiesRecycler.setLayoutManager(new LinearLayoutManager(this));

        StoriesAdapter adapter = new StoriesAdapter();
        storiesRecycler.setAdapter(adapter);

        storiesViewModel.getStoryData();

        storiesViewModel.storiesData.observe(this, new Observer<ArrayList<StoriesModel>>()
        {
            @Override
            public void onChanged(ArrayList<StoriesModel> storiesModels)
            {
                adapter.setList(storiesModels, new StoriesAdapter.itemClickListener()
                {
                    @Override
                    public void onItemClick(StoriesModel storiesModel)
                    {
                        Intent intent = new Intent(StoriesActivity.this, StoriesPdfActivity.class);
                        intent.putExtra("pdf", storiesModel.getPdfPath()); // string path
                        startActivity(intent);
                    }
                });
            }
        });

        //Handles Back Behavior
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true)
        {
            @Override
            public void handleOnBackPressed()
            {
                if (storiesDrawer.isDrawerOpen(GravityCompat.START))
                {
                    storiesDrawer.closeDrawer(GravityCompat.START);

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
            storiesDrawer.closeDrawers();
        }
        else if (id == R.id.asmaa_allah)
        {
            activityManager.openActivityRemovingDuplicate(AsmaaAllahHosnaActivity.class);
        } else { return true;}

        new Handler().postDelayed(() -> storiesDrawer.closeDrawers(),200);
        return true;
    }
}