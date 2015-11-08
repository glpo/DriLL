package com.angl.drill.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = UserEntity.COLLECTION_NAME)
public class UserEntity {
    public static final String COLLECTION_NAME = "users";

    @Id
    private String id;

    private String name;
    private String passwd;

    public UserEntity() { }

    public UserEntity(String name, String passwd){
        this.name = name;
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
