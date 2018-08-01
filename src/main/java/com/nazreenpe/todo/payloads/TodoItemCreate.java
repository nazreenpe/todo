package com.nazreenpe.todo.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TodoItemCreate {
    private String title;

    @JsonProperty
    public String getTitle() {
        return this.title;
    }
}
