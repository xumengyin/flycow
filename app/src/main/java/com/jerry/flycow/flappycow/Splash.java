package com.jerry.flycow.flappycow;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

import com.jerry.flycow.R;
import com.miui.zeus.mimo.sdk.SplashAd;

public class Splash extends Activity
{

	private static final String TAG = "Splash";
	View aniView;
	ViewGroup adsLayout;
	Handler handler =new Handler();
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		aniView=findViewById(R.id.ani);
		adsLayout=findViewById(R.id.adsLayout);
		ads();
		checkP();
	}

	private void ani()
	{

	}
	private void checkP()
	{
		if (Build.VERSION.SDK_INT >= 23) {
			if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
					!= PackageManager.PERMISSION_GRANTED
					|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
					!= PackageManager.PERMISSION_GRANTED ){
				ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
						Manifest.permission.READ_PHONE_STATE}, 0);
			}else
			{
				goMain(true);
			}
		}else
		{
			goMain(true);
		}
	}

	@Override
	public void onRequestPermissionsResult(int requestCode,@NonNull String[] permissions, @NonNull int[] grantResults)
	{
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		goMain(false);
	}
	private void goMain(boolean wait)
	{
		if(wait)
		{
				handler.postDelayed(new Runnable()
				{
					@Override
					public void run()
					{
						startActivity(new Intent(Splash.this,MainActivity.class));
						finish();
					}
				},3000);
		}else
		{
			startActivity(new Intent(this,MainActivity.class));
			finish();
		}

	}
	SplashAd mSplashAd;
	SplashAd.SplashAdListener listener =new SplashAd.SplashAdListener()
	{
		@Override
		public void onAdShow()
		{
			Log.d(TAG, "onAdShow: ");
		}

		@Override
		public void onAdClick()
		{
			Log.d(TAG, "onAdClick: ");
		}

		@Override
		public void onAdDismissed()
		{
			Log.d(TAG, "onAdDismissed: ");
		}

		@Override
		public void onAdLoadFailed(int i, String s)
		{
			Log.d(TAG, "onAdLoadFailed: ");
		}

		@Override
		public void onAdLoaded()
		{
			Log.d(TAG, "onAdLoaded: ");
		}

		@Override
		public void onAdRenderFailed()
		{
			Log.d(TAG, "onAdRenderFailed: ");
		}
	};
	private void ads()
	{

		destroyAds();
		mSplashAd = new SplashAd(this);
/** * 请求并展示广告 * mContainer 装载广告的容器 * POSITION_ID 广告位id * mSplashAdListener 广告监听listener */
		mSplashAd.loadAndShow(adsLayout, Util.SPLASH_ID, listener);
	}
	private void destroyAds()
	{
		if(mSplashAd!=null)
		{
			mSplashAd.destroy();
			mSplashAd=null;
		}
	}
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		destroyAds();
	}
}