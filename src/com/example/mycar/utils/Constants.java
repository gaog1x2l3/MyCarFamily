package com.example.mycar.utils;
/**
 * 常量类
 * @author gao
 *
 */
public class Constants {
	public static final String[] TABS = { "推荐", "新闻", "导购", "养车", "评测", "政策",
			"物流" };
	public static final String[] TABS_JINGHUA = { "全部", "行车在路", "用车报告", "卡友买车",
			"牛人改装", "情感专区", "卡嫂世界", "行业动态", "干哥吐槽", "奇哥谈车", "卡车文化" };

	public interface URL{
		String URL_TJGG ="http://api.360che.com/ArticleRecommend/app/ArticleFocusMapList.aspx?key=e8923bd3bbb0baa7529a72efdd753131&version=5.2.0&apptype=android";
		
		String URL_TUIJIAN = "http://api.360che.com/ArticleRecommend/app/ArticleRecommendList.aspx?type=1&page=%d&key=59c7e8a0c2d0aac7638df342c6104a6f&version=5.2.0&apptype=android";
		
		String URL_NEWS="http://api.360che.com/Article/app/ArticleConsultList.aspx?id=1&page=%d&key=59c7e8a0c2d0aac7638df342c6104a6f&version=5.2.0&apptype=android";
		
		String URL_SHOP="http://api.360che.com/Article/app/ArticleConsultList.aspx?id=5&page=%d&key=59c7e8a0c2d0aac7638df342c6104a6f&version=5.2.0&apptype=android";
		
		String URL_YANG="http://api.360che.com/Article/app/ArticleConsultList.aspx?id=16&page=%d&key=59c7e8a0c2d0aac7638df342c6104a6f&version=5.2.0&apptype=android";

		String URL_CE="http://api.360che.com/Article/app/ArticleConsultList.aspx?id=22&page=%d&key=59c7e8a0c2d0aac7638df342c6104a6f&version=5.2.0&apptype=android";
		
		String URL_ZCE="http://api.360che.com/Article/app/ArticleConsultList.aspx?id=3&page=%d&key=59c7e8a0c2d0aac7638df342c6104a6f&version=5.2.0&apptype=android";
		
		String URL_WULIU="http://api.360che.com/Article/app/ArticleConsultList.aspx?id=29&page=%d&key=59c7e8a0c2d0aac7638df342c6104a6f&version=5.2.0&apptype=android";
	
	//论坛
		String BBS_JH_ALL="http://api.360che.com/BBSRecommend/app/BBSRecommendInfoList.aspx?id=0&page=%d&key=e8923bd3bbb0baa7529a72efdd753131&version=5.2.0&apptype=android";
		String BBS_JH_XCZL="http://api.360che.com/BBSRecommend/app/BBSRecommendInfoList.aspx?id=1&page=%d&key=e8923bd3bbb0baa7529a72efdd753131&version=5.2.0&apptype=android";
		String BBS_JH_YCBG="http://api.360che.com/BBSRecommend/app/BBSRecommendInfoList.aspx?id=2&page=%d&key=e8923bd3bbb0baa7529a72efdd753131&version=5.2.0&apptype=android";
		String BBS_JH_KYMC="http://api.360che.com/BBSRecommend/app/BBSRecommendInfoList.aspx?id=3&page=%d&key=e8923bd3bbb0baa7529a72efdd753131&version=5.2.0&apptype=android";
		String BBS_JH_NRGC="http://api.360che.com/BBSRecommend/app/BBSRecommendInfoList.aspx?id=4&page=%d&key=e8923bd3bbb0baa7529a72efdd753131&version=5.2.0&apptype=android";
		String BBS_JH_QGZQ="http://api.360che.com/BBSRecommend/app/BBSRecommendInfoList.aspx?id=5&page=%d&key=e8923bd3bbb0baa7529a72efdd753131&version=5.2.0&apptype=android";
		String BBS_JH_KSSJ="http://api.360che.com/BBSRecommend/app/BBSRecommendInfoList.aspx?id=6&page=%d&key=e8923bd3bbb0baa7529a72efdd753131&version=5.2.0&apptype=android";
		String BBS_JH_HYDT="http://api.360che.com/BBSRecommend/app/BBSRecommendInfoList.aspx?id=9&page=%d&key=e8923bd3bbb0baa7529a72efdd753131&version=5.2.0&apptype=android";
		String BBS_JH_GGTC="http://api.360che.com/BBSRecommend/app/BBSRecommendInfoList.aspx?id=8&page=%d&key=e8923bd3bbb0baa7529a72efdd753131&version=5.2.0&apptype=android";
		String BBS_JH_QGTC="http://api.360che.com/BBSRecommend/app/BBSRecommendInfoList.aspx?id=7&page=%d&key=e8923bd3bbb0baa7529a72efdd753131&version=5.2.0&apptype=android";
		String BBS_JH_KCWH="http://api.360che.com/BBSRecommend/app/BBSRecommendInfoList.aspx?id=11&page=%d&key=e8923bd3bbb0baa7529a72efdd753131&version=5.2.0&apptype=android";
	//帖子
		String TZ_NEW="http://app.bbs.360che.com/newpost.inc.php?page=1&version=5.2.0";
		String TZ_HOT="http://bbs.360che.com/app/apphot10.inc.php?action=7&date=2015-11-23&version=5.2.0";
	//详情
		String XQ_ZIXUN="http://app.360che.com/app/android/article/articleindex.aspx?articleid=%d&version=5.2.0&apptype=android";
		String XQ_TIEZI="http://app.bbs.360che.com/newviewthreadapp1.php?tid=957806&uid=&oauth=&version=5.2.0";
	
	}
}
