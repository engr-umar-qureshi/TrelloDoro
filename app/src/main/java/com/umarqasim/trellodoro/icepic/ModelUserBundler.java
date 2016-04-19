package com.umarqasim.trellodoro.icepic;

import android.os.Bundle;

import com.umarqasim.trellodoroapi.model.ModelUser;

import org.parceler.Parcels;

import icepick.Bundler;

/**
 * Created by UmarQasim on 4/14/2016.
 */
public class ModelUserBundler  implements Bundler<ModelUser> {
    @Override
    public void put(String s, ModelUser modelUser, Bundle bundle) {
        bundle.putParcelable(s, Parcels.wrap(modelUser));
    }

    @Override
    public ModelUser get(String s, Bundle bundle) {
        return Parcels.unwrap(bundle.getParcelable(s));
    }
}