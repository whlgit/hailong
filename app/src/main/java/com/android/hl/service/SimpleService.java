package com.android.hl.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2016/4/19.
 */
public class SimpleService extends Service {


    @Override
    public void onCreate() {
        log("onCreate");
        super.onCreate();
    }


    @Override
    public void onDestroy() {
        log("start_onDestroy");
        super.onDestroy();
        log("end_onDestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        log("onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }
    int x;
    private void log(String log){
        Log.i("whl",x+"---:"+log);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
