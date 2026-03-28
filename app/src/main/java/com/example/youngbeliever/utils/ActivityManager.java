package com.example.youngbeliever.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ActivityManager extends Application
{
    private static final List<Activity> activities = new ArrayList<>();
    public static List<Activity> getActivityList()
    {
        return activities;
    }
    @Override
    public void onCreate()
    {
        super.onCreate();
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks()
        {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle)
            {
                activities.add(activity);
            }
            // Other lifecycle methods.
            @Override
            public void onActivityDestroyed(@NonNull Activity activity)
            {
                activities.remove(activity);
            }
            @Override
            public void onActivityStarted(@NonNull Activity activity)
            {
            }
            @Override
            public void onActivityResumed(@NonNull Activity activity)
            {
            }
            @Override
            public void onActivityPaused(@NonNull Activity activity)
            {
            }
            @Override
            public void onActivityStopped(@NonNull Activity activity)
            {
            }
            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState)
            {
            }
        });
    }
    public void openActivityRemovingDuplicate(Class<? extends Activity> target)
    {
        List<Activity> activityList = ActivityManager.getActivityList();
        // Remove **any duplicate** activity of the target class
        for (Activity activity : new ArrayList<>(activityList))
        { // avoid ConcurrentModification
            if (!activity.isFinishing() && activity.getClass().equals(target))
            {
                activity.finish(); // removes the duplicate from stack
            }
        }
        // Start a new instance
        Intent intent = new Intent(this, target);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}