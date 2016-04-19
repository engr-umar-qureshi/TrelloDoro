package com.umarqasim.trellodoroapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import io.realm.ModelBoardRealmProxy;
import io.realm.ModelUserRealmProxy;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by UmarQasim on 4/13/2016.
 */
@Parcel(implementations = { ModelBoardRealmProxy.class },
        value = Parcel.Serialization.BEAN,
        analyze = { ModelBoard.class })
@RealmClass
public class ModelBoard extends RealmObject{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("closed")
    @Expose
    private boolean closed;
    @SerializedName("id")
    @Expose
    @PrimaryKey
    private String id;

    /**
     * No args constructor for use in serialization
     *
     */
    public ModelBoard() {
    }

    /**
     *
     * @param id
     * @param name
     * @param closed
     */
    public ModelBoard(String name, boolean closed, String id) {
        this.name = name;
        this.closed = closed;
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The closed
     */
    public boolean isClosed() {
        return closed;
    }

    /**
     *
     * @param closed
     * The closed
     */
    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

}