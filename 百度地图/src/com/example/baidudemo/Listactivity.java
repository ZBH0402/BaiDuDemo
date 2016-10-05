package com.example.baidudemo;

import com.baidu.mapapi.SDKInitializer;


import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.Toast;

public class Listactivity extends ListActivity {

	private GetClassAndName[] objects;
	private Myreceive myreceive;
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		//Intent intent=new Intent(Listactivity.this,objects[position].getCls());
		GetClassAndName f=(GetClassAndName) l.getItemAtPosition(position);
		Intent intent=new Intent(Listactivity.this,f.cls);
		startActivity(intent);
	
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		objects = new GetClassAndName[] {new GetClassAndName(MainActivity.class, "MainActivity"),new GetClassAndName(MapListWithMaylayerActivity.class, "选择地图图层"),new GetClassAndName(MapListWithOverlayerActivity.class, "选择覆盖物类型")};
		ArrayAdapter<GetClassAndName> adapter=new ArrayAdapter<GetClassAndName>(this, android.R.layout.simple_list_item_1,objects);
		setListAdapter(adapter);
		 IntentFilter iFilter=new IntentFilter();
		 myreceive=new Myreceive();
		 
		 iFilter.addAction(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_OK);
	        iFilter.addAction(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR);
	        iFilter.addAction(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
	        registerReceiver(myreceive, iFilter);  
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		 unregisterReceiver(myreceive);
	}
	class Myreceive extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			String action=intent.getAction();
			switch (action) {
			case SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_OK:
				showtoast("你的key验证通过！");
				break;
case SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR:
				showtoast("你的key验证失败！");
				break;
case SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR:
	showtoast("对不起，您的网络有问题！");
	break;
			default:
				break;
			}
			
		}
		
	}
	public void showtoast(CharSequence text){
		Toast toast=Toast.makeText(this, text, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}
class GetClassAndName{
	public Class<?> cls;
	public String name;
	public GetClassAndName(Class<?> cls, String name) {
		super();
		this.cls = cls;
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}

	public Class<?> getCls() {
		return cls;
	}
	
	public String getName() {
		return name;
	}
	
	
}
}
