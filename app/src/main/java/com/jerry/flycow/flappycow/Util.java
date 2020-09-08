package com.jerry.flycow.flappycow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Util {
public static final String BANNER_POS_ID = "5439248993caadfd87e1f6b6708bf2a6";
public static final String SPLASH_ID = "6abdff0800b2ff7d548e7c643ad05588";
public static final String FALI_ADS_ID = "14c4705d491efd713172486f84f648ca";
    public static final String APP_ID = "2882303761518653362";
    //测试id
//public static final String BANNER_POS_ID = "802e356f1726f9ff39c69308bfd6f06a";
//public static final String SPLASH_ID = "6abdff0800b2ff7d548e7c643ad05588";
//public static final String FALI_ADS_ID = "67b05e7cc9533510d4b8d9d4d78d0ae9";
//    public static final String APP_ID = "2882303761517518052";
private static final int DEFAULT_DENSITY = 1024;
    
    public static Bitmap getScaledBitmapAlpha8(Context context, int id) {
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inPreferredConfig = Bitmap.Config.ALPHA_8;
        bitmapOptions.inScaled = true;
        bitmapOptions.inDensity = DEFAULT_DENSITY;
        bitmapOptions.inTargetDensity = (int)(getScaleFactor(context)*DEFAULT_DENSITY);
        Bitmap b = BitmapFactory.decodeResource(context.getResources(), id, bitmapOptions);
        b.setDensity(context.getResources().getDisplayMetrics().densityDpi);
        return b;
    }
    
    public static Bitmap getDownScaledBitmapAlpha8(Context context, int id) {
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inPreferredConfig = Bitmap.Config.ALPHA_8;
        bitmapOptions.inScaled = true;
        bitmapOptions.inDensity = DEFAULT_DENSITY;
        bitmapOptions.inTargetDensity = Math.min((int)(getScaleFactor(context)*DEFAULT_DENSITY), DEFAULT_DENSITY);
        Bitmap b = BitmapFactory.decodeResource(context.getResources(), id, bitmapOptions);
        b.setDensity(context.getResources().getDisplayMetrics().densityDpi);
        return b;
    }
    
    public static Bitmap getBitmapAlpha8(Context context, int id) {
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inPreferredConfig = Bitmap.Config.ALPHA_8;
        return BitmapFactory.decodeResource(context.getResources(), id, bitmapOptions);
    }
    
    /**
     * Returns a scale factor related to the screen resolution that is used for scaling bitmaps.
     * @param context
     * @return
     */
    public static float getScaleFactor(Context context){
        // 1.2 @ 720x1280 px
        return context.getResources().getDisplayMetrics().heightPixels / 1066f;
    }
}
