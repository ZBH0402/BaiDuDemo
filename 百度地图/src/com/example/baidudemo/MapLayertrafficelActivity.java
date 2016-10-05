package com.example.baidudemo;

import com.baidu.mapapi.map.BaiduMap;

import android.view.KeyEvent;

public class MapLayertrafficelActivity extends BaseActivity{

	@Override
	public void init() {
		// TODO Auto-generated method stub
		map.setMapType( BaiduMap.MAP_TYPE_NORMAL);//∆’Õ®µÿÕº
		map.setTrafficEnabled(true);
	}

}
