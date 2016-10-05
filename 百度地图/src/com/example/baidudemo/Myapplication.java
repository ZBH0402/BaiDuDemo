package com.example.baidudemo;

import com.baidu.mapapi.SDKInitializer;

import android.app.Application;

public class Myapplication extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		 SDKInitializer.initialize(getApplicationContext());  
	}

}
