package com.example.youngbeliever.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.DuasModel;

import java.util.ArrayList;

public class DuasRosolFragment extends Fragment
{
    DuasRosolViewModel DuasRosolViewModel;
    public DuasRosolFragment()
    {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.duas_list, container, false);
        DuasRosolViewModel = new ViewModelProvider(this).get(DuasRosolViewModel.class);

        RecyclerView DuasRosolRecycler = rootView.findViewById(R.id.duas_recycler);
        DuasAdapter adapter = new DuasAdapter();

        DuasRosolRecycler.setAdapter(adapter);
        DuasRosolRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        DuasRosolViewModel.getRosolDua();

        DuasRosolViewModel.duaData.observe(getViewLifecycleOwner(), new Observer<ArrayList<DuasModel>>()
        {
            @Override
            public void onChanged(ArrayList<DuasModel> duasModels)
            {
                adapter.setList(duasModels, new DuasAdapter.itemClickListener()
                {
                    @Override
                    public void onItemClick(DuasModel DuasModel)
                    {
                    }
                });
            }
        });


        //DuasRosolRecycler.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        return rootView;
    }
}