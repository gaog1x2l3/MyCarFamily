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

import com.example.mycar.fragment.Fragment_BBS;
import com.example.mycar.fragment.Fragment_Dis;
import com.example.mycar.fragment.Fragment_Mine;
import com.example.mycar.fragment.Fragment_ZiXun;

public class MainActivity extends FragmentActivity implements
		OnCheckedChangeListener {
	private RadioGroup radioGroup;
	private List<Fragment> list;
	private FragmentManager fragmentManager;
	private FragmentTransaction transaction;
	private int currentTabIndex = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initData();
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
//fragment的隐藏
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
}
