package com.example.youngbeliever.models;

public class DuasModel
{
    int dua;
    int duaInfo;
    int duaProphet;
    int bsmla;
    //Duas Constructor
    public DuasModel(int duaProphet, int dua, int duaInfo , int bsmla)
    {
        this.dua = dua;
        this.duaInfo = duaInfo;
        this.duaProphet = duaProphet;
        this.bsmla = bsmla;
    }

    public int getBsmla()
    {
        return bsmla;
    }
    public int getDuaProphet()
    {
        return duaProphet;
    }
    public int getDua()
    {
        return dua;
    }
    public int getDuaInfo()
    {
        return duaInfo;
    }
}
