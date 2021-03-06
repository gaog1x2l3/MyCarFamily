package com.example.mycar.adapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * 多Item的自定义Adapter封装 -- 强制条件 T中一定要有一个名字叫做type的属性
 * 
 * @author gao
 * 
 * @param <T>
 */
public abstract class MybaseAdapter<T> extends BaseAdapter {
	private Context context;
	private List<T> datas;
	// private int[] resId;
	private Map<Integer, Integer> resMap;// type _ R.layout.id 存储类型和布局的键值对，可以通过类型方便找到布局，

	public MybaseAdapter(Context context, Map<Integer, Integer> resMap) {
		this.context = context;
		this.resMap = resMap;
		datas = new ArrayList<T>();
	}

	@Override
	public int getItemViewType(int position) {
		//通过反射得到SubType数据。
		T t = datas.get(position);
		Class c = t.getClass();
		int type = 0;
		try {
			Field field = c.getDeclaredField("SubType");
			field.setAccessible(true);
			type = Integer.parseInt("" + field.get(t));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return type;
	}

	@Override
	public int getViewTypeCount() {
		return resMap.size();
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
		notifyDataSetChanged();
	}

	public void addDatas(List<T> datas) {
		this.datas.addAll(datas);
		notifyDataSetChanged();
	}

	public void clearDatas() {
		this.datas.clear();
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
		if (convertView != null) {
			vh = (ViewHolder) convertView.getTag();
		} else {
			convertView = View.inflate(context,
					resMap.get(getItemViewType(position)), null);
			vh = new ViewHolder(convertView);
			convertView.setTag(vh);
		}

		// 设置数据到布局控件中
		bindData(vh, datas.get(position));
		return convertView;
	}
	//具体由子类实现
	public abstract void bindData(ViewHolder vh, T data);

	class ViewHolder {
		private Map<Integer, View> map = new HashMap<Integer, View>();
		private View layoutView;

		ViewHolder(View layoutView) {
			this.layoutView = layoutView;
		}
		//通过id找到布局中的控件。
		public View getView(int id) {
			View sView = null;
			if (map.containsKey(id)) {
				sView = map.get(id);
			} else {
				sView = layoutView.findViewById(id);
				map.put(id, sView);
			}
			return sView;
		}
	}
}