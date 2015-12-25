package com.example.mycar.fragment;

import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.mycar.adapter.Tiezi;
import com.example.mycar.model.TieziEntity;
import com.example.mycar.utils.Constants;
import com.example.mycar.utils.DownUtil;
import com.example.mycar.utils.DownUtil.OnDownComplete;
import com.example.mycar.utils.JSONUtil;
import com.example.mycar.R;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class Fragment_BBS_TieZi extends Fragment implements OnDownComplete,  OnRefreshListener2<ListView> {
	private View view;
	private int page = 1;
	private PullToRefreshListView showViews;
	private Tiezi adapter1;
	private List<TieziEntity> datas;
	private static Fragment_BBS_TieZi fn;
	
	public static Fragment_BBS_TieZi getFN(){
		if(fn==null){
			fn=new Fragment_BBS_TieZi();
		}
		return fn;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.zixun_tuijian, container, false);
		initView();
		loadData();
		return view;
	}

	private void loadData() {
		String url = String.format(Constants.URL.TZ_NEW, page);
		DownUtil.down(DownUtil.TYPE_JSON, url, this);
	}

	private void initView() {
		showViews = (PullToRefreshListView) view.findViewById(R.id.zx_tuijian);
		showViews.setMode(Mode.BOTH);
		showViews.setOnRefreshListener(this);

		ILoadingLayout ill = showViews.getLoadingLayoutProxy(true, false);
		ill.setPullLabel("下拉刷新...");
		ill.setRefreshingLabel("正在载入...");
		ill.setReleaseLabel("放开以刷新...");
		// 布局
		adapter1 = new Tiezi(getActivity(), R.layout.item_tiezi);
		showViews.setAdapter(adapter1);

	}

	@Override
	public void downComplete(String url, Object obj) {
		if (obj != null) {
			datas = JSONUtil.getTieZiByJSON(obj + "");
			if (page == 1) {
				adapter1.setDatas(datas);
			} else {
				adapter1.addDatas(datas);
			}
			// addAll 解决详情页下标越界
		}
	}

	Handler handler = new Handler();

	@Override
	public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				handler.post(new Runnable() {

					@Override
					public void run() {
						page = 1;
						loadData();
						showViews.onRefreshComplete();
					}
				});
			}
		}).start();

	}

	@Override
	public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
		// TODO Auto-generated method stub
		new Thread() {
			public void run() {
				handler.post(new Runnable() {
					@Override
					public void run() {
						page++;
						loadData();
						showViews.onRefreshComplete();
					}
				});
			};
		}.start();
	}

}
