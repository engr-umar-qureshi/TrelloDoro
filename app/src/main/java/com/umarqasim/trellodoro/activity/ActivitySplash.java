package com.umarqasim.trellodoro.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.umarqasim.trellodoro.prefrences.PrefrenceUser;

/**
 * Created by Umar Qureshi on 4/3/2016.
 */
public class ActivitySplash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
//        if(new PrefrenceUser(this).isTrelloConfigured()){
//
//        }
//        else {
//
//        }


        new SplashTimer(5000,5000).start();

    }

    class SplashTimer extends CountDownTimer{

        public SplashTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {

        }

        @Override
        public void onFinish() {
            startActivity(new Intent(ActivitySplash.this, ActivityConfigure.class));
            finish();
        }
    }
}
