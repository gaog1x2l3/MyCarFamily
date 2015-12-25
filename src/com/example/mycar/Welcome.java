package com.example.mycar;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.example.mycar.adapter.MyAdapter;
import com.example.mycar.fragment.Ad1;
import com.example.mycar.fragment.Ad2;
import com.example.mycar.fragment.Ad3;
import com.example.mycar.fragment.Ad4;
import com.example.mycar.R;
/**
 * 欢迎界面
 * @author gao
 *
 */
public class Welcome extends FragmentActivity {
	private ViewPager viewPager;
	private TextView tv;
	private List<Fragment> lists = new ArrayList<Fragment>();
	private LinearLayout dot_layout;
	private MyAdapter myAdapter;
	private boolean flag=false;
	private Ad1 ad1;
	private Ad2 ad2;
	private Ad3 ad3;
	private Ad4 ad4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ad_welcome);
		init();
		initListener();
		initData();
	}

	private void init() {
		dot_layout = (LinearLayout) findViewById(R.id.dot_layout);
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		viewPager.setOffscreenPageLimit(0);
		tv = (TextView) findViewById(R.id.text_ad);
	}
	private void initData(){
		ad1 = new Ad1();
		ad2 = new Ad2();
		ad3 = new Ad3();
		ad4 = new Ad4();
		lists.add(ad1);
		lists.add(ad2);
		lists.add(ad3);
		lists.add(ad4);
		initDots();
		myAdapter = new MyAdapter(getSupportFragmentManager(), lists);
		viewPager.setAdapter(myAdapter);
		updateIntroAndDot();
		
	}
	
	
	
	private void initListener(){
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				if (position == 0) {
					Ad1.Alpha();
				}
				if (position == 1) {
					Ad2.Alpha();
				}
				if (position == 2) {
					Ad3.Alpha();
				}
				if (position == 3) {
					tv.setText(null);
					dot_layout.removeAllViews();
					Ad4.Alpha();
					flag=true;
				}
				if(position != 3){
					tv.setText("直接跳过");
					tv.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
					if(flag){
					initDots();
					}
					flag=false;
				}
				updateIntroAndDot();
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}

	//初始化小点点
	private void initDots(){
		for (int i = 0; i < lists.size(); i++) {
			View view = new View(this);
			LayoutParams params = new LayoutParams(20,20);
			if(i!=0){
				params.leftMargin = 15;
			}
			view.setLayoutParams(params);
			view.setBackgroundResource(R.drawable.selector_dot);
			dot_layout.addView(view);
		}
	}
	private void updateIntroAndDot(){
		int currentPage = viewPager.getCurrentItem()%lists.size();
		
		for (int i = 0; i < dot_layout.getChildCount(); i++) {
			dot_layout.getChildAt(i).setEnabled(i==currentPage);
		}
	}
	//跳转到主页面。
	public void click(View v){
		Intent intent=new Intent(this,MainActivity.class);
		startActivity(intent);
		finish();
	}
	
	


}
