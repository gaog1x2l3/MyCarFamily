package com.example.mycar.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;

import com.example.mycar.R;
/**
 * 广告的第二个界面
 * @author gao
 *
 */
public class Ad2 extends Fragment{
	private static View view;
	private static ImageView img_1;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.ad2, container, false);
		Alpha();
		return view;
	}
	public static void Alpha() {
		img_1=(ImageView) view.findViewById(R.id.text2);
		//这个类为一组特定的动画指定次序---属性动画
		AnimationSet animationSet = new AnimationSet(true);
		//设置透明度渐变动画:从无到有
		AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
		//设置持续时间
		alphaAnimation.setDuration(800);
		//动画执行完后是否停留在执行完的状态 :true表示停留在执行完后的状态。
		alphaAnimation.setFillAfter(true);
		//执行前的等待时间
		alphaAnimation.setStartOffset(100);
		//设置为透明度渐变动画
		animationSet.addAnimation(alphaAnimation);
		//开始动画
		img_1.startAnimation(animationSet);
	}

}
