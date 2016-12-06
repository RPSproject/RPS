package com.domain.some.rps;

/**
 * Created by steve on 12/2/16.
 */

import android.app.Application;


public class AndroidTutorialApp extends Application {

    //add this variable declaration:
    public static String userName = "";
    public static int theirChoice;
    public static int wins;
    public static int losses;
    public static int draws;

    private static AndroidTutorialApp singleton;

    public static AndroidTutorialApp getInstance() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }
}