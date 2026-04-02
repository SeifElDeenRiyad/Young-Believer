package com.example.youngbeliever.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.AsmaaAllahHosnaModel;
import com.example.youngbeliever.utils.BackButtonManager;
import com.example.youngbeliever.utils.DrawerNavigationAppBarManager;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;


public class AsmaaAllahHosnaActivity extends AppCompatActivity
{
    DrawerNavigationAppBarManager drawerNavigationAppBarManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asmaa_allah_hosna_activity);

        MaterialToolbar asmaaAllahToolbar = findViewById(R.id.app_toolbar);
        DrawerLayout asmaaAllahDrawer = findViewById(R.id.asmaa_allah_drawer_layout);
        NavigationView asmaaAllahNavigation = findViewById(R.id.asmaa_allah_navigation_view);
        MaterialCardView dynamicCardView = findViewById(R.id.card_view);
        TextView asmAllahMeaning = findViewById(R.id.asm_allah_meaning);
        RecyclerView asmaaAllahRecycler = findViewById(R.id.asmaa_allah_recycler);
        FloatingActionButton fab = findViewById(R.id.fab_asmaa_allah);
        View overlay = findViewById(R.id.overlay_view);

        BackButtonManager backButtonManager = new BackButtonManager();

        drawerNavigationAppBarManager = new DrawerNavigationAppBarManager();
        drawerNavigationAppBarManager.setup(this, asmaaAllahDrawer, asmaaAllahNavigation, asmaaAllahToolbar, R.id.asmaa_allah);

        AsmaaAllahHosnaAdapter adapter = new AsmaaAllahHosnaAdapter();
        int noOfCol = 3;
        asmaaAllahRecycler.setLayoutManager(new GridLayoutManager(this, noOfCol));
        //direction to RTL
        //asmaaAllahRecycler.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        asmaaAllahRecycler.setAdapter(adapter);

        AsmaaAllahHosnaViewModel asmaaAllahViewModel = new ViewModelProvider(this).get(AsmaaAllahHosnaViewModel.class);

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
                        fab.setVisibility(View.VISIBLE);
                    }
                });
            }
        });

        fab.setOnClickListener(view -> {
            fab.setVisibility(View.GONE);
            dynamicCardView.setVisibility(View.GONE);
            overlay.setVisibility(View.GONE);
            });
        //Handles Back Behavior
        backButtonManager.backFromAsmaaAllah(this, asmaaAllahDrawer, dynamicCardView, fab, overlay);
    }
    public void onResume()
    {
        super.onResume();
        drawerNavigationAppBarManager.syncCheckedItem();
    }
}