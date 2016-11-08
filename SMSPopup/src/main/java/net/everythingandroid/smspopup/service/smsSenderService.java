package net.everythingandroid.smspopup.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.util.Log;
public class smsSenderService extends Service{
    public smsSenderService(){

    }

    @Override
    public IBinder onBind(Intent in){
        throw new UnsupportedOperationException("To do");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){

        String phoneNumber = intent.getStringExtra("phNo");
        String areaCode = phoneNumber.substring(0, 3);
        String msg = intent.getStringExtra("txtMsg");
        Log.i("TEXTING custom", "Send a message to " + phoneNumber + " text: " + msg);
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, msg, null, null);
        return START_STICKY;
    }
}
