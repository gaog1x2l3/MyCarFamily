package com.example.mycar.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mycar.DetailActivity;
import com.example.mycar.adapter.Zixun_ad1;
import com.example.mycar.model.ZixunEntity;
import com.example.mycar.utils.Constants;
import com.example.mycar.utils.DownUtil;
import com.example.mycar.utils.DownUtil.OnDownComplete;
import com.example.mycar.utils.JSONUtil;
import com.example.mycar.view.HeadNav;
import com.example.mycar.view.HeadNav.OnNoHeadListener;
import com.example.mycar.R;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
/**
 * 咨询界面中的推荐部分
 * @author gao
 *
 */
public class Fragment_TuiJian extends Fragment implements OnDownComplete, OnNoHeadListener, OnRefreshListener2<ListView>, OnItemClickListener {
	private View view;
	private Zixun_ad1 adapter1;
	private int page=1;
	private PullToRefreshListView showViews;
	private List<ZixunEntity> datas=new ArrayList<ZixunEntity>();
	private	List<ZixunEntity> allDatas = new ArrayList<ZixunEntity>() ;
	private HeadNav headNav;
	private static Fragment_TuiJian ftj;
	
	public static Fragment_TuiJian getFragment(){
		if(ftj==null){
			ftj=new Fragment_TuiJian();
		}
		return ftj;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.zixun_tuijian, container,false);
		initView();
		loadData();
		headNav.loadDatas();
		return view;
	}
	
	private void loadData() {
		String url=String.format(Constants.URL.URL_TUIJIAN, page);
		System.out.println("tuijian:loadData:"+url);
		DownUtil.down(DownUtil.TYPE_JSON, url, this);
	}
	
	private void initView() {
		showViews=(PullToRefreshListView) view.findViewById(R.id.zx_tuijian);
		showViews.setMode(Mode.BOTH);
		showViews.setOnRefreshListener(this);
		showViews.setOnItemClickListener(this);
		
		ILoadingLayout ill=showViews.getLoadingLayoutProxy(true,false);
		ill.setPullLabel("下拉刷新...");
		ill.setRefreshingLabel("正在载入...");
		ill.setReleaseLabel("放开以刷新...");
		
		headNav=new HeadNav(getActivity(), this);
		showViews.getRefreshableView().addHeaderView(headNav);
		
		Map<Integer,Integer> map=new HashMap<Integer, Integer>();
		map.put(0, R.layout.item_zixun_zero);
		map.put(1, R.layout.item_toutiao);
		map.put(2, R.layout.item_tuiguang);
		map.put(3, R.layout.item_toutiao);
		adapter1=new Zixun_ad1(getActivity(), map);
		showViews.setAdapter(adapter1);
	}
	//处理下载的数据。
	@Override
	public void downComplete(String url, Object obj) {
		if(obj!=null){
			datas=JSONUtil.getCenByJSON(obj+"");
			if(page==1){
				adapter1.setDatas(datas);
			}else{
				adapter1.addDatas(datas);
			}
			//addAll 解决详情页下标越界
			allDatas.addAll(datas);
		}
	}

	@Override
	public void noHeadListener(HeadNav hn) {
		if (showViews != null) {
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
						page=1;
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
		new Thread(){
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

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Toast.makeText(getActivity(), arg2+"个", 0).show();
		// TODO Auto-generated method stub
		String type=allDatas.get(arg2-2).getType();
		String  id=allDatas.get(arg2-2).getUrl();
		
		Intent intent=new Intent(getActivity(),DetailActivity.class);
		intent.putExtra("id", id);
		intent.putExtra("type", type);
		getActivity().startActivity(intent);	
		
	}
	
}
