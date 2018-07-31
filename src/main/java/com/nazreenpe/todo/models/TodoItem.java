package com.nazreenpe.todo.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class TodoItem {
    private String title;
    private boolean completed;
    private String id;
    private int order;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TodoItem(String title) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.completed = false;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
        this.order = -1;
    }


    public String getTitle() {
        return this.title;
    }

    public boolean getCompleted() {
        return this.completed;
    }

    public int getOrder() {
        return this.order;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    public void markAsToBeCompleted() {
        this.completed =false;
    }

    public String getId() {
        return this.id;
    }

//    public void setUpdatedAt() {
//        this.updatedAt = LocalDateTime.now();
//    }

}
