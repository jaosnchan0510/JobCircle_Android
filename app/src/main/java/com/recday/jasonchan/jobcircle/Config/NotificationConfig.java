package com.recday.jasonchan.jobcircle.Config;


/**
 * Created by Jason on 16/09/2018.
 *
 */

public class NotificationConfig {

    // global topic to receive app wide push notifications
    public static final String TOPIC_GLOBAL = "global";

    // broadcast receiver intent filters
    public static final String REGISTRATION_COMPLETE = "registrationComplete";
    public static final String PUSH_NOTIFICATION = "pushNotification";
    // type of push messages
    public static final int PUSH_TYPE_NEWS = 1;
    public static final int PUSH_TYPE_MEMBER = 2;
    public static final int PUSH_TYPE_ORDER_REQUEST = 3;
    // id to handle the notification in the notification try
    public static final int NOTIFICATION_ID = 100;
}
