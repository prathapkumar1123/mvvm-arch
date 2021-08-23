package com.sample.framework.mvvm.java.network.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    public int id = 0;

    @SerializedName("name")
    public String name = "";

    @SerializedName("email")
    public String email  = "";

    @SerializedName("avatar")
    public String avatar = "";

}
