package com.jerry.flycow.flappycow;

import android.app.Application;

import com.miui.zeus.mimo.sdk.MimoSdk;

public class MApp extends Application
{
	@Override
	public void onCreate()
	{
		super.onCreate();
		MimoSdk.init(this, Util.APP_ID);
//// 以下为调试开关，上线需关闭，默认均为false
		MimoSdk.setDebugOn(true); // 设置sdk 是否打开debug
		MimoSdk.setStagingOn(true); // 设置sdk是否打开测试环境
	}
}
