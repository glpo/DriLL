package com.angl.drill.db.entity;

import com.angl.drill.db.utils.NotificationType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = Notification.NOTIFICATION_COLLECTION_NAME)
public class Notification {
    public static final String NOTIFICATION_COLLECTION_NAME = "notifications";

    public Notification() {
    }

    @Id
    @JsonIgnore
    private ObjectId id;

    private String text;

    private Date date;

    private NotificationType type;

    public ObjectId getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public NotificationType getType() {
        return type;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }
}
