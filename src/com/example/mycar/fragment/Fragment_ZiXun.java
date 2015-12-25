package com.example.mycar.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mycar.utils.Constants;
import com.example.mycar.view.PagerSlidingTabStrip;
import com.example.mycar.R;

public class Fragment_ZiXun extends Fragment {
	private static Fragment_ZiXun fz;
	private PagerSlidingTabStrip mTab;
	private View view;
	private ViewPager mViewPager;
	private List<Fragment> list;

	public static Fragment_ZiXun getFragment() {
		if (fz == null) {
			fz = new Fragment_ZiXun();
		}
		return fz;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_zixun, container, false);
		mViewPager = (ViewPager) view.findViewById(R.id.mViewPager);
		mTab = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
		initData();
		
		mViewPager.setAdapter(new FragmentAdapter(getFragmentManager(), list));
		mTab.setViewPager(mViewPager);
		return view;
	}
 
	private void initData() {
		list = new ArrayList<Fragment>();
		Fragment_TuiJian ft = Fragment_TuiJian.getFragment();
		Fragment_News fn1 =  Fragment_News.getFN();
		Fragment_Shop fn2 = Fragment_Shop.getFN();
		Fragment_YangChe fn3 =  Fragment_YangChe.getFN();
		Fragment_Ceping fn4 =  Fragment_Ceping.getFN();
		Fragment_ZhengCe fn5 =  Fragment_ZhengCe.getFN();
		Fragment_WuLiu fn6 =  Fragment_WuLiu.getFN();
		list.add(ft);
		list.add(fn1);
		list.add(fn2);
		list.add(fn3);
		list.add(fn4);
		list.add(fn5);
		list.add(fn6);
	}

	class FragmentAdapter extends FragmentPagerAdapter {
		List<Fragment> viewlist;

		public FragmentAdapter(FragmentManager fm,
				List<Fragment> viewlist) {
			super(fm);
			this.viewlist = viewlist;

		}

		@Override
		public Fragment getItem(int position) {
			// TODO Auto-generated method stub
			return viewlist.get(position);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return viewlist == null ? 0 : viewlist.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return Constants.TABS[position];
		}

	}

}
