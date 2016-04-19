package com.umarqasim.trellodoro;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by Umar Qureshi on 4/2/2016.
 */
public class TrellodoroApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
