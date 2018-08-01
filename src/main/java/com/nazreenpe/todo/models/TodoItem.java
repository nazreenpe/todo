package com.nazreenpe.todo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public class TodoItem {
    private String title;
    private boolean completed;
    private String id;
    private int order;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TodoItem() {
    }

    public TodoItem(String title) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.completed = false;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
        this.order = -1;
    }

    @JsonProperty
    public String getTitle() {
        return this.title;
    }
    @JsonProperty
    public boolean getCompleted() {
        return this.completed;
    }
    @JsonProperty
    public int getOrder() {
        return this.order;
    }
    @JsonProperty
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }
    @JsonProperty
    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void markAsCompleted() {
        this.completed = true;
        setUpdatedAt();
    }

    public void markAsToBeCompleted() {
        this.completed =false;
        setUpdatedAt();
    }
    @JsonProperty
    public String getId() {
        return this.id;
    }

    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

}
