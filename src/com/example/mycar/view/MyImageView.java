package com.example.mycar.view;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.LruCache;
import android.widget.ImageView;

import com.example.mycar.utils.DownUtil;
import com.example.mycar.utils.DownUtil.OnDownComplete;
import com.example.mycar.utils.ImageUtil;

public class MyImageView extends ImageView implements OnDownComplete {
	
	public MyImageView(Context context) {
		super(context);
	}

	public MyImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	private static LruCache<String, Bitmap> lruCache=new LruCache<String, Bitmap>(1024*1024*2){
		protected void entryRemoved(boolean evicted,String key,Bitmap oldValue,Bitmap newValue){
			if(evicted)
				softCache.put(key,new SoftReference<Bitmap>(oldValue));
			
		}
		protected int sizeOf(String key,Bitmap value){
			return value.getHeight()*value.getRowBytes();
			
		}
		
	};
	private static Map<String, SoftReference<Bitmap>> softCache=new HashMap<String, SoftReference<Bitmap>>();
	
	
	
	public void setUrl(String url){
		this.setTag(url);
		Bitmap bitmap = getCache(url);
		if(bitmap!=null){
			this.setImageBitmap(bitmap);
		}else{
			DownUtil.down(DownUtil.TYPE_IMAGE, url, this);
		}
	}

	private Bitmap getCache(String url) {
		Bitmap bitmap = null;
		bitmap = lruCache.get(url);
		if(bitmap == null){
			if(softCache.containsKey(url)){
				SoftReference<Bitmap> softObj = softCache.get(url);
				bitmap = softObj.get();
				if(bitmap != null){
					lruCache.put(url, bitmap);
					softCache.remove(url);
				}
			}
		}
		
		if(bitmap == null){
			bitmap = ImageUtil.getImage(url);
			if(bitmap != null){
				lruCache.put(url, bitmap);
			}
		}
		return bitmap;
	}
	

	@Override
	public void downComplete(String url, Object obj) {
		if(this != null && obj != null && this.getTag() != null && this.getTag().toString().equals(url)){
			this.setImageBitmap((Bitmap)obj);
		}
		setCache(url, (Bitmap)obj);
		
	}

	private void setCache(String key, Bitmap value) {
		lruCache.put(key, value);
		ImageUtil.saveImage(key, value);		
	}
}
