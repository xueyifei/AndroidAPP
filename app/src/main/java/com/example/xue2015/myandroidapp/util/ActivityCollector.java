package com.example.xue2015.myandroidapp.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xue2015 on 2015/8/10.
 */
public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
