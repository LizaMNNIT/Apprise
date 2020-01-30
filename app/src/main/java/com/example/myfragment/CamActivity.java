package com.example.myfragment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CamActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE=1;

    ImageView camera_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam);

        Button capture_button=(Button) findViewById(R.id.capture_button);
        camera_view=(ImageView)findViewById(R.id.camera_view);

       if(!hasCamera())
           capture_button.setEnabled(false);

    }

    public boolean hasCamera()
    {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }


    public void launchCamera(View view)
    {
        Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(i,REQUEST_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap photo=(Bitmap)extras.get("data");
            camera_view.setImageBitmap(photo);
        }
    }
}
