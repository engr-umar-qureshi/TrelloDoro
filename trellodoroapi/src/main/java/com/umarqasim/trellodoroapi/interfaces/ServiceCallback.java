package com.umarqasim.trellodoroapi.interfaces;

import com.umarqasim.trellodoroapi.prefrences.TrellodoroErrorCodes;

/**
 * Created by Umar Qureshi on 4/3/2016.
 */
public interface ServiceCallback<T> {
    public void onSuccess(T data);

    public void onFailure(TrellodoroErrorCodes errorCode);
}