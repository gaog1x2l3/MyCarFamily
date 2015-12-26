package com.example.mycar.model;

/**
 * 帖子实体类
 * 
 * @author gao
 * 
 */
public class TieziEntity {
	// "title": "有人知道我的变速和后桥速比吗",
	// "id": "958744",
	// "isSticky": false,
	// "poster": "浙CUP668",
	// "posterID": "40592",
	// "posterTime": "2015-11-26 17:04:28",
	// "NoReply": "1",
	// "NoVisit": "1",
	// "postAddress": "958744",
	// "attachment": "2",
	// "digest": "0",
	// "isAd": false
	private String title;
	private String id;
	private boolean isSticky;
	private String poster;
	private String posterID;
	private String posterTime;
	private String NoReply;
	private String NoVisit;
	private String postAddress;
	private String attachment;
	private String digest;
	private boolean isAd;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isSticky() {
		return isSticky;
	}

	public void setSticky(boolean isSticky) {
		this.isSticky = isSticky;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getPosterID() {
		return posterID;
	}

	public void setPosterID(String posterID) {
		this.posterID = posterID;
	}

	public String getPosterTime() {
		return posterTime;
	}

	public void setPosterTime(String posterTime) {
		this.posterTime = posterTime;
	}

	public String getNoReply() {
		return NoReply;
	}

	public void setNoReply(String noReply) {
		NoReply = noReply;
	}

	public String getNoVisit() {
		return NoVisit;
	}

	public void setNoVisit(String noVisit) {
		NoVisit = noVisit;
	}

	public String getPostAddress() {
		return postAddress;
	}

	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public boolean isAd() {
		return isAd;
	}

	public void setAd(boolean isAd) {
		this.isAd = isAd;
	}
}
