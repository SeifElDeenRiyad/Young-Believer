package com.example.youngbeliever.models;

public class StoriesModel
{
    int storyName;
    String storyPath;
    public StoriesModel(int storyName, String storyPath)
    {
        this.storyName = storyName;
        this.storyPath = storyPath;
    }
    public int getStoryName()
    {
        return storyName;
    }
    public String getPdfPath()
    {
        return storyPath;
    }
}
