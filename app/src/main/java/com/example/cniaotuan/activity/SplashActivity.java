package com.example.cniaotuan.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.example.cniaotuan.R;

public class SplashActivity extends AppCompatActivity {

    private String[] permissions = {PermissionConstants.PHONE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        requestPermissions();
    }

    private void requestPermissions() {
        PermissionUtils.permission(permissions)
                .callback(new PermissionUtils.SimpleCallback() {
                    @Override
                    public void onGranted() {
                        ActivityUtils.startActivity(MainActivity.class);
                        finish();
                    }

                    @Override
                    public void onDenied() {

                    }
                }).request();
    }
}
