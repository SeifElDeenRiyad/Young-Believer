package com.example.youngbeliever.models;

public class AzkarModel
{
    int zekrTimes;
    int zekr;
    int bsmla;
    int zekrReward;
    public AzkarModel(int zekrTimes, int bsmla, int zekr, int zekrReward)
    {
        this.zekrTimes = zekrTimes;
        this.bsmla = bsmla;
        this.zekr = zekr;
        this.zekrReward = zekrReward;
    }
    public int getZekrTimes()
    {
        return zekrTimes;
    }
    public int getZekr()
    {
        return zekr;
    }
    public int getBsmla()
    {
        return bsmla;
    }
    public void setBsmla(int bsmla)
    {
        this.bsmla = bsmla;
    }
    public int getZekrReward()
    {
        return zekrReward;
    }
}
