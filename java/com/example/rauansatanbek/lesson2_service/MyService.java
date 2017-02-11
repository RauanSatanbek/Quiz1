package com.example.rauansatanbek.lesson2_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MyService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("MyLogs", "StartId: " + startId);
        try {
            task();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    void task() throws InterruptedException {
        for(int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1000);
            Log.d("MyLogs", "i = " + i);
        }
        stopSelf();
    }
}
