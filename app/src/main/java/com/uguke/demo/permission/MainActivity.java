package com.uguke.demo.permission;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.uguke.code.permission.HiPermission;
import com.uguke.code.permission.Permission;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Permission> permissions = new ArrayList<>();
        permissions.add(Permission.PHONE);
        permissions.add(Permission.CALENDAR);
        permissions.add(Permission.STORAGE);
        permissions.add(Permission.CAMERA);
        permissions.add(Permission.MICROPHONE);
        permissions.add(Permission.SENSORS);
        permissions.add(Permission.SMS);
        permissions.add(Permission.LOCATION);
        permissions.add(Permission.CONTACTS);

        // 需要什么权限增加什么权限
        HiPermission.with(this)
                .permissions(
                        Permission.PHONE,
                        Permission.CALENDAR,
                        Permission.CAMERA)
                .permissions(permissions)       // 两种方式都可以
                .onGranted(new HiPermission.OnGrantedListener() {
                    @Override
                    public void onGranted(List<Permission> permissions) {

                    }
                })
                .onDenied(new HiPermission.OnDeniedListener() {
                    @Override
                    public void onDenied(List<Permission> permissions) {

                    }
                })
                .onRationale(new HiPermission.OnRationaleListener() {
                    @Override
                    public void onRationale(List<Permission> permissions) {

                    }
                })
                .request();


    }
}
