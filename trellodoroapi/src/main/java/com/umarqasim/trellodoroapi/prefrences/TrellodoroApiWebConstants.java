package com.umarqasim.trellodoroapi.prefrences;

/**
 * Created by Umar Qureshi on 4/3/2016.
 */
public class TrellodoroApiWebConstants {

    public static final String BASE_URL="https://api.trello.com/1/";


    // Endpoints
    public static final String ENDPOINT_TOKENS="tokens";
    public static final String ENDPOINT_MEMBERS="members";


    //Url keys

    public static final String URL_KEY_TOKEN="token";
    public static final String URL_KEY_USERNAME="username";

    //Query String keys

    public static final String QUERY_KEY_API_KEY="key";
    public static final String QUERY_KEY_FIELDS="fields";
    public static final String QUERY_KEY_TOKEN="token";
    public static final String QUERY_KEY_BOARDS="boards";

    // Urls
    public static final String GET_USERNAME = ENDPOINT_TOKENS+"/{"+URL_KEY_TOKEN+"}/member";
    public static final String GET_MEMBER_DETAIL = ENDPOINT_MEMBERS+"/{"+URL_KEY_USERNAME+"}";




    // User fields
    public static final String USER_FIELD_USERNAME="username";
    public static final String USER_FIELD_DISPLAYNAME="fullName";
    public static final String BOARD_TYPE_ALL="all";
}
