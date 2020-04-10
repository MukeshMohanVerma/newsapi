package com.newsapi.service;

import java.util.List;

import com.newsapi.dto.Article;
import com.newsapi.dto.NewsSourceRequest;

public interface NewsSourceService {

	public List<Article> getNewsData(NewsSourceRequest sourceRequest);

}
