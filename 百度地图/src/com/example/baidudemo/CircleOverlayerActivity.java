package com.example.baidudemo;

import android.graphics.Color;

import com.baidu.mapapi.map.CircleOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.model.LatLng;

public class CircleOverlayerActivity extends BaseActivity {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		CircleOptions s=new CircleOptions();
		s.fillColor(0x55FF0000)
		.center(new LatLng(23.06008,113.3857303))
		.radius(1000).stroke(new Stroke(20, 0x55000000));
		map.addOverlay(s);
		
	}

}
