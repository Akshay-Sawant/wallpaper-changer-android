package com.dev.fragger.changingwall;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class WallChange extends AppCompatActivity implements View.OnClickListener{

    TextView leftMoveImg,rightMoveImg;
    Button setWallBtn;
    ImageView wallPreview;
    Drawable image;
    InputStream in;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_change);
        setViewsListeners();
        Wallpaper.curWallKey=new Random().nextInt(Wallpaper.wallpaperResourceId.length);
        setImage(Wallpaper.curWallKey);

    }

    @Override
    public void onClick(View v) {

        if(v==setWallBtn){
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

            try {
                wallpaperManager.setStream(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(WallChange.this, "Changed!", Toast.LENGTH_SHORT).show();
            Wallpaper.nextWall();
        }
        else if(v==leftMoveImg) {
            Wallpaper.prevWall();
        }

        else if(v==rightMoveImg) {
            Wallpaper.nextWall();
        }

        setImage(Wallpaper.curWallKey);

        return;

    }

    void setViewsListeners() {
        leftMoveImg = (TextView) findViewById(R.id.leftMoveImage);
        rightMoveImg = (TextView) findViewById(R.id.rightMoveImage);
        setWallBtn = (Button) findViewById(R.id.btnSetWall);
        wallPreview = (ImageView) findViewById(R.id.wallPreview);

        leftMoveImg.setOnClickListener(this);
        rightMoveImg.setOnClickListener(this);
        setWallBtn.setOnClickListener(this);
    }


    void setImage(int id) {

        int imgId = getResources().getIdentifier(Wallpaper.wallpaperResourceId[id],"raw",getPackageName());

        in = getResources().openRawResource(imgId);
        image = Drawable.createFromStream(in, Wallpaper.wallpaperResourceId[id]);
        wallPreview.setImageDrawable(image);

    }


}
