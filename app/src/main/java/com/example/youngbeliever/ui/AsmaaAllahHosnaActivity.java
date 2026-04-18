package com.example.youngbeliever.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.AsmaaAllahHosnaModel;
import com.example.youngbeliever.utils.BackButtonManager;
import com.example.youngbeliever.utils.DrawerNavigationAppBarManager;
import com.example.youngbeliever.utils.SpaceManager;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class AsmaaAllahHosnaActivity extends AppCompatActivity
{
    DrawerNavigationAppBarManager drawerNavigationAppBarManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asmaa_allah_hosna_activity);
        AsmaaAllahHosnaViewModel asmaaAllahViewModel = new ViewModelProvider(this).get(AsmaaAllahHosnaViewModel.class);

        MaterialCardView dynamicCardView = findViewById(R.id.card_view);
        TextView asmAllahMeaning = findViewById(R.id.asm_allah_meaning);
        RecyclerView asmaaAllahRecycler = findViewById(R.id.asmaa_allah_recycler);
        FloatingActionButton fab = findViewById(R.id.fab_asmaa_allah);
        View overlay = findViewById(R.id.overlay_view);

        BackButtonManager backButtonManager = new BackButtonManager();
        drawerNavigationAppBarManager = new DrawerNavigationAppBarManager();

        drawerNavigationAppBarManager.initialize(this, R.id.asmaa_allah_drawer_layout,
                R.id.asmaa_allah_navigation_view, R.id.app_toolbar, R.id.asmaa_allah);

        AsmaaAllahHosnaAdapter adapter = new AsmaaAllahHosnaAdapter();
        int noOfCol = 3;
        asmaaAllahRecycler.setLayoutManager(new GridLayoutManager(this, noOfCol));
        //asmaaAllahRecycler.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        asmaaAllahRecycler.setAdapter(adapter);

        SpaceManager spaceManager = new SpaceManager();
        spaceManager.setBottomPadding(asmaaAllahRecycler);

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

        fab.setOnClickListener(v ->
        {
            fab.setVisibility(View.GONE);
            dynamicCardView.setVisibility(View.GONE);
            overlay.setVisibility(View.GONE);
        });

        backButtonManager.specialBackFromActivity(this, drawerNavigationAppBarManager.getDrawer(),
                dynamicCardView, fab, overlay);
    }
    public void onResume()
    {
        super.onResume();
        drawerNavigationAppBarManager.syncCheckedItem();
    }
}