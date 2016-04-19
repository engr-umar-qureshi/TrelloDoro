package com.umarqasim.trellodoroapi.events;

import com.umarqasim.trellodoroapi.model.ModelUser;
import com.umarqasim.trellodoroapi.prefrences.TrellodoroErrorCodes;

/**
 * Created by UmarQasim on 4/14/2016.
 */
public class EventModelUser {
   private ModelUser modelUser;
    private boolean isSuccess;
    private TrellodoroErrorCodes code;

    public EventModelUser(ModelUser modelUser, boolean isSuccess, TrellodoroErrorCodes code) {
        this.modelUser = modelUser;
        this.isSuccess = isSuccess;
        this.code = code;
    }

    public ModelUser getModelUser() {
        return modelUser;
    }

    public void setModelUser(ModelUser modelUser) {
        this.modelUser = modelUser;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public TrellodoroErrorCodes getCode() {
        return code;
    }

    public void setCode(TrellodoroErrorCodes code) {
        this.code = code;
    }
}
