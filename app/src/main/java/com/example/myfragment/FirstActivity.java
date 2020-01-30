package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Bundle firstData=getIntent().getExtras();
        if(firstData==null)
        {
            return;
        }
        String firstMessage= firstData.getString("firstMessage");

        final TextView secondText=(TextView) findViewById(R.id.textView2);

        secondText.setText(firstMessage);
    }
}
