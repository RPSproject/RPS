package com.domain.some.rps;

/**
 * Created by steve on 12/2/16.
 */

import android.app.Application;


public class AndroidTutorialApp extends Application {

    //add this variable declaration:
    public static String userName = "";
    public static int theirChoice;
    public static double wins;
    public static double losses;
    public static double draws;
    public static boolean isplaying;

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