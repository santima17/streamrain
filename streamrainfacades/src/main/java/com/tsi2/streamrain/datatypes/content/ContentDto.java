package com.tsi2.streamrain.datatypes.content;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ContentDto {
	
	private Integer id;
    private String name;
    private String description;
    private String type;
    private Double ranking;
    private String coverPictureUrl;
    private String storageUrl;
    private Boolean isPayPerView;
    private CommonsMultipartFile picture;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getRanking() {
		return ranking;
	}
	public void setRanking(Double ranking) {
		this.ranking = ranking;
	}
	public String getCoverPictureUrl() {
		return coverPictureUrl;
	}
	public void setCoverPictureUrl(String coverPictureUrl) {
		this.coverPictureUrl = coverPictureUrl;
	}
	public String getStorageUrl() {
		return storageUrl;
	}
	public void setStorageUrl(String storageUrl) {
		this.storageUrl = storageUrl;
	}
	public Boolean getIsPayPerView() {
		return isPayPerView;
	}
	public void setIsPayPerView(Boolean isPayPerView) {
		this.isPayPerView = isPayPerView;
	}
	public CommonsMultipartFile getPicture() {
		return picture;
	}
	public void setPicture(CommonsMultipartFile picture) {
		this.picture = picture;
	}
	    
}
