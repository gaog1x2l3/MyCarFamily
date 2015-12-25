package com.example.mycar.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mycar.R;

public class Fragment_Dis extends Fragment {
	private static Fragment_Dis fd;
	private View view;

	public static Fragment_Dis getFragment() {
		if (fd == null) {
			fd = new Fragment_Dis();
		}
		return fd;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_dis, container, false);
		return view;
	}
}
