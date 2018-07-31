package com.nazreenpe.todo.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public class TodoItemTest {

    @Test
    public void testFeildsAreInitializedCorrectly() {
        TodoItem item = new TodoItem("Buy flowers");
        assertEquals("Buy flowers", item.getTitle());
        assertFalse(item.getCompleted());
        assertEquals(-1, item.getOrder());
        assertNotNull(item.getCreatedAt());
        assertNotNull(item.getUpdatedAt());
        assertNotNull(item.getId());
    }

    @Test
    public void checkIfMarkedAsCompleted() {
        TodoItem item = new TodoItem("Learn Java");
        item.markAsCompleted();
        assertTrue(item.getCompleted());
    }

    @Test
    public void checkIfUnmarkedAsCompleted() {
        TodoItem todoItem = new TodoItem("Finish Chapter 5");
        todoItem.markAsToBeCompleted();
        assertFalse(todoItem.getCompleted());
    }

    @Test
    public void containsIdWhenSerialized() throws JsonProcessingException {
        TodoItem todoItem = new TodoItem("Buy milk");
        ObjectMapper objectMapper = new ObjectMapper();
        String serialized = objectMapper.writeValueAsString(todoItem);
        System.out.println(serialized);
    }
}