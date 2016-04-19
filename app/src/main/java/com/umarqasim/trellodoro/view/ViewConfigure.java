package com.umarqasim.trellodoro.view;


import com.umarqasim.trellodoroapi.model.ModelBoard;
import com.umarqasim.trellodoroapi.model.ModelUser;
import com.umarqasim.trellodoroapi.prefrences.TrellodoroErrorCodes;

import java.util.List;

/**
 * Created by Umar Qureshi on 4/3/2016.
 */
public interface ViewConfigure {

    public void showError(TrellodoroErrorCodes errorCode);

    public void showNetworkLoading();

    public void hideNetworkLoading();

    public ModelUser saveUserObject(ModelUser modelUser);

    public void hideConnectViews();

    public void showUserWelcomeMessage(String userDisplayName);

    public void loadBoardsData(List<String> listBoards, int selected);
}
