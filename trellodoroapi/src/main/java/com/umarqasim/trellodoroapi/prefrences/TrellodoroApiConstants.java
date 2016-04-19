package com.umarqasim.trellodoroapi.prefrences;

/**
 * Created by Umar Qureshi on 4/3/2016.
 */
public class TrellodoroApiConstants {

    public static final String TRELLO_API_KEY="6c4541470c36d22fd0bb79aa409fe0b6";
    public static final String TRELLO_API_SECRET="e66a797ab652fda1d71db5aab1dd5f07531b9a974169c270d2d8313155cb1ed2";
    public static final String TRELLO_APP_NAME="Trellodoro";
    public static final String TRELLO_OAUTH_REQUEST_TOKEN="https://trello.com/1/authorize?response_type=token&key="+TRELLO_API_KEY+"&return_url=http://localhost/Callback&scope=read,write&expiration=never&name="+TRELLO_APP_NAME;
    public static final String TRELLO_OAUTH_RETURN_TOEKN = "http://localhost/Callback#token=";
}
