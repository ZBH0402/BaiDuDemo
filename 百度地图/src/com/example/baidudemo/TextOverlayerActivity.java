package com.example.baidudemo;

import android.graphics.Color;

import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.model.LatLng;

public class TextOverlayerActivity extends BaseActivity {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		TextOptions f=new TextOptions();
		f.position(new LatLng(23.06008,113.3857303)).text("这是华南师范大学").fontSize(20)
		.fontColor(Color.BLACK).bgColor(0X55ff0000).rotate(-30);
map.addOverlay(f);
	}

}
