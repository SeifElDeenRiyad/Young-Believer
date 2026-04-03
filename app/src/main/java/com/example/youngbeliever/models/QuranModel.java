package com.example.youngbeliever.models;

public class QuranModel
{
    int suraNum;
    int suraName;
    int suraRevelation;
    int suraAyahNum;
    int suraPage;
    public QuranModel(int suraNum, int suraName, int suraRevelation, int suraAyahNum,int suraPage)
    {
        this.suraNum = suraNum;
        this.suraName = suraName;
        this.suraRevelation = suraRevelation;
        this.suraAyahNum = suraAyahNum;
        this.suraPage = suraPage;
    }

    public int getSuraNum()
    {
        return suraNum;
    }
    public int getSuraName()
    {
        return suraName;
    }
    public int getSuraRevelation()
    {
        return suraRevelation;
    }
    public int getSuraAyahNum()
    {
        return suraAyahNum;
    }
    public int getSuraPage()
    {
        return suraPage;
    }

}
