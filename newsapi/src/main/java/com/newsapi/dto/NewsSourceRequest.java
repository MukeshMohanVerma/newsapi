package com.newsapi.dto;

public class NewsSourceRequest {

	private String country;
	private String categories;
	private int limit;

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
}
