package com.example.mycar.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

import com.example.mycar.model.HeadEntity;
import com.example.mycar.utils.Constants;
import com.example.mycar.utils.DownUtil;
import com.example.mycar.utils.DownUtil.OnDownComplete;
import com.example.mycar.utils.JSONUtil;
import com.example.mycar.R;

public class HeadNav extends FrameLayout implements OnPageChangeListener, OnDownComplete {
	private ViewPager viewPager;
	private ViewPagerAdapter vpadapter;
	private List<ImageView> vDatas;
	private LinearLayout layout;
	private LinearLayout.LayoutParams layoutParams;
	private List<HeadEntity> datas;
	private OnNoHeadListener onNoHeadListener;

	public HeadNav(Context context,OnNoHeadListener onNoHeadListener) {
		super(context);
		this.onNoHeadListener=onNoHeadListener;
		init();
	}
	
	public void loadDatas(){
		String url=Constants.URL.URL_TJGG;
		DownUtil.down(DownUtil.TYPE_JSON, url, this);
	}
	
	private void init() {
		LayoutInflater.from(getContext()).inflate(R.layout.headnav, this,true);
		viewPager = (ViewPager) findViewById(R.id.zx_head);
		viewPager.setOnPageChangeListener(this);
		
		layout=(LinearLayout) findViewById(R.id.ll_nav);
		layoutParams=(LinearLayout.LayoutParams) layout.getLayoutParams();
		
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		updateIntroAndDot();
	}
	
	private void initImgNav(){
		for (int i = 0; i < datas.size(); i++) {
			View view = new View(getContext());
			LayoutParams params = new LayoutParams(20,20);
			if(i!=0){
				params.leftMargin = 15;
			}
			view.setLayoutParams(params);
			view.setBackgroundResource(R.drawable.selector_dot);
			layout.addView(view);
		}
	}
	
	private void updateIntroAndDot(){
		int currentPage = viewPager.getCurrentItem()%datas.size();
		
		for (int i = 0; i < layout.getChildCount(); i++) {
			layout.getChildAt(i).setEnabled(i==currentPage);
		}
	}
	
	private void initView() {
		vpadapter = new ViewPagerAdapter(vDatas);
		viewPager.setAdapter(vpadapter);
		
	}
	
	private List<ImageView> getViewPagerDatas(List<HeadEntity> headList){
		List<ImageView> vdatas = null;
		if(headList != null && headList.size() > 0){
			vdatas = new ArrayList<ImageView>();
			for(HeadEntity hne : headList){
				MyImageView miv = new MyImageView(getContext());
				miv.setUrl(hne.getImgSrc());
				miv.setScaleType(ScaleType.CENTER_CROP);
				vdatas.add(miv);
			}
		}
		return vdatas;
	}
	
	class ViewPagerAdapter extends PagerAdapter{

		private List<ImageView> datas;

		public ViewPagerAdapter(List<ImageView> datas){
			this.datas = datas;
		}
		
		@Override
		public int getCount() {
			return datas.size();
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(datas.get(position));
//			container.removeViewAt(position);
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(datas.get(position));
			return datas.get(position);
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}
		
	}
	
	
	

	@Override
	public void downComplete(String url, Object obj) {
		if(obj!=null){
			datas=JSONUtil.getHeadNavByJSON(obj+"");
			if(datas != null && datas.size() > 0){
				vDatas = getViewPagerDatas(datas);
				initView();
				initImgNav();
				updateIntroAndDot();
			} else {
				//调用回调接口
				onNoHeadListener.noHeadListener(this);
			}
		}
	}
	public interface OnNoHeadListener{
		void noHeadListener(HeadNav hn);
	}

}
