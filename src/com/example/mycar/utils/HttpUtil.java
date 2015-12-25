package com.example.mycar.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class HttpUtil {
	private static byte[] getByteByURL(String path) {
		URL url;
		try {
			url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(5000);
			conn.setRequestMethod("GET");
			InputStream is = conn.getInputStream();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			int len = 0;
			byte[] b = new byte[1024 * 2];
			while ((len = is.read(b)) != -1) {
				bos.write(b, 0, len);
				bos.flush();
			}
			is.close();
			bos.close();
			return bos.toByteArray();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public static String getJSON(String path) {
		byte[] b = getByteByURL(path);
		if (b != null) {
			try {
				return new String(b, "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static Bitmap getBitmap(String path) {
		byte[] b = getByteByURL(path);
		Bitmap bitmap = null;
		if (b != null) {
			bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
		}

		return bitmap;

	}
}
