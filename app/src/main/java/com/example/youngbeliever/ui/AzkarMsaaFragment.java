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
import androidx.recyclerview.widget.RecyclerView;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.AzkarModel;
import com.example.youngbeliever.utils.FragmentSetter;

import java.util.ArrayList;

public class AzkarMsaaFragment extends Fragment
{
    public AzkarMsaaFragment()
    {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        FragmentSetter fragmentSetter = new FragmentSetter();
        AzkarMsaaViewModel azkarMsaaViewModel = new ViewModelProvider(this).get(AzkarMsaaViewModel.class);

        View rootView = fragmentSetter.setupRecyclerFragment(inflater, container, R.layout.azkar_list, R.id.azkar_recycler);

        RecyclerView azkarMsaaRecycler = rootView.findViewById(R.id.azkar_recycler);
        AzkarAdapter adapter = new AzkarAdapter();
        azkarMsaaRecycler.setAdapter(adapter);
        //azkarMsaaRecycler.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        azkarMsaaViewModel.getAzkarMsaaList();
        azkarMsaaViewModel.azkarMsaaList.observe(getViewLifecycleOwner(), new Observer<ArrayList<AzkarModel>>()
        {
            @Override
            public void onChanged(ArrayList<AzkarModel> azkarModels)
            {
                adapter.setList(azkarModels, new AzkarAdapter.itemClickListener()
                {
                    @Override
                    public void onItemClick(AzkarModel AzkarModel)
                    {
                    }
                });
            }
        });
        return rootView;
    }
}