package com.example.mycar.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mycar.R;

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
		return view;
	}
}
