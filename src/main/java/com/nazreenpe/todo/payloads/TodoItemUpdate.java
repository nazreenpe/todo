package com.nazreenpe.todo.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TodoItemUpdate {
    private String title;
    private Boolean completed;

    public TodoItemUpdate() {
    }

    public TodoItemUpdate(String title, Boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public Boolean getCompleted() {
        return completed;
    }
}
