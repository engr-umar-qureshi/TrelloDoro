package com.umarqasim.trellodoroapi.prefrences;

import android.content.Context;

import com.umarqasim.trellodoroapi.R;

/**
 * Created by UmarQasim on 4/13/2016.
 */
public enum TrellodoroErrorCodes {

    ERROR_CONNECTION_FAILED,
    ERROR_CALL_FAILED,
    ERROR_PARSING,
    ERROR_RESPONSE,
    ERROR_REALM;

    public static String translate(TrellodoroErrorCodes trellodoroErrorCode, Context context)
    {
        switch (trellodoroErrorCode)
        {
            case ERROR_CONNECTION_FAILED:
                return context.getResources().getString(R.string.error_msg_connection);
            case ERROR_CALL_FAILED:
                return context.getResources().getString(R.string.error_msg_call);
            case ERROR_PARSING:
                return context.getResources().getString(R.string.error_msg_parsing);
            case ERROR_RESPONSE:
                return context.getResources().getString(R.string.error_msg_response);
            case ERROR_REALM:
                return context.getResources().getString(R.string.error_msg_realm);
            default:
                return context.getResources().getString(R.string.error_msg_invalid);
        }
    }
}
