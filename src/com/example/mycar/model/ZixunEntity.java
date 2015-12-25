package com.example.mycar.model;
/**
 * 咨询实体类
 * @author gao
 *
 */
public class ZixunEntity {
//	"AdId":"0",
//    "Url":"47989",
//    "Title":"比银行利率都低 厂家金融贷款真那么好?",
//    "Author":"钟丹军",
//    "ImgSrc":"http://imgf.360che.com/HW_Image/2015/1124/1124114703.png",
//    "PublishDateTime":"0",
//    "SmallImg":"http://imgf.360che.com/HW_Image/2015/0910/0910163315.png",
//    "Type":"0",
//    "SubType":"3"
//
//
//    "AdId":"0",
//    "Url":"48703",
//    "Title":"全国淘汰近百万辆黄标车 其中河北3.3万",
//    "Author":"张清学",
//    "ImgSrc":"http://imgn.360che.com/imga/0/245/245564.jpg!150",
//    "PublishDateTime":"2015-11-24",
//    "SmallImg":"",
//    "Type":"0",
//    "SubType":"0"
	private String CategoryId;
	private String CategoryName;
	private String Repliesid;
	
	
	
	public String getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(String categoryId) {
		CategoryId = categoryId;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public String getRepliesid() {
		return Repliesid;
	}
	public void setRepliesid(String repliesid) {
		Repliesid = repliesid;
	}
	@Override
	public String toString() {
		return "ZixunEntity [Title=" + Title + ", Author=" + Author
				+ ", ImgSrc=" + ImgSrc + ", PublishDateTime=" + PublishDateTime
				+ "]";
	}
	private String AdId;
	private String Url;
	private String Title;
	private String Author;
	private String ImgSrc;
	private String PublishDateTime;
	private String SmallImg;
	private String Type;
	private int SubType;//布局类型
	public String getAdId() {
		return AdId;
	}
	public void setAdId(String adId) {
		AdId = adId;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getImgSrc() {
		return ImgSrc;
	}
	public void setImgSrc(String imgSrc) {
		ImgSrc = imgSrc;
	}
	public String getPublishDateTime() {
		return PublishDateTime;
	}
	public void setPublishDateTime(String publishDateTime) {
		PublishDateTime = publishDateTime;
	}
	public String getSmallImg() {
		return SmallImg;
	}
	public void setSmallImg(String smallImg) {
		SmallImg = smallImg;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getSubType() {
		return SubType;
	}
	public void setSubType(int subType) {
		SubType = subType;
	}
	
	

}
