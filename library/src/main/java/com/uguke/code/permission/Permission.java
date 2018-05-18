package com.uguke.code.permission;

import android.Manifest;
import android.annotation.SuppressLint;
import android.icu.util.Calendar;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：权限
 */
public final class Permission {

    public static final Permission CALENDAR = new Permission("日历", Group.CALENDAR, R.drawable.permission_calendar);
    public static final Permission CAMERA = new Permission("相机", Group.CAMERA, R.drawable.permission_camera);
    public static final Permission CONTACTS = new Permission("通讯录", Group.CONTACTS, R.drawable.permission_contacts);
    public static final Permission LOCATION = new Permission("您的位置", Group.LOCATION, R.drawable.permission_location);
    public static final Permission MICROPHONE = new Permission("麦克风", Group.MICROPHONE, R.drawable.permission_microphone);
    public static final Permission PHONE = new Permission("电话", Group.PHONE, R.drawable.permission_phone);
    public static final Permission SENSORS = new Permission("传感器", Group.SENSORS, R.drawable.permission_sensors);
    public static final Permission SMS = new Permission("短信", Group.SMS, R.drawable.permission_sms);
    public static final Permission STORAGE = new Permission("存储", Group.STORAGE, R.drawable.permission_storage);

    /** 权限名 **/
    private final String name;
    /** 权限组 **/
    private final List<String> group;
    /** 权限对应资源 **/
    private @DrawableRes int res;
    /** 权限内容 **/
    private String content;

    private Permission(String name, List<String> group, int res) {
        this.name = name;
        this.group = group;
        this.res = res;
    }

    public void setRes(@DrawableRes int res) {
        this.res = res;
    }

    public int getRes() {
        return res;
    }

    public String getName() {
        return name;
    }

    List<String> getGroup() {
        return group;
    }

    void setContent(String content) {
        this.content = content;
    }

    String getContent() {
        return content;
    }

    /**
     * 功能描述：获取对应权限
     * @param content   权限内容
     * @return          权限
     */
    static Permission getPermission(String content) {
        if (CALENDAR.content != null &&
                CALENDAR.content.equals(content))
            return CALENDAR;
        if (CAMERA.content != null &&
                CAMERA.content.equals(content))
            return CAMERA;
        if (CONTACTS.content != null &&
                CONTACTS.content.equals(content))
            return CONTACTS;
        if (LOCATION.content != null &&
                LOCATION.content.equals(content))
            return LOCATION;
        if (MICROPHONE.content != null &&
                MICROPHONE.content.equals(content))
            return MICROPHONE;
        if (PHONE.content != null &&
                PHONE.content.equals(content))
            return PHONE;
        if (SENSORS.content != null &&
                SENSORS.content.equals(content))
            return SENSORS;
        if (SMS.content != null &&
                SMS.content.equals(content))
            return SMS;
        return STORAGE;
    }

    /**
     * 权限组
     */
    @SuppressLint("InlinedApi")
    private static final class Group {
        // 日历
        static final List<String> CALENDAR =  new ArrayList<String>() {{
            add(Manifest.permission.READ_CALENDAR);
            add(Manifest.permission.WRITE_CALENDAR);
        }};
        // 照相机
        static final List<String> CAMERA = new ArrayList<String>() {{
            add(Manifest.permission.CAMERA);
        }};
        // 联系人
        static final List<String> CONTACTS = new ArrayList<String>() {{
            add(Manifest.permission.WRITE_CONTACTS);
            add(Manifest.permission.GET_ACCOUNTS);
            add(Manifest.permission.READ_CONTACTS);
        }};
        // 位置
        static final List<String> LOCATION = new ArrayList<String>() {{
            add(Manifest.permission.ACCESS_FINE_LOCATION);
            add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }};
        // 麦克风
        static final List<String> MICROPHONE = new ArrayList<String>() {{
            add(Manifest.permission.RECORD_AUDIO);
        }};
        // 手机
        static final List<String> PHONE = new ArrayList<String>() {{
            add(Manifest.permission.READ_CALL_LOG);
            add(Manifest.permission.READ_PHONE_STATE);
            add(Manifest.permission.CALL_PHONE);
            add(Manifest.permission.WRITE_CALL_LOG);
            add(Manifest.permission.USE_SIP);
            add(Manifest.permission.PROCESS_OUTGOING_CALLS);
            add(Manifest.permission.ADD_VOICEMAIL);
        }};
        // 传感器
        static final List<String> SENSORS = new ArrayList<String>() {{
            add(Manifest.permission.BODY_SENSORS);
        }};
        // 短信
        static final List<String> SMS = new ArrayList<String>() {{
            add(Manifest.permission.READ_SMS);
            add(Manifest.permission.RECEIVE_WAP_PUSH);
            add(Manifest.permission.RECEIVE_MMS);
            add(Manifest.permission.RECEIVE_SMS);
            add(Manifest.permission.SEND_SMS);
        }};
        // 存储
        static final List<String> STORAGE = new ArrayList<String>() {{
            add(Manifest.permission.READ_EXTERNAL_STORAGE);
            add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }};
    }

}
