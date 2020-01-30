package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    ImageView image_view;
    Drawable machine;
    Bitmap bitmapImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        image_view=(ImageView)findViewById(R.id.image_view);
        machine= ResourcesCompat.getDrawable(getResources(),R.drawable.parcel,null);
        bitmapImage=((BitmapDrawable)machine).getBitmap();

        Bitmap new_photo=InvertImage(bitmapImage);
        image_view.setImageBitmap(new_photo);
    }

  public static Bitmap InvertImage(Bitmap original)
  {
      Bitmap finalImage=Bitmap.createBitmap(original.getWidth(),original.getHeight(),original.getConfig());

      int A,R,G,B;
      int pixelcolor;
      int height=original.getHeight();
      int width=original.getWidth();

      for(int y=0;y<height;y++)
      {
          for(int x=0;x<width;x++)
          {
              pixelcolor=original.getPixel(x,y);
              A= Color.alpha(pixelcolor);
              R=255- Color.red(pixelcolor);
              G=255- Color.green(pixelcolor);
              B=255- Color.blue(pixelcolor);

              finalImage.setPixel(x,y,Color.argb(A,R,G,B));
          }
      }
    return finalImage;
  }

}
