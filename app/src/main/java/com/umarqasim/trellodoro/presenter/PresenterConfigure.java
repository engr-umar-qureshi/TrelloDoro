package com.umarqasim.trellodoro.presenter;

import com.umarqasim.trellodoro.icepic.ModelUserBundler;
import com.umarqasim.trellodoro.view.ViewConfigure;
import com.umarqasim.trellodoroapi.TrellodoroApiClient;
import com.umarqasim.trellodoroapi.events.EventModelUser;
import com.umarqasim.trellodoroapi.model.ModelUser;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import icepick.State;

/**
 * Created by Umar Qureshi on 4/3/2016.
 */

public class PresenterConfigure extends PresenterBaseTrellodoro {

    ViewConfigure view;

    @State(ModelUserBundler.class)
    ModelUser modelUser;

    @State
    int selectedBoard=0;

    @State
    boolean isNetworkCall=false;

    public PresenterConfigure(ViewConfigure view) {
        this.view=view;
    }

    @Override
    public void restorePresenter() {
        if(isNetworkCall){
            view.showNetworkLoading();
        }
        if(modelUser!=null){
            view.hideConnectViews();
            view.loadBoardsData(extractBoardTitles(modelUser),selectedBoard);
        }

    }

    public void fetchUserDetail(String token)
    {
        isNetworkCall = true;
        view.showNetworkLoading();
        TrellodoroApiClient.getClient().getControllerUser().getModelUser(token);
    }

    public void onSelectBoard(int pos){
        selectedBoard=pos;
    }


    public List<String> extractBoardTitles(ModelUser modelUser){
        List<String> listTitles = new ArrayList<>();
        for(int i=0; i<modelUser.getBoards().size(); i++){
            listTitles.add(modelUser.getBoards().get(i).getName());
        }

        return listTitles;
    }


    @Subscribe
    public void onEvent(EventModelUser event) {
        if(event.isSuccess()) {
            view.hideNetworkLoading();
            isNetworkCall = false;
            modelUser = view.saveUserObject(event.getModelUser());
            view.hideConnectViews();
            selectedBoard = 0;
            view.loadBoardsData(extractBoardTitles(modelUser), selectedBoard);
        }
        else {
            view.showError(event.getCode());
            view.hideNetworkLoading();
            isNetworkCall = false;
        }
    }


}
