package com.example.mycar.broadreceiver;

import com.example.mycar.utils.CommonUtil;
import com.example.mycar.view.CustomToast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ConnectivityReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		int type = CommonUtil.isNetworkAvailable(context);
		String str = "";
		switch (type) {
		case 0:
			str = "没有网络";
			break;
		case 1:
			str = "WIFI";
			break;
		case 2:
			str = "CMWAP";
			break;
		case 3:
			str = "CMNET";
			break;

		default:
			break;
		}
		CustomToast toast = new CustomToast(context, str, 500);
		toast.show();

	}
}
