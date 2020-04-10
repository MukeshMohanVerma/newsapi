package com.newsapi.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.newsapi.constant.AppConstant;
import com.newsapi.dto.Article;
import com.newsapi.dto.NewsData;

public class BaseUtils {

	public static NewsData getNewsData(final String apiUrl){
		RestTemplate template = new RestTemplate();
		ResponseEntity<NewsData> newsData = template.getForEntity(apiUrl, NewsData.class);
		return newsData.getBody();
	}
	
	public static String createApiUrl(final String country, final String category, final String apiUrl){
		final String finalApiUrl = apiUrl.replace(AppConstant.LBL_COUNTRY, country);
		if(category != null && !category.isEmpty()){
			return (finalApiUrl + AppConstant.PARAMETER_CATEGORY + category);
		}
		return finalApiUrl;
	}
	
	public static List<Article> getNewsListWithLimit(final NewsData newsData, final int limit){
		Map<String, List<Article>> sourceMap = new HashMap<String, List<Article>>();
		for(Article articleData : newsData.getArticles()){
			String sourceName = articleData .getSource().getName();
			List<Article> articleList = sourceMap.get(sourceName);
			if(articleList == null){
				articleList = new LinkedList<Article>();
				articleList.add(articleData);
				sourceMap.put(sourceName, articleList);
			}else{
				articleList.add(articleData);
			}
		}
		List<Map.Entry<String, List<Article>>> newsDataList = new LinkedList<>(sourceMap.entrySet());
		Collections.sort(newsDataList, new Comparator<Map.Entry<String, List<Article>> >() { 
			@Override
	        public int compare(Entry<String, List<Article>> l1, Entry<String, List<Article>> l2) {
				return String.valueOf(l2.getValue().size()).compareTo(String.valueOf(l1.getValue().size()));
	        }
	    });
		for(Map.Entry<String, List<Article>> newsInfo : newsDataList){
			System.out.println("Source Name = " + newsInfo.getKey() + ", Source Content Count = " + newsInfo.getValue().size());
		}
		List<Article> newsList = new LinkedList<>();
		for(int i=0; i<limit; i++){
			newsList.addAll(newsDataList.get(i).getValue());
		}
		return newsList;
	}
}
