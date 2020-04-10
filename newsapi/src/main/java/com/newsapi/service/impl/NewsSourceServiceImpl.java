package com.newsapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.newsapi.constant.AppConstant;
import com.newsapi.dto.Article;
import com.newsapi.dto.NewsData;
import com.newsapi.dto.NewsSourceRequest;
import com.newsapi.service.NewsSourceService;
import com.newsapi.utils.BaseUtils;

@Service
public class NewsSourceServiceImpl implements NewsSourceService{
	
	@Autowired
	private Environment env;
	
	@Override
	public List<Article> getNewsData(final NewsSourceRequest sourceRequest) {
		if(sourceRequest.getCountry() != null && !sourceRequest.getCountry().isEmpty()){
			System.out.println("Searching for Country = " + sourceRequest.getCountry() + ", Categories = " + sourceRequest.getCategories() + ", News Limit = " + sourceRequest.getLimit());
			String apiBaseUrl = env.getProperty(AppConstant.NEWS_API_URL);
			NewsData newsData = new NewsData();
			for(String category : sourceRequest.getCategories().split(AppConstant.COMMA)){
				final String apiUrl = BaseUtils.createApiUrl(sourceRequest.getCountry(), category, apiBaseUrl);
				System.out.println("Hitting News Api = " + apiUrl);
				NewsData data = BaseUtils.getNewsData(apiUrl);
				if(data.getTotalResults() == 0){
					continue;
				}
				if(newsData.getArticles() == null){
					newsData.setArticles(data.getArticles());
				}else{
					newsData.getArticles().addAll(data.getArticles());
				}
				newsData.setTotalResults(newsData.getTotalResults() + data.getTotalResults());
			}
			List<Article> newsList = BaseUtils.getNewsListWithLimit(newsData, sourceRequest.getLimit());
			return newsList;
		}
		return null;
	}

}
