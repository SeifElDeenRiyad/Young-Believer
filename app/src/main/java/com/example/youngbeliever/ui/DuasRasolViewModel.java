package com.example.youngbeliever.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.DuasModel;

import java.util.ArrayList;

public class DuasRasolViewModel extends ViewModel
{
    public MutableLiveData<ArrayList<DuasModel>> duaData = new MutableLiveData<>();

    public void getRasolDua()
    {
        duaData.setValue(getDuaFromDataBase());
    }

    private ArrayList<DuasModel> getDuaFromDataBase()
    {
        ArrayList<DuasModel> duasList = new ArrayList<>();
        duasList.add(new DuasModel(R.string.rasol_dua1,R.string.rasol_dua_info1));
        duasList.add(new DuasModel(R.string.rasol_dua2,R.string.rasol_dua_info2));
        duasList.add(new DuasModel(R.string.rasol_dua3,R.string.rasol_dua_info3));
        duasList.add(new DuasModel(R.string.rasol_dua4,R.string.rasol_dua_info4));
        duasList.add(new DuasModel(R.string.rasol_dua5,R.string.rasol_dua_info5));
        duasList.add(new DuasModel(R.string.rasol_dua6,R.string.rasol_dua_info6));
        duasList.add(new DuasModel(R.string.rasol_dua7,R.string.rasol_dua_info7));
        duasList.add(new DuasModel(R.string.rasol_dua8,R.string.rasol_dua_info8));
        duasList.add(new DuasModel(R.string.rasol_dua9,R.string.rasol_dua_info9));
        duasList.add(new DuasModel(R.string.rasol_dua10,R.string.rasol_dua_info10));
        duasList.add(new DuasModel(R.string.rasol_dua11,R.string.rasol_dua_info11));
        duasList.add(new DuasModel(R.string.rasol_dua12,R.string.rasol_dua_info12));
        duasList.add(new DuasModel(R.string.rasol_dua13,R.string.rasol_dua_info13));
        duasList.add(new DuasModel(R.string.rasol_dua14,R.string.rasol_dua_info14));
        duasList.add(new DuasModel(R.string.rasol_dua15,R.string.rasol_dua_info15));
        duasList.add(new DuasModel(R.string.rasol_dua16,R.string.rasol_dua_info16));
        duasList.add(new DuasModel(R.string.rasol_dua17,R.string.rasol_dua_info17));
        duasList.add(new DuasModel(R.string.rasol_dua18,R.string.rasol_dua_info18));
        duasList.add(new DuasModel(R.string.rasol_dua19,R.string.rasol_dua_info19));
        duasList.add(new DuasModel(R.string.rasol_dua20,R.string.rasol_dua_info20));
        duasList.add(new DuasModel(R.string.rasol_dua21,R.string.rasol_dua_info21));
        duasList.add(new DuasModel(R.string.rasol_dua22,R.string.rasol_dua_info22));
        duasList.add(new DuasModel(R.string.rasol_dua23,R.string.rasol_dua_info23));
        duasList.add(new DuasModel(R.string.rasol_dua24,R.string.rasol_dua_info24));
        duasList.add(new DuasModel(R.string.rasol_dua25,R.string.rasol_dua_info25));
        duasList.add(new DuasModel(R.string.rasol_dua26,R.string.rasol_dua_info26));
        duasList.add(new DuasModel(R.string.rasol_dua27,R.string.rasol_dua_info27));
        duasList.add(new DuasModel(R.string.rasol_dua18,R.string.rasol_dua_info28));
        duasList.add(new DuasModel(R.string.rasol_dua29,R.string.rasol_dua_info29));
        return duasList;
    }
}