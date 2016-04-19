package com.umarqasim.trellodoro.utility;

import android.app.ProgressDialog;
import android.content.Context;

import com.umarqasim.trellodoro.R;

/**
 * Created by Umar Qureshi on 4/3/2016.
 */
public class DialogNetworkProgress {

    public static ProgressDialog getDialog(Context mContext){
         ProgressDialog mProgressDialog;
            mProgressDialog = new ProgressDialog(mContext);
            mProgressDialog.setMessage(mContext.getResources().getString(R.string.txt_network));
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setProgress(0);

        return mProgressDialog;
    }


}
