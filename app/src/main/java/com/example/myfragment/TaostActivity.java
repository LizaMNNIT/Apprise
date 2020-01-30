package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class TaostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taost);
    }

    public void showToast(View view)
    {
        CharSequence text="This is a toast";
        int duration= Toast.LENGTH_LONG;

        Toast toast= Toast.makeText(this,text,duration);
        toast.show();
    }
}
