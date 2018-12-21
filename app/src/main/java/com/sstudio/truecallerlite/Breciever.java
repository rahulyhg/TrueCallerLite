package com.sstudio.truecallerlite;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class Breciever extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        Log.d("Onrecieve ","");
        Toast.makeText(context, "reciever", Toast.LENGTH_SHORT).show();
        if (intent.getAction().equals("android.intent.action.PHONE_STATE")){
        TelephonyManager telephonyManager=(TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        telephonyManager.listen(new PhoneStateListener(){

            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                super.onCallStateChanged(state, incomingNumber);
                Log.d("Incoming  number :  ",incomingNumber+"   and state : "+state);
                Toast.makeText(context, ""+incomingNumber, Toast.LENGTH_SHORT).show();
               if (incomingNumber.length()>3 && state==1){
                Intent i=new Intent(context,Search.class);
                i.putExtra("number",incomingNumber);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
            }
        },PhoneStateListener.LISTEN_CALL_STATE);
    }}
}
