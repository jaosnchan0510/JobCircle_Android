package com.recday.jasonchan.jobcircle.System;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jason on 16/9/2018.
 *
 */

public class SettingManager {

    //Share pref mode
    private static final int PRIVATE_MODE = 0;
    // SharedPreferences file name
    private static final String PREF_NAME = "SettingManager";
    //Share Preference key
    private static final String KEY_LANG = "lang";
    private static final String KEY_NOT = "notification";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String KEY_UNREAD = "unread";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    public SettingManager(Context context) {
        this.context = context;
        this.sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        this.editor = sharedPreferences.edit();
    }

    public String getLanguage(){
        String lang = "";
        lang  = this.sharedPreferences.getString(KEY_LANG, "en");
        return lang;
    }

    public void changeLanguage(String lang){
        this.editor.putString(KEY_LANG, lang);
        this.editor.commit();
    }

    public boolean hasNotification(){
        return this.sharedPreferences.getBoolean(KEY_NOT, true);
    }

    public void changeNotification(boolean onNotification){
        this.editor.putBoolean(KEY_LANG, onNotification);
        this.editor.commit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return sharedPreferences.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public void switchToUnread(boolean has_unread){
        editor.putBoolean(KEY_UNREAD, has_unread);
        editor.commit();
    }

    public boolean hasUnreadMessage(){
        return sharedPreferences.getBoolean(KEY_UNREAD, false);
    }
}
