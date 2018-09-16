package com.recday.jasonchan.jobcircle.System;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.graphics.Bitmap;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.recday.jasonchan.jobcircle.Model.User;


import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Jason on 16/09/2018.
 *
 */

public class SessionManager {

    //Share pref mode
    private static final int PRIVATE_MODE = 0;
    // SharedPreferences file name
    private static final String PREF_NAME = "LoginSession";

    //Share Preference key
    private static final String IS_LOGIN = "IsLoggedIn";
    private static final String KEY_ID = "id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String API_KEY = "api_key";
    private static final String KEY_PROFILE = "profile";
    private static final String ACTIVATE = "activate";
    private static final String FCM_REG_ID = "gcm_reg_id";
    private static final String KEY_NOTIFICATIONS = "notifications";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    //Constructor
    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createUserLoginSession(int id, String username, String api_key, String profile, String email, int activate) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putInt(KEY_ID, id);
        editor.putString(KEY_USERNAME, username);
        editor.putString(API_KEY, api_key);
        editor.putString(KEY_PROFILE, profile);
        editor.putString(KEY_EMAIL, email);
        if (activate == 1) {
            editor.putBoolean(ACTIVATE, true);
        } else {
            editor.putBoolean(ACTIVATE, false);
        }
        // Save Share Preference
        editor.commit();
    }

    /**
     * Get stored session data
     */
    public User setUserDetails() {
        User user = new User();

        user.setId(sharedPreferences.getInt(KEY_ID, 0));
        user.setUsername(sharedPreferences.getString(KEY_USERNAME, ""));
        user.setEmail(sharedPreferences.getString(KEY_EMAIL, ""));
        user.setApiKey(sharedPreferences.getString(API_KEY, ""));
        if (sharedPreferences.getBoolean(ACTIVATE, false))
            user.setActivate(1);
        else
            user.setActivate(0);

        // return user
        return user;
    }

    /**
     * Get stored session gcm_id
     */
    public void updateFCMRegID(String gcm_id) {
        editor.putString(FCM_REG_ID, gcm_id);
        editor.commit();
    }

    /**
     * Check for login states
     **/
    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }

    /**
     * Check for activate
     **/
    public boolean isActivate() {
        return (sharedPreferences.getInt(ACTIVATE, 0) == 1);
    }

    /**
     * Get stored session api_key
     */
    public String getMemberApiKey() {
        return sharedPreferences.getString(API_KEY, "");
    }

    public void addNotification(String notification) {
        String oldNotifications = getNotifications();
        if (oldNotifications != null) {
            oldNotifications += "|" + notification;
        } else {
            oldNotifications = notification;
        }
        editor.putString(KEY_NOTIFICATIONS, oldNotifications);
        editor.commit();
    }

    public String getNotifications() {
        return sharedPreferences.getString(KEY_NOTIFICATIONS, null);
    }

    public void clearNotification() {
        editor.putString(KEY_NOTIFICATIONS, null);
        editor.commit();
    }

    /**
     * Logout for local details
     */
    public void clear() {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();
    }


    public void getSaveProfileImage(String image_url) {

        Glide.with(context)
                .asBitmap()
                .load(image_url)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                        saveToInternalStorage(resource, "cover.png");
                    }
                });
    }

    public String saveToInternalStorage(Bitmap bitmapImage, String name) {
        ContextWrapper cw = new ContextWrapper(context);
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("BontiqueMember", Context.MODE_PRIVATE);
        File myPath = new File(directory, name);

        FileOutputStream fos;
        try {
            fos = new FileOutputStream(myPath);
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 60, fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return directory.getAbsolutePath();
    }
}
