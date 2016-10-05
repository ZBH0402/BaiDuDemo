package com.example.baidudemo;


import com.example.baidudemo.Listactivity.GetClassAndName;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class MapListWithMaylayerActivity extends Listactivity{
	private GetClassAndName[] objects;
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		//Intent intent=new Intent(Listactivity.this,objects[position].getCls());
		GetClassAndName f=(GetClassAndName) l.getItemAtPosition(position);
		Intent intent=new Intent(MapListWithMaylayerActivity.this,f.cls);
		startActivity(intent);
	
	}
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		objects = new GetClassAndName[] {new GetClassAndName(MapLayernomalActivity.class, "普通地图"),new GetClassAndName(MapLayerWeixinglActivity.class, "卫星地图"),new GetClassAndName(MapLayertrafficelActivity.class, "交通地图")};
		ArrayAdapter<GetClassAndName> adapter=new ArrayAdapter<GetClassAndName>(this, android.R.layout.simple_list_item_1,objects);
		setListAdapter(adapter);
		
		 
		
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
