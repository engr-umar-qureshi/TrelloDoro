package com.umarqasim.trellodoro.prefrences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Umar Qureshi on 4/3/2016.
 */
public class PrefrenceUser{

    private Context mContext;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String USER_PREFRENCES = "USER_PREFRENCES";

    private static final String KEY_TRELLO_CONFIG = "TRELLO_CONFIG";

    private static final String KEY_USER_TOKEN = "USER_TOKEN";
    private static final String KEY_USER_USERNAME = "USER_USERNAME";
    private static final String KEY_USER_ID = "USER_ID";
    private static final String KEY_USER_DISPLAY_NAME = "USER_DISPLAY_NAME";

    public PrefrenceUser(Context context){
        this.mContext = context;
        sharedPreferences = mContext.getSharedPreferences(USER_PREFRENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setTrelloConfigured(boolean isTrelloConfigured){
        editor.putBoolean(KEY_TRELLO_CONFIG, isTrelloConfigured);
        editor.commit();
    }

    public boolean isTrelloConfigured(){
        return sharedPreferences.getBoolean(KEY_TRELLO_CONFIG, false);
    }


    public void setUserToken(String user_token){
        editor.putString(KEY_USER_TOKEN, user_token);
        editor.commit();
    }

    public String getUserToken(){
        return sharedPreferences.getString(KEY_USER_TOKEN, "");
    }

    public void setUserUsername(String user_username){
        editor.putString(KEY_USER_USERNAME, user_username);
        editor.commit();
    }

    public String getUserUsername(){
        return sharedPreferences.getString(KEY_USER_USERNAME, "");
    }

    public void setUserId(String user_id){
        editor.putString(KEY_USER_ID, user_id);
        editor.commit();
    }

    public String getUserId(){
        return sharedPreferences.getString(KEY_USER_ID, "");
    }


    public void setUserDisplayName(String user_display_name){
        editor.putString(KEY_USER_DISPLAY_NAME, user_display_name);
        editor.commit();
    }

    public String getUserDisplayName(){
        return sharedPreferences.getString(KEY_USER_DISPLAY_NAME, "");
    }



}
