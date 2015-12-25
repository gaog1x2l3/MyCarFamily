package com.example.mycar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;

import com.example.mycar.MainActivity;
import com.example.mycar.R;
/**
 * 广告的第四个界面
 * @author gao
 *
 */
public class Ad4 extends Fragment{
	private static View view;
	private static ImageView img_1,img_2;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.ad4, container, false);
		Alpha();
		return view;
	}
	public static void Alpha() {
		img_2=(ImageView) view.findViewById(R.id.about);
		img_1=(ImageView) view.findViewById(R.id.text4);
		AnimationSet animationSet = new AnimationSet(true);
		AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
		alphaAnimation.setDuration(800);
		alphaAnimation.setFillAfter(true);
		alphaAnimation.setStartOffset(100);
		animationSet.addAnimation(alphaAnimation);
		img_1.startAnimation(animationSet);
		img_2.startAnimation(animationSet);
	}
	public void click(View v){
		Intent intent=new Intent(getActivity(),MainActivity.class);
		startActivity(intent);
		getActivity().finish();
	}
}
