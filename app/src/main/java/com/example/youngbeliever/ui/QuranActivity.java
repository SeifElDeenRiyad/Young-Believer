package com.example.youngbeliever.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.QuranModel;
import com.example.youngbeliever.utils.BackButtonManager;
import com.example.youngbeliever.utils.DrawerNavigationAppBarManager;
import com.example.youngbeliever.utils.SpaceManager;

import java.util.ArrayList;

public class QuranActivity extends AppCompatActivity
{
    DrawerNavigationAppBarManager drawerNavigationAppBarManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quran_activity);
        QuranViewModel quranViewModel = new ViewModelProvider(this).get(QuranViewModel.class);

        RecyclerView quranRecycler = findViewById(R.id.quran_recycler_view);

        BackButtonManager backButtonManager = new BackButtonManager();
        drawerNavigationAppBarManager = new DrawerNavigationAppBarManager();

        drawerNavigationAppBarManager.initialize(this, R.id.quran_drawer_layout,
                R.id.quran_navigation_view, R.id.app_toolbar, R.id.holy_quran);

        QuranAdapter adapter = new QuranAdapter();
        quranRecycler.setLayoutManager(new LinearLayoutManager(this));
        quranRecycler.setAdapter(adapter);

        SpaceManager spaceManager = new SpaceManager();
        spaceManager.setBottomPadding(quranRecycler);

        quranViewModel.getSurasData();
        quranViewModel.surasDate.observe(this, new Observer<ArrayList<QuranModel>>()
        {
            @Override
            public void onChanged(ArrayList<QuranModel> quranSura)
            {
                adapter.setList(quranSura, new QuranAdapter.itemClickListener()
                {
                    @Override
                    public void onItemCLick(QuranModel quranModel)
                    {
                        QuranPDF(quranModel.getSuraPage());
                    }
                });
            }
        });

        backButtonManager.simpleBackFromActivity(this, drawerNavigationAppBarManager.getDrawer());
    }
    public void QuranPDF(int pageNum)
    {
        Intent intent = new Intent(this, QuranPdfActivity.class);
        intent.putExtra("page_number", pageNum);
        startActivity(intent);
    }
    @Override
    public void onResume()
    {
        super.onResume();
        drawerNavigationAppBarManager.syncCheckedItem();
    }
}