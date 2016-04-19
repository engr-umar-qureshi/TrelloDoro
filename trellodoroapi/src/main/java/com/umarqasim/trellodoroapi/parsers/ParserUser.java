package com.umarqasim.trellodoroapi.parsers;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.umarqasim.trellodoroapi.model.ModelUser;

import org.json.JSONException;
import org.json.JSONObject;

import io.realm.RealmObject;

/**
 * Created by UmarQasim on 4/13/2016.
 */
public class ParserUser {

    public String PARSER_KEY_USERNAME="username";

    public String getUsername(String responseUser) throws JSONException
    {
        return new JSONObject(responseUser).getString(PARSER_KEY_USERNAME);
    }

    public ModelUser getModelUser(String jsonUserObject) {
        Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return f.getDeclaringClass().equals(RealmObject.class);
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        }).excludeFieldsWithoutExposeAnnotation().create();

        return gson.fromJson(jsonUserObject, ModelUser.class);
    }
}
