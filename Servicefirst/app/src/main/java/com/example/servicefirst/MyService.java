package com.example.servicefirst;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public class MyService extends Service {


    public MyService() {


    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public class FirstThread extends Thread {

        int counter = 30;

        @Override

        public void run() {

            super.run();


            while (counter > 0) {

                try {

                    Thread.sleep(1000);

                    Log.d("service", "timer : " + counter);

                    counter--;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            stopSelf();
        }
    }
}