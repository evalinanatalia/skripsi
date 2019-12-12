package com.example.trusts.support;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.trusts.model.Profile;
import com.google.gson.Gson;

public class Preferences {
    public static final String TAG = "Preferences";

    private Context mContext;

    public static SharedPreferences mSharedPreferences;

    public static final String IS_USER_LOGIN = "is_user_login";
    public static final String TOKEN = "token";
    public static final String PROFILE = "profile";

    public Preferences(Context mContext) {
        this.mContext = mContext;
        mSharedPreferences = mContext.getSharedPreferences("pede_emoney_preference", 0);
    }

    public void saveProfile(Profile userDetail) {
        SharedPreferences.Editor e = mSharedPreferences.edit();
        e.putString(Preferences.PROFILE, new Gson().toJson(userDetail));
        e.apply();
    }

    /**
     * Get User Detail
     * @return UserDetail
     */
    public Profile getProfile(){
        String  userDetailJSON = mSharedPreferences.getString(Preferences.PROFILE, "");
        return new Gson().fromJson(userDetailJSON, Profile.class);
    }
}
