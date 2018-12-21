package com.sstudio.truecallerlite;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class PSservice extends Service {
    public PSservice() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "service started", Toast.LENGTH_SHORT).show();
        Log.d("Service started ","");
        Breciever breciever=new Breciever();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        registerReceiver(breciever,intentFilter);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        //unregisterReceiver();
        super.onDestroy();
    }
}
