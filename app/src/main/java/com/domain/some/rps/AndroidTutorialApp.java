package com.domain.some.rps;

/**
 * Created by steve on 12/2/16.
 */

import android.app.Application;


public class AndroidTutorialApp extends Application {

    //add this variable declaration:
    public static String somevalue = "Hello from application singleton!";

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