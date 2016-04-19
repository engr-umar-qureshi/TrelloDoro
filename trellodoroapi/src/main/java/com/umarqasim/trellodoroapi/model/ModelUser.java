package com.umarqasim.trellodoroapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.umarqasim.trellodoroapi.parcelerutil.BoardListParcelConverter;

import org.parceler.Parcel;
import org.parceler.ParcelProperty;
import org.parceler.ParcelPropertyConverter;

import io.realm.ModelUserRealmProxy;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by Umar Qureshi on 4/3/2016.
 */
@Parcel(implementations = { ModelUserRealmProxy.class },
        value = Parcel.Serialization.BEAN,
        analyze = { ModelUser.class })
@RealmClass
public class ModelUser extends RealmObject {

    @SerializedName("id")
    @Expose
    @PrimaryKey
    private String id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("boards")
    @Expose
    private RealmList<ModelBoard> boards;

    /**
     * No args constructor for use in serialization
     *
     */
    public ModelUser() {
    }

    /**
     *
     * @param id
     * @param username
     * @param fullName
     * @param boards
     */
    public ModelUser(String id, String username, String fullName, RealmList<ModelBoard> boards) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.boards = boards;
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

    /**
     *
     * @return
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     * The fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     *
     * @param fullName
     * The fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     *
     * @return
     * List of boards
     */
    public RealmList<ModelBoard> getBoards() {
        return boards;
    }

    /**
     *
     * @param boards
     * List of boards
     */
    @ParcelProperty("boards")
    @ParcelPropertyConverter(BoardListParcelConverter.class)
    public void setBoards(RealmList<ModelBoard> boards) {
        this.boards = boards;
    }
}

