package com.example.youngbeliever.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.StoriesModel;
import com.example.youngbeliever.utils.BackButtonManager;
import com.example.youngbeliever.utils.DrawerNavigationAppBarManager;
import com.example.youngbeliever.utils.SpaceManager;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class StoriesActivity extends AppCompatActivity
{
    DrawerNavigationAppBarManager drawerNavigationAppBarManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stories_activity);
        StoriesViewModel storiesViewModel = new ViewModelProvider(this).get(StoriesViewModel.class);

        MaterialToolbar storiesToolbar = findViewById(R.id.app_toolbar);
        DrawerLayout storiesDrawer = findViewById(R.id.stories_drawer_layout);
        NavigationView storiesNavigation = findViewById(R.id.stories_navigation_view);
        RecyclerView storiesRecycler = findViewById(R.id.stories_recycler);

        BackButtonManager backButtonManager = new BackButtonManager();

        drawerNavigationAppBarManager = new DrawerNavigationAppBarManager();
        drawerNavigationAppBarManager.setup(this, storiesDrawer, storiesNavigation, storiesToolbar, R.id.stories);

        StoriesAdapter adapter = new StoriesAdapter();
        storiesRecycler.setLayoutManager(new LinearLayoutManager(this));
        storiesRecycler.setAdapter(adapter);
        //storiesRecycler.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        SpaceManager spaceManager = new SpaceManager();
        spaceManager.setBottomPadding(storiesRecycler);

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
        backButtonManager.backFromActivity(this, storiesDrawer);
    }
    @Override
    public void onResume()
    {
        super.onResume();
        drawerNavigationAppBarManager.syncCheckedItem();
    }
}