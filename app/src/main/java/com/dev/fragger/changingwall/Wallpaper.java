package com.dev.fragger.changingwall;

import java.util.Random;

/**
 * Created by fragger on 7/6/16.
 */
public class Wallpaper {

//    static Integer wallpaperResourceId[]={
//            R.drawable.w1,
//            R.drawable.w2,
//            R.drawable.w3,
//            R.drawable.w5,
//            R.drawable.w6,
//            R.drawable.w7,
//            R.drawable.w8,
//            R.drawable.w9,
//            R.drawable.w10,
//            R.drawable.w11,
//            R.drawable.w12
//    };

    static String wallpaperResourceId[]={
            "w1",
            "w2",
            "w3",
            "w5",
            "w6",
            "w7",
            "w8",
            "w9",
            "w10",
            "w11",
            "w12"
    };

    static int curWallKey=0;

    static void nextWall(){
        curWallKey++;

        if(curWallKey>(wallpaperResourceId.length-1))
            curWallKey=0;
    }

    static void prevWall() {
        --curWallKey;
        if(curWallKey<0)
            curWallKey=wallpaperResourceId.length-1;
    }

}
