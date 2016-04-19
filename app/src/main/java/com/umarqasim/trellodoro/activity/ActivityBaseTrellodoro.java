package com.umarqasim.trellodoro.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.media.session.PlaybackStateCompat;

import com.umarqasim.trellodoro.R;
import com.umarqasim.trellodoro.presenter.PresenterBaseTrellodoro;
import com.umarqasim.trellodoro.utility.DialogNetworkProgress;

import butterknife.ButterKnife;
import icepick.Icepick;
import icepick.State;

/**
 * Created by UmarQasim on 4/13/2016.
 */
public abstract class ActivityBaseTrellodoro extends Activity {

    ProgressDialog dialogNetworkProgress;

    AlertDialog alertDialog;

    PresenterBaseTrellodoro presenterBaseTrellodoro;

     abstract public PresenterBaseTrellodoro initializePresenter();

    @Override
    protected void onResume() {
        super.onResume();
        presenterBaseTrellodoro.restorePresenter();
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenterBaseTrellodoro = initializePresenter();
        Icepick.restoreInstanceState(this, savedInstanceState);
        presenterBaseTrellodoro.onCreate(savedInstanceState);
    }

    @Override public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
        presenterBaseTrellodoro.onSaveInstanceState(outState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        if(dialogNetworkProgress!=null&&dialogNetworkProgress.isShowing())
        {
            dialogNetworkProgress.dismiss();
        }

        if(alertDialog!=null&& alertDialog.isShowing())
        {
            alertDialog.dismiss();
        }
        super.onDestroy();

    }

    public void showDialogNetworkProgress() {
        if(dialogNetworkProgress==null){
            dialogNetworkProgress = DialogNetworkProgress.getDialog(this);
        }
         dialogNetworkProgress.show();
    }

    public void hideDialogNetworkProgress(){
        if(dialogNetworkProgress!=null && dialogNetworkProgress.isShowing()){
            dialogNetworkProgress.dismiss();
        }
    }

    public void showAlertDialog(String alertMessage) {
        if(alertDialog==null){
            alertDialog = new AlertDialog.Builder(this).setPositiveButton(getResources().getString(R.string.txt_ok), null).create();

        }
        alertDialog.setMessage(alertMessage);
        alertDialog.show();
    }


}

