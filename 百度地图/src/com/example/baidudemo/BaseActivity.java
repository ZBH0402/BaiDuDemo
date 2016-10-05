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
		//在使用SDK各组件之前初始化context信息，传入ApplicationContext  
        //注意该方法要再setContentView方法之前实现  
       
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
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理  
        mMapView.onDestroy();  
     
    }  
    @Override  
    protected void onResume() {  
        super.onResume();  
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理  
        mMapView.onResume();  
        }  
    @Override  
    protected void onPause() {  
        super.onPause();  
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理  
        mMapView.onPause();  
        }  
	

}
