package com.example.youngbeliever.models;

public class HomeModel
{
    int sectionImage;
    int sectionName;
    public HomeModel(int sectionImage, int sectionName)
    {
        this.sectionImage = sectionImage;
        this.sectionName = sectionName;
    }
    public int getSectionName()
    {
        return sectionName;
    }
    public int getSectionImage()
    {
        return sectionImage;
    }
}
