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

/**
 * 情感专区论坛
 * 
 * @author gao
 * 
 */
public class Fragment_JingHua_Gqzq extends Fragment_JingHua_BaseFragment {

	private static Fragment_JingHua_Gqzq fn;

	public static Fragment_JingHua_Gqzq getFN() {
		if (fn == null) {
			fn = new Fragment_JingHua_Gqzq();
		}
		return fn;
	}

	public void loadData() {
		String url = String.format(Constants.URL.BBS_JH_QGZQ, page);
		DownUtil.down(DownUtil.TYPE_JSON, url, this);
	}

}
