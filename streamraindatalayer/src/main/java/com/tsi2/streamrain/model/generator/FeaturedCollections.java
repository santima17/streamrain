package com.tsi2.streamrain.model.generator;
// Generated 04/10/2017 11:03:07 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * FeaturedCollections generated by hbm2java
 */
public class FeaturedCollections  implements java.io.Serializable {


     private Integer id;
     private Collections collections;
     private Date dateStart;
     private Date dateFinish;

    public FeaturedCollections() {
    }

    public FeaturedCollections(Collections collections, Date dateStart, Date dateFinish) {
       this.collections = collections;
       this.dateStart = dateStart;
       this.dateFinish = dateFinish;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Collections getCollections() {
        return this.collections;
    }
    
    public void setCollections(Collections collections) {
        this.collections = collections;
    }
    public Date getDateStart() {
        return this.dateStart;
    }
    
    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }
    public Date getDateFinish() {
        return this.dateFinish;
    }
    
    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }




}

