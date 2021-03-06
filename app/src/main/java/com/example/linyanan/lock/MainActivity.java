package com.example.linyanan.lock;

import android.app.ActivityOptions;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.locks.Lock;


public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        DevicePolicyManager myDevicePolicyManager = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);

        ComponentName mDPM = new ComponentName(this, AdminReceiver.class);

        if (myDevicePolicyManager.isDeviceOwnerApp(this.getPackageName())) {
            String[] packages = {this.getPackageName()};
            myDevicePolicyManager.setLockTaskPackages(mDPM, packages);
            startLockTask();
        } else {
            Toast.makeText(getApplicationContext(), "Not owner", Toast.LENGTH_LONG).show();
        }
    }


    //voice
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//
//        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
//            Toast.makeText(this, "Volume button is disabled", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//
//        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
//            Toast.makeText(this, "Volume button is disabled", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//
//        return super.onKeyDown(keyCode, event);
//    }

//    private DevicePolicyManager mDevicePolicyManager;
//    private ComponentName mComponentName;
//    private TextView textView;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        textView = (TextView) findViewById(R.id.button);
//        mDevicePolicyManager = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
//        mComponentName = new ComponentName(this, AdminReceiver.class);
//        setLock();
//
//        if (!mDevicePolicyManager.isAdminActive(mComponentName)) {
//            Intent intent =
//                    new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
//            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mComponentName);
//            intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "----这是一键锁屏激活界面-----");
//            startActivityForResult(intent, 0);
//
////            mDevicePolicyManager.setPasswordQuality(mComponentName, DevicePolicyManager.PASSWORD_QUALITY_UNSPECIFIED);
////            mDevicePolicyManager.setPasswordMinimumLength(mComponentName, 0);
////            mDevicePolicyManager.removeActiveAdmin(mComponentName);
//
//        }
//
//    }
//
//    public void setLock() {
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                mDevicePolicyManager.resetPassword("nick6425", DevicePolicyManager.RESET_PASSWORD_REQUIRE_ENTRY);
////                mDevicePolicyManager.lockNow();
//            }
//        });
//
//    }

}
