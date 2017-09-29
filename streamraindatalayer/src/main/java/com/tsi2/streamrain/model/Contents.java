package com.tsi2.streamrain.model;
// Generated 26/09/2017 05:05:12 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Contents generated by hbm2java
 */
public class Contents  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String description;
     private String type;
     private String coverPictureUrl;
     private String storageUrl;
     private Boolean isPayPerView;
     private Set categorieses = new HashSet(0);
     private Set userFavses = new HashSet(0);
     private Set contentCollectionses = new HashSet(0);
     private Set contentCastses = new HashSet(0);
     private Set userUnfavses = new HashSet(0);
     private AlwaysAvailableContents alwaysAvailableContents;
     private Set contentsesForIdContent2 = new HashSet(0);
     private Set userViewses = new HashSet(0);
     private Set contentsesForIdContent1 = new HashSet(0);
     private Set userPpvses = new HashSet(0);
     private LiveOnlyContents liveOnlyContents;
     private Set featuredContentses = new HashSet(0);
     private Set userRatingses = new HashSet(0);

    public Contents() {
    }

	
    public Contents(String name, String type, String coverPictureUrl, String storageUrl) {
        this.name = name;
        this.type = type;
        this.coverPictureUrl = coverPictureUrl;
        this.storageUrl = storageUrl;
    }
    public Contents(String name, String description, String type, String coverPictureUrl, String storageUrl, Boolean isPayPerView, Set categorieses, Set userFavses, Set contentCollectionses, Set contentCastses, Set userUnfavses, AlwaysAvailableContents alwaysAvailableContents, Set contentsesForIdContent2, Set userViewses, Set contentsesForIdContent1, Set userPpvses, LiveOnlyContents liveOnlyContents, Set featuredContentses, Set userRatingses) {
       this.name = name;
       this.description = description;
       this.type = type;
       this.coverPictureUrl = coverPictureUrl;
       this.storageUrl = storageUrl;
       this.isPayPerView = isPayPerView;
       this.categorieses = categorieses;
       this.userFavses = userFavses;
       this.contentCollectionses = contentCollectionses;
       this.contentCastses = contentCastses;
       this.userUnfavses = userUnfavses;
       this.alwaysAvailableContents = alwaysAvailableContents;
       this.contentsesForIdContent2 = contentsesForIdContent2;
       this.userViewses = userViewses;
       this.contentsesForIdContent1 = contentsesForIdContent1;
       this.userPpvses = userPpvses;
       this.liveOnlyContents = liveOnlyContents;
       this.featuredContentses = featuredContentses;
       this.userRatingses = userRatingses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public String getCoverPictureUrl() {
        return this.coverPictureUrl;
    }
    
    public void setCoverPictureUrl(String coverPictureUrl) {
        this.coverPictureUrl = coverPictureUrl;
    }
    public String getStorageUrl() {
        return this.storageUrl;
    }
    
    public void setStorageUrl(String storageUrl) {
        this.storageUrl = storageUrl;
    }
    public Boolean getIsPayPerView() {
        return this.isPayPerView;
    }
    
    public void setIsPayPerView(Boolean isPayPerView) {
        this.isPayPerView = isPayPerView;
    }
    public Set getCategorieses() {
        return this.categorieses;
    }
    
    public void setCategorieses(Set categorieses) {
        this.categorieses = categorieses;
    }
    public Set getUserFavses() {
        return this.userFavses;
    }
    
    public void setUserFavses(Set userFavses) {
        this.userFavses = userFavses;
    }
    public Set getContentCollectionses() {
        return this.contentCollectionses;
    }
    
    public void setContentCollectionses(Set contentCollectionses) {
        this.contentCollectionses = contentCollectionses;
    }
    public Set getContentCastses() {
        return this.contentCastses;
    }
    
    public void setContentCastses(Set contentCastses) {
        this.contentCastses = contentCastses;
    }
    public Set getUserUnfavses() {
        return this.userUnfavses;
    }
    
    public void setUserUnfavses(Set userUnfavses) {
        this.userUnfavses = userUnfavses;
    }
    public AlwaysAvailableContents getAlwaysAvailableContents() {
        return this.alwaysAvailableContents;
    }
    
    public void setAlwaysAvailableContents(AlwaysAvailableContents alwaysAvailableContents) {
        this.alwaysAvailableContents = alwaysAvailableContents;
    }
    public Set getContentsesForIdContent2() {
        return this.contentsesForIdContent2;
    }
    
    public void setContentsesForIdContent2(Set contentsesForIdContent2) {
        this.contentsesForIdContent2 = contentsesForIdContent2;
    }
    public Set getUserViewses() {
        return this.userViewses;
    }
    
    public void setUserViewses(Set userViewses) {
        this.userViewses = userViewses;
    }
    public Set getContentsesForIdContent1() {
        return this.contentsesForIdContent1;
    }
    
    public void setContentsesForIdContent1(Set contentsesForIdContent1) {
        this.contentsesForIdContent1 = contentsesForIdContent1;
    }
    public Set getUserPpvses() {
        return this.userPpvses;
    }
    
    public void setUserPpvses(Set userPpvses) {
        this.userPpvses = userPpvses;
    }
    public LiveOnlyContents getLiveOnlyContents() {
        return this.liveOnlyContents;
    }
    
    public void setLiveOnlyContents(LiveOnlyContents liveOnlyContents) {
        this.liveOnlyContents = liveOnlyContents;
    }
    public Set getFeaturedContentses() {
        return this.featuredContentses;
    }
    
    public void setFeaturedContentses(Set featuredContentses) {
        this.featuredContentses = featuredContentses;
    }
    public Set getUserRatingses() {
        return this.userRatingses;
    }
    
    public void setUserRatingses(Set userRatingses) {
        this.userRatingses = userRatingses;
    }




}

