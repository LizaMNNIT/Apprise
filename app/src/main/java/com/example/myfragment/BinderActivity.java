package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;

import com.example.myfragment.MyService2.MyLocalBinder;

public class BinderActivity extends AppCompatActivity {

    MyService2 myService;
    boolean isBound=false;

    public void setTime(View view){
       String currentTime= myService.getCurrentTime();
       TextView text3 = (TextView)findViewById(R.id.binder_text);
       text3.setText(currentTime);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binder);
        Intent i= new Intent(this,MyService2.class);
        bindService(i,myConnection, Context.BIND_AUTO_CREATE);
    }



    private ServiceConnection myConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyLocalBinder binder=(MyLocalBinder) service;
            myService=binder.getService();
            isBound=true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
         isBound=false;
        }
    };
}
