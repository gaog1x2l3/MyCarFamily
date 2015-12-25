package com.example.mycar.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycar.R;

public class Fragment_BBS extends Fragment {
	private static Fragment_BBS fd;
	private TextView textView1,textView2,textView3;
	private View view;
	private Fragment_BBS_JingHua fbj;
	private Fragment_BBS_TieZi fbt;

	public static Fragment_BBS getFragment() {
		if (fd == null) {
			fd = new Fragment_BBS();
		}
		return fd;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_bbs, container, false);
		initview();
		getFragmentManager().beginTransaction().replace(R.id.flt_bbs, fbj)
				.commit();
		return view;
	}

	private void initview() {
		fbj = Fragment_BBS_JingHua.getFragment();
		fbt = Fragment_BBS_TieZi.getFN();
		textView1 = (TextView) view.findViewById(R.id.jinghua);
		textView1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				getFragmentManager().beginTransaction()
						.replace(R.id.flt_bbs, fbj).commit();
			}
		});
		textView2=(TextView) view.findViewById(R.id.tiezi);
		textView2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "我按了", 0).show();
				getFragmentManager().beginTransaction()
				.replace(R.id.flt_bbs, fbt).commit();
			}
		});
		textView3=(TextView) view.findViewById(R.id.retie);

	}
}
