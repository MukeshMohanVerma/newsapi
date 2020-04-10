package com.newsapi.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newsapi.dto.Article;
import com.newsapi.dto.NewsSourceRequest;
import com.newsapi.service.NewsSourceService;

@RestController
public class NewsSourceController {
	
	@Autowired
	private NewsSourceService newsSourceService;
	
	@RequestMapping(value = "/getNews", method = RequestMethod.POST)
	public List<Article> getNews(HttpServletRequest request, @RequestBody NewsSourceRequest sourceRequest){
		List<Article> newsList = newsSourceService.getNewsData(sourceRequest);
		return newsList;
	}
}
