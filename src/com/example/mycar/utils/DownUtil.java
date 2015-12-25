package com.example.mycar.utils;

import android.os.Handler;

public class DownUtil {
	public static final int TYPE_JSON = 0;
	public static final int TYPE_IMAGE = 1;
	private static Handler handler = new Handler();

	public static void down(final int type, final String url,
			final OnDownComplete onDownComplete) {
		new Thread(new Runnable() {
			Object obj = null;

			@Override
			public void run() {
				switch (type) {
				case DownUtil.TYPE_JSON:
					obj = HttpUtil.getJSON(url);
					break;

				case DownUtil.TYPE_IMAGE:
					obj = HttpUtil.getBitmap(url);
					break;
				}
				final Object result = obj;
				handler.post(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						onDownComplete.downComplete(url, result);
					}
				});
			}
		}).start();
	}

	public interface OnDownComplete {
		void downComplete(String url, Object obj);
	}
}
