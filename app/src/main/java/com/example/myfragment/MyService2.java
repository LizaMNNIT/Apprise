package com.example.myfragment;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService2 extends Service {

    private final IBinder myBinder= new MyLocalBinder();
    public MyService2() {
    }

   public class MyLocalBinder extends Binder {

        MyService2 getService(){
            return MyService2.this;
        }

   }

   public String getCurrentTime(){
       SimpleDateFormat df= new SimpleDateFormat("HH:mm:ss", Locale.US);
       return (df.format(new Date()));
   }
    @Override
    public IBinder onBind(Intent intent) {
      return  myBinder;
    }
}
