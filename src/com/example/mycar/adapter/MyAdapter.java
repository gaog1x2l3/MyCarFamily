package com.example.mycar.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {
	List<Fragment> viewlist;

	public MyAdapter(FragmentManager fm, List<Fragment> viewlist) {
		super(fm);
		this.viewlist = viewlist;
	}

	@Override
	public Fragment getItem(int arg0) {
		return viewlist.get(arg0);
	}

	@Override
	public int getCount() {
		return viewlist == null ? 0 : viewlist.size();
	}

	

}
