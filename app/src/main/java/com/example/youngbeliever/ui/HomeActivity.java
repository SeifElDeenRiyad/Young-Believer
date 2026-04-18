package com.example.youngbeliever.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.HomeModel;
import com.example.youngbeliever.utils.BackButtonManager;
import com.example.youngbeliever.utils.DrawerNavigationAppBarManager;
import com.example.youngbeliever.utils.SpaceManager;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity
{
    DrawerNavigationAppBarManager drawerNavigationAppBarManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        RecyclerView homeRecycler = findViewById(R.id.home_recycler);

        BackButtonManager backButtonManager = new BackButtonManager();
        drawerNavigationAppBarManager = new DrawerNavigationAppBarManager();

        drawerNavigationAppBarManager.initialize(this, R.id.home_drawer_layout,
                R.id.home_navigation_view, R.id.app_toolbar, R.id.home_page);

        HomeAdapter adapter = new HomeAdapter();
        int noOfCol = 2;
        homeRecycler.setLayoutManager(new GridLayoutManager(this, noOfCol));
        homeRecycler.setAdapter(adapter);

        SpaceManager spaceManager = new SpaceManager();
        spaceManager.setBottomPadding(homeRecycler);

        homeViewModel.getHomeSections();
        homeViewModel.homeSections.observe(this, new Observer<ArrayList<HomeModel>>()
        {
            @Override
            public void onChanged(ArrayList<HomeModel> homeSections)
            {
                adapter.setList(homeSections, new HomeAdapter.itemClickListener()
                {
                    @Override
                    public void onItemClick(HomeModel homeModel)
                    {
                        drawerNavigationAppBarManager.homeNavigation(homeModel);
                    }
                });
            }
        });

        backButtonManager.simpleBackFromActivity(this, drawerNavigationAppBarManager.getDrawer());
    }
    @Override
    public void onResume()
    {
        super.onResume();
        drawerNavigationAppBarManager.syncCheckedItem();
    }
}