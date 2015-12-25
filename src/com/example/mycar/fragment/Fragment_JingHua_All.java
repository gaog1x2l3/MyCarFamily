package com.example.mycar.fragment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.mycar.adapter.BBS_Jinghua;
import com.example.mycar.model.ZixunEntity;
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

public class Fragment_JingHua_All extends Fragment implements OnDownComplete,
		OnRefreshListener2<ListView> {

	private View view;
	private PullToRefreshListView showViews;
	private int page = 1;
	private BBS_Jinghua adapter1;
	private List<ZixunEntity> datas;
	private static Fragment_JingHua_All fn;

	public static Fragment_JingHua_All getFN() {
		if (fn == null) {
			fn = new Fragment_JingHua_All();
		}
		return fn;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.zixun_tuijian, container, false);
		initView();
		loadData();
		return view;
	}

	private void loadData() {
		String url = String.format(Constants.URL.BBS_JH_ALL, page);
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

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, R.layout.item_zixun_zero);
		map.put(1, R.layout.item_toutiao);
		map.put(2, R.layout.item_tuiguang);
		map.put(3, R.layout.item_toutiao);
		adapter1 = new BBS_Jinghua(getActivity(), map);
		showViews.setAdapter(adapter1);
	}

	@Override
	public void downComplete(String url, Object obj) {
		if (obj != null) {
			datas = JSONUtil.getCenByJSON(obj + "");
			if (page == 1) {
				adapter1.setDatas(datas);
				System.out.println("downComplete下载完数据得到解析后的实体的数量:" + datas.size());
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
