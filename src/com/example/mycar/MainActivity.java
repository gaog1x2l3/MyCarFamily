package com.example.mycar;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.example.mycar.fragment.Fragment_BBS;
import com.example.mycar.fragment.Fragment_Dis;
import com.example.mycar.fragment.Fragment_Mine;
import com.example.mycar.fragment.Fragment_ZiXun;
import com.example.mycar.utils.SharePrefUtil;

/**
 * 主页
 * 
 * @author gao
 * 
 */
public class MainActivity extends FragmentActivity implements
		OnCheckedChangeListener, BDLocationListener {
	private RadioGroup radioGroup;
	private List<Fragment> list;
	private FragmentManager fragmentManager;
	private FragmentTransaction transaction;
	private int currentTabIndex = 0;
	private LocationClient client;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initData();
		// 创建定位客户端对象。
		client = new LocationClient(getApplicationContext());
		initClient();
		// 开始定位
		client.start();
		client.requestLocation();// 请求定位。
		client.registerLocationListener(this);
	}

	public void initClient() {
		LocationClientOption option = new LocationClientOption();
		// 设置一些属性。
		option.setLocationMode(LocationMode.Hight_Accuracy);// 高精度定位
		option.setCoorType("bd09ll");// 百度定位的type都是为bd09ll
		option.setScanSpan(3000);// 3秒钟定位一次。
		option.setIsNeedAddress(true);// 需要地址
		option.setOpenGps(true);// 打开gps
		option.setNeedDeviceDirect(true);// 需要方向。
		client.setLocOption(option);// 设置LocationClientOption
		System.out.println("======");
	}

	private void initData() {
		fragmentManager = getSupportFragmentManager();
		list = new ArrayList<Fragment>();
		list.add(Fragment_ZiXun.getFragment());
		list.add(Fragment_BBS.getFragment());
		list.add(Fragment_Dis.getFragment());
		list.add(Fragment_Mine.getFragment());
		transaction = fragmentManager.beginTransaction();
		transaction.add(R.id.fl_kache, list.get(0)).commit();
	}

	private void initView() {
		radioGroup = (RadioGroup) findViewById(R.id.rg_1);
		radioGroup.setOnCheckedChangeListener(this);
		radioGroup.getChildAt(0).performClick();
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.rb_1:
			switchFragment(0);
			break;
		case R.id.rb_2:
			switchFragment(1);
			break;
		case R.id.rb_3:
			switchFragment(2);
			break;
		case R.id.rb_4:
			switchFragment(3);
			break;
		}
	}

	// fragment的隐藏
	private void switchFragment(int tabindex) {
		if (currentTabIndex != tabindex) {
			transaction = fragmentManager.beginTransaction();
			// 定义当前碎片与即将加载的碎片
			Fragment fromFragment = list.get(currentTabIndex);
			Fragment toFragment = list.get(tabindex);
			if (!toFragment.isAdded()) {
				// 如果该碎片还没有被添加到事务中，则新添加到事务
				transaction.hide(fromFragment).add(R.id.fl_kache, toFragment);
			} else {
				// 如果该碎片已经被添加到事务中，则从事务中取出该碎片进行显示即可。无需销毁再重新创建。
				transaction.hide(fromFragment).show(toFragment);
			}
			// 提交执行过的事务
			// transaction.addToBackStack(null);
			transaction.commit();
			currentTabIndex = tabindex;
		}

	}

	@Override
	public void onReceiveLocation(BDLocation arg0) {
		if (arg0 == null) {
			LatLng latling = new LatLng(23.137169, 113.272805);
			// 将地图更改一下位置。以广州以中心。第一个参数为经纬度封装对象，第二个参数为缩放级别:缩放级别为3-20之间。
			MapStatusUpdate update = MapStatusUpdateFactory.newLatLngZoom(
					latling, 17);
			// 设置地图中心位置。
		} else {
			String city = arg0.getCity();
			System.out.println("定位了city:" + city);
			SharePrefUtil.saveString(this, "city", city);
			
		}

	}
}
