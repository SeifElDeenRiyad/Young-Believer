package com.example.youngbeliever.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.AsmaaAllahHosnaModel;
import com.example.youngbeliever.utils.ActivityManager;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;


public class AsmaaAllahHosnaActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    MaterialToolbar asmaaAllahToolbar;
    DrawerLayout asmaaAllahDrawer;
    NavigationView asmaaAllahNavigation;
    ActivityManager activityManager;
    AsmaaAllahHosnaViewModel asmaaAllahViewModel;
    RecyclerView asmaaAllahRecycler;
    MaterialCardView dynamicCardView;
    TextView asmAllahMeaning;
    View overlay;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asmaa_allah_hosna_activity);

        asmaaAllahToolbar = findViewById(R.id.app_toolbar);
        asmaaAllahDrawer = findViewById(R.id.asmaa_allah_drawer_layout);
        asmaaAllahNavigation = findViewById(R.id.asmaa_allah_navigation_view);
        activityManager = (ActivityManager) getApplication();
        dynamicCardView = findViewById(R.id.card_view);
        asmAllahMeaning = findViewById(R.id.asm_allah_meaning);
        asmaaAllahRecycler = findViewById(R.id.asmaa_allah_recycler);
        overlay = findViewById(R.id.overlay_view);
        asmaaAllahViewModel = new ViewModelProvider(this).get(AsmaaAllahHosnaViewModel.class);

        setSupportActionBar(asmaaAllahToolbar);

        asmaaAllahNavigation.bringToFront();

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                asmaaAllahDrawer,
                asmaaAllahToolbar,
                R.string.openNavigationDrawer,
                R.string.closeNavigationDrawer
        );
        asmaaAllahDrawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        asmaaAllahNavigation.setNavigationItemSelectedListener(this);

        AsmaaAllahHosnaAdapter adapter = new AsmaaAllahHosnaAdapter();
        asmaaAllahRecycler.setAdapter(adapter);

        asmaaAllahViewModel.getAsmaaAllah();

        asmaaAllahViewModel.asmAllahData.observe(this, new Observer<ArrayList<AsmaaAllahHosnaModel>>()
        {
            @Override
            public void onChanged(ArrayList<AsmaaAllahHosnaModel> asmaaAllahHosnaModels)
            {
                adapter.setList(asmaaAllahHosnaModels, new AsmaaAllahHosnaAdapter.itemClickListener()
                {
                    @Override
                    public void onItemClick(AsmaaAllahHosnaModel asmaaAllahModel)
                    {
                        dynamicCardView.setVisibility(View.VISIBLE);
                        asmAllahMeaning.setText(asmaaAllahModel.getAsmAllahMeaning());
                        overlay.setVisibility(View.VISIBLE);
                    }
                });
            }
        });

        int noOfCol = 3;
        asmaaAllahRecycler.setLayoutManager(new GridLayoutManager(this, noOfCol));
        //direction to RTL
        //asmaaAllahRecycler.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
    }

    @Override
    public void onBackPressed()
    {
        if(asmaaAllahDrawer.isDrawerOpen(GravityCompat.START))
        {
            asmaaAllahDrawer.closeDrawer(GravityCompat.START);
        }
        else if(dynamicCardView.isShown())
        {
            dynamicCardView.setVisibility(View.GONE);
            overlay.setVisibility(View.GONE);
        }
        else {
            super.onBackPressed();
        }
    }

    public void onResume()
    {
        super.onResume();
        asmaaAllahNavigation.setCheckedItem(R.id.asmaa_allah);
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
            activityManager.openActivityRemovingDuplicate(StoriesActivity.class);
        }
        else if (id == R.id.asmaa_allah)
        {
            asmaaAllahDrawer.closeDrawers();
        } else { return true;}

        new Handler().postDelayed(() -> asmaaAllahDrawer.closeDrawers(),200);
        return true;
    }
}