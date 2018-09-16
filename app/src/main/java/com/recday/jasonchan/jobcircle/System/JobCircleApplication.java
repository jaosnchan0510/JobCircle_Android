package com.recday.jasonchan.jobcircle.System;

import android.app.Application;
import android.content.res.Configuration;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.Locale;

/**
 * Created by Jason on 16/09/2018.
 *
 */

public class JobCircleApplication extends Application {

    public static final String TAG = JobCircleApplication.class.getSimpleName();

    private static JobCircleApplication context;
    private SessionManager session;
    private SettingManager setting;
    private RequestQueue rq;

    public static synchronized JobCircleApplication getInstance() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        this.setUpLanguage();
    }

    private void setUpLanguage() {
        Configuration config = getBaseContext().getResources().getConfiguration();
        String lang = JobCircleApplication.getInstance().getSetting().getLanguage();
        if (!lang.equals("") && !config.locale.getLanguage().equals(lang)) {
            Locale locale;
            switch (lang) {
                case "zh-rCN":
                    locale = new Locale("zh", "CN");
                    break;
                case "zh-rHK":
                    locale = new Locale("zh", "HK");
                    break;
                case "en":
                default:
                    locale = new Locale("en");
                    break;
            }
            Locale.setDefault(locale);
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }
    }

    public SessionManager getSession(){
        if(session == null){
            session = new SessionManager(this);
        }
        return session;
    }

    public SettingManager getSetting(){
        if(setting == null){
            setting = new SettingManager(this);
        }
        return setting;
    }

    public RequestQueue getRequestQueue() {
        if (rq == null) {
            rq = Volley.newRequestQueue(getApplicationContext());
        }
        return rq;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (rq != null) {
            rq.cancelAll(tag);
        }
    }
}
