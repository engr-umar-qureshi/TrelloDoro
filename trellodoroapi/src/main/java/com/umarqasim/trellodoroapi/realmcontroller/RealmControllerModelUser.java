package com.umarqasim.trellodoroapi.realmcontroller;

import android.content.Context;

import com.umarqasim.trellodoroapi.model.ModelUser;

import io.realm.Realm;

/**
 * Created by UmarQasim on 4/13/2016.
 */
public class RealmControllerModelUser {

    public static ModelUser saveModelUser(ModelUser modelUser,Context context){

        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        modelUser = realm.copyToRealmOrUpdate(modelUser);
        realm.commitTransaction();
        return modelUser;
    }
}
