package com.umarqasim.trellodoro.icepic;

import android.os.Bundle;

import com.umarqasim.trellodoroapi.model.ModelBoard;
import com.umarqasim.trellodoroapi.model.ModelUser;

import org.parceler.Parcels;

import icepick.Bundler;

/**
 * Created by UmarQasim on 4/14/2016.
 */
public class ModelBoardBundler implements Bundler<ModelBoard> {
    @Override
    public void put(String s, ModelBoard modelBoard, Bundle bundle) {
        bundle.putParcelable(s, Parcels.wrap(modelBoard));
    }

    @Override
    public ModelBoard get(String s, Bundle bundle) {
        return Parcels.unwrap(bundle.getParcelable(s));
    }
}