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

public class DuasRasolFragment extends Fragment
{
    DuasRasolViewModel DuasRasolViewModel;
    public DuasRasolFragment()
    {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.duas_list, container, false);
        DuasRasolViewModel = new ViewModelProvider(this).get(DuasRasolViewModel.class);

        RecyclerView DuasRasolRecycler = rootView.findViewById(R.id.duas_recycler);
        DuasAdapter adapter = new DuasAdapter();

        DuasRasolRecycler.setAdapter(adapter);
        DuasRasolRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        DuasRasolViewModel.getRasolDua();

        DuasRasolViewModel.duaData.observe(getViewLifecycleOwner(), new Observer<ArrayList<DuasModel>>()
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

        //DuasRasolRecycler.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        return rootView;
    }
}