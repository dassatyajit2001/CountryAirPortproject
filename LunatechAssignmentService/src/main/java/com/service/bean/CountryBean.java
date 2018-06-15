package com.service.bean;

import java.io.Serializable;

public class CountryBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7277659699675208478L;
	int id;
	String code;
	String name;
	String continent;
	String wikipediaLink;
	String keywords;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public CountryBean setId(int id) {
		this.id = id;
		return this;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public CountryBean setCode(String code) {
		this.code = code;
		return this;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public CountryBean setName(String name) {
		this.name = name;
		return this;
	}
	/**
	 * @return the continent
	 */
	public String getContinent() {
		return continent;
	}
	/**
	 * @param continent the continent to set
	 */
	public CountryBean setContinent(String continent) {
		this.continent = continent;
		return this;
	}
	/**
	 * @return the wikipediaLink
	 */
	public String getWikipediaLink() {
		return wikipediaLink;
	}
	/**
	 * @param wikipediaLink the wikipediaLink to set
	 */
	public CountryBean setWikipediaLink(String wikipediaLink) {
		this.wikipediaLink = wikipediaLink;
		return this;
	}
	/**
	 * @return the keywords
	 */
	public String getKeywords() {
		return keywords;
	}
	/**
	 * @param keywords the keywords to set
	 */
	public CountryBean setKeywords(String keywords) {
		this.keywords = keywords;
		return this;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CountryBean [id=" + id + ", code=" + code + ", name=" + name + ", continent=" + continent
				+ ", wikipediaLink=" + wikipediaLink + ", keywords=" + keywords + "]";
	}
	
	
	
}
