package com.nazreenpe.todo.resource;

import com.nazreenpe.todo.models.TodoItem;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/todo")
public class TodoResource {
    private List<TodoItem> items = new ArrayList<>();

    public TodoResource() {
        this.items.add(new TodoItem("Learn Java web development"));
    }

    @RequestMapping(path = "", method = GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TodoItem> list() {
        return this.items;
    }
}
