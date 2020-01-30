package com.example.myfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

public class Crash extends AppCompatActivity {


    Handler handler=new Handler()
    {
        @Override
        public void handleMessage(@NonNull Message msg) {
            TextView crashText=(TextView) findViewById(R.id.crashText);
            crashText.setText("Button Clicked");

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash);
    }

    public void clickMyButton(View view)
    {
        Runnable r=new Runnable() {
            @Override
            public void run() {
                long futureTime=System.currentTimeMillis()+10000;
                while(System.currentTimeMillis()<futureTime)
                {
                    synchronized (this)
                    {
                        try{
                            wait( futureTime-System.currentTimeMillis());
                        }catch (Exception e){

                        }
                    }

                }
                handler.sendEmptyMessage(0);
            }
        };

       Thread myThread = new Thread(r);
        myThread.start();




    }
}
