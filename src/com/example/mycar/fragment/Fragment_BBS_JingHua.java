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

public class Fragment_BBS_JingHua extends Fragment {
	private static Fragment_BBS_JingHua fbj;
	private PagerSlidingTabStrip mTab;
	private View view;
	private ViewPager mViewPager;
	private List<Fragment> list;

	public static Fragment_BBS_JingHua getFragment() {
		if (fbj == null) {
			fbj = new Fragment_BBS_JingHua();
		}
		return fbj;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_bbs_jinghua, container, false);
		mViewPager = (ViewPager) view.findViewById(R.id.mViewPager_bbs_jinghua);
		mTab = (PagerSlidingTabStrip) view.findViewById(R.id.tabs_bbs_jinghua);
		initData();
		
		mViewPager.setAdapter(new FragmentAdapter(getFragmentManager(), list));
		mTab.setViewPager(mViewPager);
		return view;
	}
 
	private void initData() {
		list = new ArrayList<Fragment>();
		Fragment_JingHua_All ft1 = Fragment_JingHua_All.getFN();
		Fragment_JingHua_Xczl ft2=Fragment_JingHua_Xczl.getFN();
		Fragment_JingHua_Ycbg ft3=Fragment_JingHua_Ycbg.getFN();
		Fragment_JingHua_Kymc ft4=Fragment_JingHua_Kymc.getFN();
		Fragment_JingHua_Nrgz ft5=Fragment_JingHua_Nrgz.getFN();
		Fragment_JingHua_Gqzq ft6=Fragment_JingHua_Gqzq.getFN();
		Fragment_JingHua_Kssj ft7=Fragment_JingHua_Kssj.getFN();
		Fragment_JingHua_Hydt ft8=Fragment_JingHua_Hydt.getFN();
		Fragment_JingHua_Ggtc ft9=Fragment_JingHua_Ggtc.getFN();
		Fragment_JingHua_Qgtc ft10=Fragment_JingHua_Qgtc.getFN();
		fragment_JingHua_Kcwh ft11=fragment_JingHua_Kcwh.getFN();
		list.add(ft1);
		list.add(ft2);
		list.add(ft3);
		list.add(ft4);
		list.add(ft5);
		list.add(ft6);
		list.add(ft7);
		list.add(ft8);
		list.add(ft9);
		list.add(ft10);
		list.add(ft11);
		
		
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
			return Constants.TABS_JINGHUA[position];
		}

	}
}
