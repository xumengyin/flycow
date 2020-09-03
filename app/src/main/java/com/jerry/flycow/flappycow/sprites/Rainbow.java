/**
 * Rainbow tail for the nyan cat
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


public class Rainbow extends Sprite {
    
    /**
     * Static bitmap to reduce memory usage.
     */
    public static Bitmap globalBitmap;
    
    public Rainbow(GameView view, Game game) {
        super(view, game);
        if(globalBitmap == null){
            globalBitmap = Util.getScaledBitmapAlpha8(game, R.drawable.rainbow);
        }
        this.bitmap = globalBitmap;
        this.width = this.bitmap.getWidth()/(colNr = 4);
        this.height = this.bitmap.getHeight()/3;
    }

    @Override
    public void move() {
        changeToNextFrame();
        super.move();
    }
    
    
}
