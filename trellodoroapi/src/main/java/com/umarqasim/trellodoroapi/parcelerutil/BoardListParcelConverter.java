package com.umarqasim.trellodoroapi.parcelerutil;

import android.os.Parcel;

import com.umarqasim.trellodoroapi.model.ModelBoard;

import org.parceler.Parcels;

/**
 * Created by UmarQasim on 4/14/2016.
 */
public class BoardListParcelConverter extends RealmListParcelConverter<ModelBoard> {

    @Override
    public void itemToParcel(ModelBoard input, Parcel parcel) {
        parcel.writeParcelable(Parcels.wrap(input), 0);
    }

    @Override
    public ModelBoard itemFromParcel(Parcel parcel) {
        return Parcels.unwrap(parcel.readParcelable(ModelBoard.class.getClassLoader()));
    }
}
