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
        duasList.add(new DuasModel(0, R.string.rasol_dua1,R.string.rasol_dua_info1, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua2,R.string.rasol_dua_info2, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua3,R.string.rasol_dua_info3, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua4,R.string.rasol_dua_info4, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua5,R.string.rasol_dua_info5, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua6,R.string.rasol_dua_info6, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua7,R.string.rasol_dua_info7, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua8,R.string.rasol_dua_info8, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua9,R.string.rasol_dua_info9, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua10,R.string.rasol_dua_info10, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua11,R.string.rasol_dua_info11, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua12,R.string.rasol_dua_info12, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua13,R.string.rasol_dua_info13, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua14,R.string.rasol_dua_info14, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua15,R.string.rasol_dua_info15, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua16,R.string.rasol_dua_info16, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua17,R.string.rasol_dua_info17, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua18,R.string.rasol_dua_info18, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua19,R.string.rasol_dua_info19, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua20,R.string.rasol_dua_info20, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua21,R.string.rasol_dua_info21, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua22,R.string.rasol_dua_info22, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua23,R.string.rasol_dua_info23, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua24,R.string.rasol_dua_info24, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua25,R.string.rasol_dua_info25, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua26,R.string.rasol_dua_info26, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua27,R.string.rasol_dua_info27, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua18,R.string.rasol_dua_info28, 0));
        duasList.add(new DuasModel(0, R.string.rasol_dua29,R.string.rasol_dua_info29, 0));
        return duasList;
    }
}