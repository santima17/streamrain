package com.tsi2.streamrain.model;
// Generated 26/09/2017 05:05:12 PM by Hibernate Tools 4.3.1



/**
 * UserFavs generated by hbm2java
 */
public class UserFavs  implements java.io.Serializable {


     private UserFavsId id;
     private Contents contents;
     private Users users;

    public UserFavs() {
    }

    public UserFavs(UserFavsId id, Contents contents, Users users) {
       this.id = id;
       this.contents = contents;
       this.users = users;
    }
   
    public UserFavsId getId() {
        return this.id;
    }
    
    public void setId(UserFavsId id) {
        this.id = id;
    }
    public Contents getContents() {
        return this.contents;
    }
    
    public void setContents(Contents contents) {
        this.contents = contents;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }




}

