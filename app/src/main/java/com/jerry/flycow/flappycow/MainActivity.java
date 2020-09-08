/**
 * Main Activity / Splashscreen with buttons.
 * 
 * @author Lars Harmsen
 * Copyright (c) <2014> <Lars Harmsen - Quchen>
 */

package com.jerry.flycow.flappycow;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.example.games.basegameutils.BaseGameActivity;
import com.jerry.flycow.R;
import com.miui.zeus.mimo.sdk.BannerAd;

public class MainActivity extends BaseGameActivity
{
    private static final String TAG = "xuxu";
    /** Name of the SharedPreference that saves the medals */
    public static final String medaille_save = "medaille_save";
    
    /** Key that saves the medal */
    public static final String medaille_key = "medaille_key";
    
    public static final float DEFAULT_VOLUME = 0.3f;
    
    /** Volume for sound and music */
    public static float volume = DEFAULT_VOLUME;
    
    private StartscreenView view;
    private ViewGroup ads;

    BannerAd mBannerAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //view = new StartscreenView(this);
        setContentView(R.layout.home);
        view=findViewById(R.id.start);
        ads=findViewById(R.id.ads);
        setSocket();
        fetchAds();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        if (mBannerAd != null) {
            mBannerAd.destroy();
        }
    }

    private void fetchAds()
    {
        if (mBannerAd != null) {
            mBannerAd.destroy();
        }
        mBannerAd = new BannerAd(this);
        mBannerAd.loadAd(Util.BANNER_POS_ID, new BannerAd.BannerLoadListener() {
            @Override
            public void onBannerAdLoadSuccess() {
                //showBtn.setEnabled(true);
                mBannerAd.showAd(ads, mBannerInteractionListener);
            }

            @Override
            public void onAdLoadFailed(int errorCode, String errorMsg) {
                Log.e(TAG, "errorCode " + errorCode + " errorMsg " + errorMsg);
            }
        });
    }
    private BannerAd.BannerInteractionListener mBannerInteractionListener = new BannerAd.BannerInteractionListener() {
        @Override
        public void onAdClick() {
            Log.d(TAG, "onAdClick");
        }

        @Override
        public void onAdShow() {
            Log.d(TAG, "onAdShow");
        }

        @Override
        public void onAdDismiss() {
            Log.d(TAG, "onAdDismiss");
        }

        @Override
        public void onRenderSuccess() {
            Log.d(TAG, "onRenderSuccess");
        }

        @Override
        public void onRenderFail(int code, String msg) {
            Log.e(TAG, "onRenderFail errorCode " + code + " errorMsg " + msg);
        }
    };
//    public GoogleApiClient getApiClient(){
//        return mHelper.getApiClient();
//    }
    
    public void login() {
       // beginUserInitiatedSignIn();
    }
    
    public void logout() {
       // signOut();
        view.setOnline(false);
        view.invalidate();
    }
    
    public void muteToggle() {
        if(volume != 0){
            volume = 0;
            view.setSpeaker(false);
        }else{
            volume = DEFAULT_VOLUME;
            view.setSpeaker(true);
        }
        view.invalidate();
    }
    
    /**
     * Fills the socket with the medals that have already been collected.
     */
    private void setSocket(){
        SharedPreferences saves = this.getSharedPreferences(medaille_save, 0);
        view.setSocket(saves.getInt(medaille_key, 0));
        view.invalidate();
    }

    /**
     * Updates the socket for the medals.
     */
    @Override
    protected void onResume() {
        super.onResume();
        setSocket();
    }

//    @Override
//    public void onSignInFailed() {
//        Toast.makeText(this, "You're not logged in", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onSignInSucceeded() {
//        Toast.makeText(this, "You're logged in", Toast.LENGTH_SHORT).show();
//        view.setOnline(true);
//        view.invalidate();
//        if(AccomplishmentBox.isOnline(this)){
//            AccomplishmentBox.getLocal(this).submitScore(this, getApiClient());
//        }
//    }
    
}
