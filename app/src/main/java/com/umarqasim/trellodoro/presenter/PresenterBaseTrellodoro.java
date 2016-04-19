package com.umarqasim.trellodoro.presenter;

import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;

import icepick.Icepick;
import icepick.State;

/**
 * Created by UmarQasim on 4/13/2016.
 */
public abstract class PresenterBaseTrellodoro {

    public PresenterBaseTrellodoro() {
        EventBus.getDefault().register(this);
    }


    abstract public void restorePresenter();
    public void onCreate(Bundle savedInstanceState){
        Icepick.restoreInstanceState(this, savedInstanceState);
    }
    public void onSaveInstanceState(Bundle outState){
        Icepick.saveInstanceState(this, outState);
    }
}
