package com.nazreenpe.todo.resource;

import com.nazreenpe.todo.models.TodoItem;
import com.nazreenpe.todo.payloads.TodoItemCreate;
import com.nazreenpe.todo.payloads.TodoItemUpdate;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

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
    public ResponseEntity<TodoItem> create(@RequestBody TodoItemCreate payload) {
        if (payload.getTitle() == null) {
            return ResponseEntity.badRequest().build();
        } else {
            TodoItem todoItem = new TodoItem(payload.getTitle());
            items.add(todoItem);
            return ResponseEntity.ok(todoItem);
        }

    }

    @RequestMapping(path = "/{id}", method = GET, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TodoItem> get(@PathVariable("id") String id) {
        TodoItem found = findItemById(id);

        if (found == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(found);
        }
    }

    @RequestMapping(path = "/{id}", method = DELETE, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TodoItem> delete(@PathVariable("id") String id) {
        TodoItem item = findItemById(id);
        if (item == null) {
            return ResponseEntity.notFound().build();
        } else {
            items.remove(item);
            return ResponseEntity.ok().build();
        }
    }

    @RequestMapping(path = "/{id}", method = PATCH, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TodoItem> patch(@PathVariable("id") String id,
                                          @RequestBody TodoItemUpdate payload) {
        TodoItem item = findItemById(id);
        if (item == null) {
            return ResponseEntity.notFound().build();
        } else {
            if (payload.getCompleted() != null) {
                item.setCompleted(payload.getCompleted());
            }
            if (payload.getTitle() != null) {
                item.setTitle(payload.getTitle());
            }
            return ResponseEntity.ok(item);
        }
    }

    @RequestMapping(path = "/{id}", method = PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TodoItem> put(@PathVariable("id") String id,
                                        @RequestBody TodoItemUpdate payload) {
        TodoItem found = findItemById(id);
        if (found == null) {
            return ResponseEntity.notFound().build();
        } else {
            found.setTitle(payload.getTitle());
            found.setCompleted(payload.getCompleted());
            return ResponseEntity.ok(found);
        }
    }

    private TodoItem findItemById(String id) {
        TodoItem found = null;
        for (TodoItem item : items) {
            if (item.getId().equals(id)) {
                found = item;
                break;
            }
        }
        return found;
    }


}
