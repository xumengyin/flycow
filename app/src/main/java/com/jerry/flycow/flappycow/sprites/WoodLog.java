/**
 * A shopped wodden log
 * 
 * @author Lars Harmsen
 * Copyright (c) <2014> <Lars Harmsen - Quchen>
 */

package com.jerry.flycow.flappycow.sprites;

import android.graphics.Bitmap;

import com.jerry.flycow.R;
import com.jerry.flycow.flappycow.Game;
import com.jerry.flycow.flappycow.GameView;
import com.jerry.flycow.flappycow.Util;


public class WoodLog extends Sprite {

    /**
     * Static bitmap to reduce memory usage.
     */
    public static Bitmap globalBitmap;

    public WoodLog(GameView view, Game game) {
        super(view, game);
        if(globalBitmap == null){
            globalBitmap = Util.getScaledBitmapAlpha8(game, R.drawable.log_full);
        }
        this.bitmap = globalBitmap;
        this.width = this.bitmap.getWidth();
        this.height = this.bitmap.getHeight();
    }
    
    /**
     * Sets the position
     * @param x
     * @param y
     */
    public void init(int x, int y){
        this.x = x;
        this.y = y;
    }
}
