package com.example.mycar.model;

public class HeadEntity {

//	   "AdId": "0",
//       "ImgSrc": "http://imgf.360che.com/HW_Image/2015/1123/1123182644.jpg",
//       "Title": "\u6d3b\u6d3b\u997f\u6b7b\u91cd\u5361 \u4e1c\u65b9\u7ea2\u724c\u516c\u8def\u8fd0\u8f93\u62d6\u62c9\u673a",
//       "Url": "48478",
//       "Type": "0"
	private String AdId;
	private String ImgSrc;
	private String Title;
	private String Url;
	private String Type;
	public String getAdId() {
		return AdId;
	}
	public void setAdId(String adId) {
		AdId = adId;
	}
	public String getImgSrc() {
		return ImgSrc;
	}
	public void setImgSrc(String imgSrc) {
		ImgSrc = imgSrc;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	@Override
	public String toString() {
		return "HeadEntity [ImgSrc=" + ImgSrc + ", Title=" + Title + "]";
	}
	public HeadEntity(String adId, String imgSrc, String title, String url,
			String type) {
		super();
		AdId = adId;
		ImgSrc = imgSrc;
		Title = title;
		Url = url;
		Type = type;
	}
	
	

}
