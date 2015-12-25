package com.example.mycar.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * 自定义Adapter封装
 * @author Ken
 * @param <T>
 */
public abstract class MybaseAdapterOne<T> extends BaseAdapter {
	private Context context;
	private List<T> datas;
	private int resId;
	
	public MybaseAdapterOne(Context context, int resId){
		this.context = context;
		this.resId = resId;
		datas = new ArrayList<T>();
	}
	
	public void setDatas(List<T> datas){
		this.datas = datas;
		notifyDataSetChanged();
	}
	
	public void addDatas(List<T> datas){
		this.datas.addAll(datas);
		notifyDataSetChanged();
	}
	
	@Override
	public int getCount() {
		return datas.size();
	}

	@Override
	public Object getItem(int position) {
		return datas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vh = null;
		if(convertView != null){
			vh = (ViewHolder)convertView.getTag();
		} else {
			convertView = View.inflate(context, resId, null);
			vh = new ViewHolder(convertView);
			convertView.setTag(vh);
		}
		
		//设置数据到布局控件中
		bindData(vh, datas.get(position));
		return convertView;
	}
	
	public abstract void bindData(ViewHolder vh, T data);
	
	class ViewHolder{
		private Map<Integer, View> map = new HashMap<Integer, View>();
		private View layoutView;
		ViewHolder(View layoutView){
			this.layoutView = layoutView;
		}
		
		public View getView(int id){
			View sView = null;
			if(map.containsKey(id)){
				sView = map.get(id);
			} else {
				sView = layoutView.findViewById(id);
				map.put(id, sView);
			}
			return sView;
		}
	}
}
