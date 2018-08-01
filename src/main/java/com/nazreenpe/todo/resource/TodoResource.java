package com.nazreenpe.todo.resource;

import com.nazreenpe.todo.models.TodoItem;
import com.nazreenpe.todo.payloads.TodoItemCreate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/todo")
public class TodoResource {
    private List<TodoItem> items = new ArrayList<>();

    @RequestMapping(path = "", method = GET, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TodoItem> list() {
        return this.items;
    }

    @RequestMapping(path = "", method = POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public TodoItem create(@RequestBody TodoItemCreate payload) {
        TodoItem todoItem = new TodoItem(payload.getTitle());
        items.add(todoItem);
        return todoItem;
    }

}
