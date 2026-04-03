package com.example.youngbeliever.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.youngbeliever.R;
import com.example.youngbeliever.models.DuasModel;

import java.util.ArrayList;

public class DuasQuranViewModel extends ViewModel
{
    public MutableLiveData<ArrayList<DuasModel>> duaData = new MutableLiveData<>();

    public void getQuranDua()
    {
        duaData.setValue(getDuaFromDataBase());
    }

    private ArrayList<DuasModel> getDuaFromDataBase()
    {
        ArrayList<DuasModel> duasList = new ArrayList<>();
        duasList.add(new DuasModel(0, R.string.quran_dua1,R.string.quran_dua_info1, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua2,R.string.quran_dua_info2, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua3,R.string.quran_dua_info3, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua4,R.string.quran_dua_info4, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua5,R.string.quran_dua_info5, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua6,R.string.quran_dua_info6, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua7,R.string.quran_dua_info7, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua8,R.string.quran_dua_info8, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua9,R.string.quran_dua_info9, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua10,R.string.quran_dua_info10, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua11,R.string.quran_dua_info11, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua12,R.string.quran_dua_info12, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua13,R.string.quran_dua_info13, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua14,R.string.quran_dua_info14, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua15,R.string.quran_dua_info15, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua16,R.string.quran_dua_info16, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua17,R.string.quran_dua_info17, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua18,R.string.quran_dua_info18, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua19,R.string.quran_dua_info19, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua20,R.string.quran_dua_info20, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua21,R.string.quran_dua_info21, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua22,R.string.quran_dua_info22, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua23,R.string.quran_dua_info23, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua24,R.string.quran_dua_info24, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua25,R.string.quran_dua_info25, R.string.bsmla));
        duasList.add(new DuasModel(0, R.string.quran_dua26,R.string.quran_dua_info26, R.string.bsmla));
        return duasList;
    }
}