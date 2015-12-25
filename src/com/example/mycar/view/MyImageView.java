package com.example.mycar.view;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;

import com.example.mycar.utils.DownUtil;
import com.example.mycar.utils.DownUtil.OnDownComplete;
import com.example.mycar.utils.ImageUtil;

public class MyImageView extends ImageView implements OnDownComplete {
	private static final String TAG = "MyImageView";
	public MyImageView(Context context) {
		super(context);
		Log.d(TAG, "MyImageView-1");
	}

	public MyImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		Log.d(TAG, "MyImageView-2");
	}
	//创建LruCache缓冲区
	private static LruCache<String, Bitmap> lruCache=new LruCache<String, Bitmap>(1024*1024*2){
		protected void entryRemoved(boolean evicted,String key,Bitmap oldValue,Bitmap newValue){
			if(evicted)
				softCache.put(key,new SoftReference<Bitmap>(oldValue));
			
		}
		protected int sizeOf(String key,Bitmap value){
			return value.getHeight()*value.getRowBytes();
			
		}
		
	};
	//软引用
	private static Map<String, SoftReference<Bitmap>> softCache=new HashMap<String, SoftReference<Bitmap>>();
	
	
	//在图片上设置这个图片的网址。
	public void setUrl(String url){
		Log.d(TAG, "setUrl"+url);
		this.setTag(url);
		Bitmap bitmap = getCache(url);
		if(bitmap!=null){
			this.setImageBitmap(bitmap);
		}else{
			//下载图片
			DownUtil.down(DownUtil.TYPE_IMAGE, url, this);
		}
	}

	private Bitmap getCache(String url) {
		Log.d(TAG, "getCache"+url);
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
	
	//下载完成后。
	@Override
	public void downComplete(String url, Object obj) {
		Log.d(TAG, "downComplete"+url+":"+obj);
		System.out.println("----downComplete"+this.getTag().toString());
		if(this != null && obj != null && this.getTag() != null && this.getTag().toString().equals(url)){
			this.setImageBitmap((Bitmap)obj);
		}
		setCache(url, (Bitmap)obj);
		
	}
	//将图片数据放到LruCache,并且存储到扩充卡上。
	private void setCache(String key, Bitmap value) {
		Log.d(TAG, "setCache"+key+":"+value);
		lruCache.put(key, value);
		ImageUtil.saveImage(key, value);		
	}
}
