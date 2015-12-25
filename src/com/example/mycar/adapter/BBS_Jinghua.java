package com.example.mycar.adapter;

import java.util.Map;

import android.content.Context;
import android.widget.TextView;

import com.example.mycar.R;
import com.example.mycar.model.ZixunEntity;
import com.example.mycar.view.MyImageView;

public class BBS_Jinghua extends MybaseAdapter<ZixunEntity> {

	public BBS_Jinghua(Context context, Map<Integer, Integer> resMap) {
		super(context, resMap);
	}

	@Override
	public void bindData(ViewHolder vh, ZixunEntity data) {
		if (data.getSubType() == 0) {
			MyImageView iv = (MyImageView) vh.getView(R.id.zixun_img);
			iv.setImageResource(R.drawable.friends_message_header);
			iv.setUrl(data.getImgSrc());
			TextView tv = (TextView) vh.getView(R.id.zx_Title);
			tv.setText(data.getTitle());
			TextView tv1 = (TextView) vh.getView(R.id.zx_PublishDateTime);
			tv1.setText(data.getRepliesid()+"回帖");
			TextView tv2 = (TextView) vh.getView(R.id.zx_Author);
			tv2.setText(data.getCategoryName());
		} 
		else if ( data.getSubType() == 3) 
		{
			MyImageView iv1 = (MyImageView) vh.getView(R.id.zixun_img_tt);
			iv1.setImageResource(R.drawable.friends_message_header);
			iv1.setUrl(data.getImgSrc());
			TextView tv4 = (TextView) vh.getView(R.id.zx_Title_tt);
			tv4.setText(data.getTitle());
			TextView tv3 = (TextView) vh.getView(R.id.zx_Author_tt);
			tv3.setText(data.getCategoryName());
			MyImageView tv5 = (MyImageView) vh.getView(R.id.zx_tg_tt);
			tv5.setImageResource(R.drawable.wenzhangguanggaotuiguang);
			tv5.setUrl(data.getSmallImg());
		}
		else if ( data.getSubType() == 1) 
		{
			MyImageView iv11 = (MyImageView) vh.getView(R.id.zixun_img_tt);
			iv11.setImageResource(R.drawable.friends_message_header);
			iv11.setUrl(data.getImgSrc());
			TextView tv41 = (TextView) vh.getView(R.id.zx_Title_tt);
			tv41.setText(data.getTitle());
			TextView tv31 = (TextView) vh.getView(R.id.zx_Author_tt);
			tv31.setText(data.getCategoryName());
			MyImageView tv51 = (MyImageView) vh.getView(R.id.zx_tg_tt);
			tv51.setImageResource(R.drawable.wenzhangguanggaotuiguang);
			tv51.setUrl(data.getSmallImg());
		}
		else if(data.getSubType()==2){
			MyImageView img = (MyImageView) vh.getView(R.id.tuiguang_tt);
			img.setImageResource(R.drawable.bbs_category_defaultbrand);
			img.setUrl(data.getImgSrc());
			MyImageView img_1 = (MyImageView) vh.getView(R.id.tuiguang);
			img_1.setImageResource(R.drawable.wenzhangguanggaotuiguang);
			img_1.setUrl(data.getSmallImg());
		}
	}

}
