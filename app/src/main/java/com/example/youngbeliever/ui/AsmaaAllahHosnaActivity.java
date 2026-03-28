package com.example.youngbeliever.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.AsmaaAllahHosnaModel;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;


public class AsmaaAllahHosnaActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    MaterialToolbar asmaaAllahToolbar;
    DrawerLayout asmaaAllahDrawer;
    NavigationView asmaaAllahNavigation;
    AsmaaAllahHosnaViewModel asmaaAllahViewModel;
    RecyclerView asmaaAllahRecycler;
    MaterialCardView dynamicCardView;
    TextView asmAllahMeaning;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asmaa_allah_hosna);

        asmaaAllahToolbar = findViewById(R.id.app_toolbar);
        asmaaAllahDrawer = findViewById(R.id.asmaa_allah_drawer_layout);
        asmaaAllahNavigation = findViewById(R.id.asmaa_allah_navigation_view);
        dynamicCardView = findViewById(R.id.card_view);
        asmAllahMeaning = findViewById(R.id.asm_allah_meaning);
        asmaaAllahRecycler = findViewById(R.id.asmaa_allah_recycler);
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
                    }
                });
            }
        });

        int noOfCol = 3;
        asmaaAllahRecycler.setLayoutManager(new GridLayoutManager(this, noOfCol));
        //direction to RTL
        asmaaAllahRecycler.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
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
        Intent intent;

        if(id == R.id.home_page)
        {
            intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.holy_quran)
        {
            intent = new Intent(this, QuranActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.arkan_eslam)
        {
            intent = new Intent(this, ArkanActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.al_azkar)
        {
            intent = new Intent(this, AzkarActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.al_duas)
        {
            intent = new Intent(this, DuasActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.stories)
        {
            intent = new Intent(this, StoriesActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.asmaa_allah)
        {
            asmaaAllahDrawer.closeDrawers();
        } else { return true;}

        new Handler().postDelayed(() -> asmaaAllahDrawer.closeDrawers(),200);
        return true;
    }
}