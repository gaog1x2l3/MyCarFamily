package com.example.mycar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.mycar.utils.Constants;
import com.example.mycar.R;

public class DetailActivity extends Activity {
	private WebView webView;
	private int id;
	private String url;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_layout);
		webView = (WebView) findViewById(R.id.web);
		init();
		Intent intent = getIntent();
		String type=intent.getStringExtra("type");

		if("0".equals(type)){
			id = Integer.parseInt(intent.getStringExtra("id"));
			url = String.format(Constants.URL.XQ_ZIXUN, id);
		}else if("2".equals(type)){
			url=intent.getStringExtra("id");
		}
		webView.loadUrl(url);
		
	}

	
	
	private void init() {
		WebSettings webViewSet = webView.getSettings();
		// 启动缓存
		webViewSet.setAppCacheEnabled(true);
		// 设置缓存模式
		webViewSet.setCacheMode(webViewSet.LOAD_DEFAULT);
		// 便页面支持缩放
		webViewSet.setJavaScriptEnabled(true);
		webViewSet.setBuiltInZoomControls(true);
		webViewSet.setSupportZoom(true);
		webViewSet.setDomStorageEnabled(true);
		// 打开页面时， 自适应屏幕：
		webViewSet.setUseWideViewPort(true);
		webViewSet.setLoadWithOverviewMode(true);
		//用本文web打开 不跳转
		webView.setWebViewClient(new WebViewClient() {
		    @Override
		    public boolean shouldOverrideUrlLoading(WebView view, String url) {
		        view.loadUrl(url);
		        return true;
		    }
		});
	

	}
}
