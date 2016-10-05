package com.example.baidudemo;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.Gradient;
import com.baidu.mapapi.map.HeatMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.model.LatLng;





import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends BaseActivity {


	

	
	






	@Override
	public void init() {
		
		//HeatMap f=new HeatMap.Builder().gradient()build() ;
		// TODO Auto-generated method stub
		
		//map.addHeatMap(f);
	}

	
		
	
	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		System.out.println( event.getAction());
		MapStatusUpdate m1=null;
		switch (keyCode) {
		case KeyEvent.KEYCODE_1://缩小
			 m1=MapStatusUpdateFactory.zoomOut();
			break;
case KeyEvent.KEYCODE_2://放大
	 m1=MapStatusUpdateFactory.zoomIn();	
			break;
case KeyEvent.KEYCODE_3://旋转
	MapStatus f = map.getMapStatus();
	float dangqian=f.rotate;
	float xianzai=dangqian+30;
	
			MapStatus k=new MapStatus.Builder().rotate(xianzai).build();
			m1=MapStatusUpdateFactory.newMapStatus(k);
	break;
case KeyEvent.KEYCODE_4://俯仰
	MapStatus f1 = map.getMapStatus();
	float d1=f1.overlook;
	float q1=d1-5;
	MapStatus k1=new MapStatus.Builder().overlook(q1).build();
	m1=MapStatusUpdateFactory.newMapStatus(k1);
	break;
case KeyEvent.KEYCODE_5://移动
	
			
			LatLng k2=new LatLng(23.591125, 113.392170);
			m1=MapStatusUpdateFactory.newLatLng(k2);
			map.animateMapStatus(m1, 2000);
			return super.onKeyDown(keyCode, event);


		default:
			break;
		}
		map.setMapStatus(m1);
		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}


	
	@Override  
    protected void onDestroy() {  
        super.onDestroy();  
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理  
       
       
    }  
   
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	
}
