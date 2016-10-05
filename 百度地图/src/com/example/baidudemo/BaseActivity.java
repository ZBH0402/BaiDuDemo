package com.example.baidudemo;


import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.widget.Toast;

public abstract class BaseActivity extends Activity{
	private BroadcastReceiver myreceive;
	private String TAG="BaseActivity";
	protected MapView mMapView;
	protected BaiduMap map;
	@Override
	protected final void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//��ʹ��SDK�����֮ǰ��ʼ��context��Ϣ������ApplicationContext  
        //ע��÷���Ҫ��setContentView����֮ǰʵ��  
       
		setContentView(R.layout.activity_main);
		 mMapView = (MapView) findViewById(R.id.bmapView);
		 map = mMapView.getMap();
		 LatLng lng=new LatLng(23.06008,113.3857303);
		MapStatusUpdate m=MapStatusUpdateFactory.newLatLng(lng);
		map.setMapStatus(m);
		MapStatusUpdate m1=MapStatusUpdateFactory.zoomTo(10);
		map.setMapStatus(m1);
		
		Log.i(TAG, "MaxZoomLevel:"+map.getMaxZoomLevel()+",MinZoomLevel:"+map.getMinZoomLevel());
//		mMapView.showScaleControl(true);
//		mMapView.showZoomControls(true);
		init();
	}
	
	public abstract void init() ;
	


	
	
	
	@Override  
    protected void onDestroy() {  
        super.onDestroy();  
        //��activityִ��onDestroyʱִ��mMapView.onDestroy()��ʵ�ֵ�ͼ�������ڹ���  
        mMapView.onDestroy();  
     
    }  
    @Override  
    protected void onResume() {  
        super.onResume();  
        //��activityִ��onResumeʱִ��mMapView. onResume ()��ʵ�ֵ�ͼ�������ڹ���  
        mMapView.onResume();  
        }  
    @Override  
    protected void onPause() {  
        super.onPause();  
        //��activityִ��onPauseʱִ��mMapView. onPause ()��ʵ�ֵ�ͼ�������ڹ���  
        mMapView.onPause();  
        }  
	

}
