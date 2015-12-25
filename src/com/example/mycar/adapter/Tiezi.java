package com.example.mycar.adapter;

import android.content.Context;
import android.widget.TextView;

import com.example.mycar.model.TieziEntity;
import com.example.mycar.R;

public class Tiezi extends MybaseAdapterOne<TieziEntity>{

	public Tiezi(Context context, int resId) {
		super(context, resId);
	}

	@Override
	public void bindData(ViewHolder vh,TieziEntity data) {
		TextView t1=(TextView) vh.getView(R.id.tiezi_title);
		t1.setText(data.getTitle());
		TextView t2=(TextView) vh.getView(R.id.text_sj);
		t2.setText(data.getPosterTime());
		TextView t3=(TextView) vh.getView(R.id.zuozhe);
		t3.setText(data.getPoster());
		TextView t4=(TextView) vh.getView(R.id.text_ht);
		t4.setText(data.getNoReply()+"回帖");
	}

}
