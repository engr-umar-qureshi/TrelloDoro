package com.umarqasim.trellodoroapi.interfaces;

import com.umarqasim.trellodoroapi.prefrences.TrellodoroApiWebConstants;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Umar Qureshi on 4/3/2016.
 */
public interface InterfaceUser {

    @GET(TrellodoroApiWebConstants.GET_USERNAME)
    Call<ResponseBody> getUsername(@Path(TrellodoroApiWebConstants.URL_KEY_TOKEN) String userToken,@Query(TrellodoroApiWebConstants.QUERY_KEY_API_KEY) String api_key,@Query(TrellodoroApiWebConstants.QUERY_KEY_FIELDS) String fields);

    @GET(TrellodoroApiWebConstants.GET_MEMBER_DETAIL)
    Call<ResponseBody> getMemberDetail(@Path(TrellodoroApiWebConstants.URL_KEY_USERNAME) String userName,@Query(TrellodoroApiWebConstants.QUERY_KEY_TOKEN) String token,@Query(TrellodoroApiWebConstants.QUERY_KEY_API_KEY) String api_key,@Query(TrellodoroApiWebConstants.QUERY_KEY_FIELDS) String fields,@Query(TrellodoroApiWebConstants.QUERY_KEY_BOARDS) String boards);

}
