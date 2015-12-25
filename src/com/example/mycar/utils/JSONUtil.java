package com.example.mycar.utils;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.mycar.model.HeadEntity;
import com.example.mycar.model.TieziEntity;
import com.example.mycar.model.ZixunEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JSONUtil {
	// 解析json数据得到咨询实体对象集合。
	public static List<ZixunEntity> getCenByJSON(String json) {
		List<ZixunEntity> list = null;
		if (json != null) {
			try {
				JSONObject object = new JSONObject(json);
				JSONArray ja = object.getJSONArray("data");
				TypeToken<List<ZixunEntity>> tt = new TypeToken<List<ZixunEntity>>() {
				};
				list = new Gson().fromJson(ja.toString(), tt.getType());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		System.out.println("解析到的集合数据有---ZixunEntity:"+list.size());
		return list;

	}
	//解析json数据得到HeadEntity实体集合。
	public static List<HeadEntity> getHeadNavByJSON(String json) {
		List<HeadEntity> list = null;
		if (json != null) {
			try {
				JSONObject object = new JSONObject(json);
				JSONArray ja = object.getJSONArray("data");
				TypeToken<List<HeadEntity>> tt = new TypeToken<List<HeadEntity>>() {
				};
				list = new Gson().fromJson(ja.toString(), tt.getType());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		System.out.println("解析到的集合数据有--HeadEnity:"+list.size());
		return list;
	}

	public static List<TieziEntity> getTieZiByJSON(String json) {
		List<TieziEntity> list = null;
		if (json != null) {
			try {
				JSONObject object = new JSONObject(json);
				JSONArray ja = object.getJSONArray("articleList");
				TypeToken<List<TieziEntity>> tt = new TypeToken<List<TieziEntity>>() {
				};
				list = new Gson().fromJson(ja.toString(), tt.getType());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		System.out.println("解析到的集合数据有--TieziEnity:"+list.size());
		return list;
	}

}
