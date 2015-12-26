package com.example.mycar.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.example.mycar.R;
import com.example.mycar.utils.SharePrefUtil;

public class Fragment_Mine extends Fragment {
	private View view;
	private static Fragment_Mine fm;

	public static Fragment_Mine getFragment() {
		if (fm == null) {
			fm = new Fragment_Mine();
		}
		return fm;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_mine, container, false);
		TextView tv_city = (TextView) view.findViewById(R.id.tv_map);
		String city = SharePrefUtil.getString(getActivity(), "city", "广州");
		tv_city.setText(city);
		return view;
	}

}
