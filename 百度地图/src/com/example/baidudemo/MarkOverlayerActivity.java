package com.example.baidudemo;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BaiduMap.OnMarkerDragListener;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.MapViewLayoutParams.ELayoutMode;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;

public class MarkOverlayerActivity extends BaseActivity{
	private View child;
	@Override
	public void init() {
		// TODO Auto-generated method stub
		MarkerOptions m=new MarkerOptions();
		BitmapDescriptor f=BitmapDescriptorFactory.fromResource(R.drawable.icon_gcoding);
		m.position(new LatLng(23.06008,113.3857303)).title("华南师范大学").icon(f).draggable(true);
		map.addOverlay(m);
		
		map.setOnMarkerClickListener(onMarkerClickListener);
		
		map.setOnMarkerDragListener(onMarkerDragListener);
	}
	OnMarkerDragListener onMarkerDragListener=new OnMarkerDragListener() {
		
		@Override
		public void onMarkerDragStart(Marker arg0) {
			
			
			
   MapViewLayoutParams p=new MapViewLayoutParams.Builder().layoutMode(ELayoutMode.mapMode).yOffset(-40).position(arg0.getPosition()).build();

			mMapView.updateViewLayout(child, p);

			
		}
		
		@Override
		public void onMarkerDragEnd(Marker arg0) {
			 MapViewLayoutParams p=new MapViewLayoutParams.Builder().layoutMode(ELayoutMode.mapMode).yOffset(-40).position(arg0.getPosition()).build();

				mMapView.updateViewLayout(child, p);
			
		}
		
		@Override
		public void onMarkerDrag(Marker arg0) {
			 MapViewLayoutParams p=new MapViewLayoutParams.Builder().layoutMode(ELayoutMode.mapMode).yOffset(-40).position(arg0.getPosition()).build();

				mMapView.updateViewLayout(child, p);
			
		}
	};
	OnMarkerClickListener onMarkerClickListener=new OnMarkerClickListener() {
		
		

		@Override
		public boolean onMarkerClick(Marker arg0) {
			 child=View.inflate(MarkOverlayerActivity.this, R.layout.pop, null);
			TextView tView=(TextView) child.findViewById(R.id.tv_title);
			
			MapViewLayoutParams p=new MapViewLayoutParams.Builder().layoutMode(ELayoutMode.mapMode).yOffset(-40).position(arg0.getPosition()).build();
			mMapView.addView(child,p);
			tView.setText(arg0.getTitle());
			return true;
		}
	};
}
