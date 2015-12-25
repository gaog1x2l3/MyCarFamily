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

public class Ad3 extends Fragment {
	private static View view;
	private static ImageView img_1;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.ad3, container, false);
		Alpha();
		return view;
	}
	public static void Alpha() {
		img_1=(ImageView) view.findViewById(R.id.text3);
		AnimationSet animationSet = new AnimationSet(true);
		AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
		alphaAnimation.setDuration(800);
		alphaAnimation.setFillAfter(true);
		alphaAnimation.setStartOffset(100);
		animationSet.addAnimation(alphaAnimation);
		img_1.startAnimation(animationSet);
	}
}
