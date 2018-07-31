package com.nazreenpe.todo.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Test;

import java.io.IOException;

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
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        String serialized = objectMapper.writeValueAsString(todoItem);
        System.out.println(serialized);
    }

    @Test
    public void canSerializeAndDeserialize() throws IOException {
        TodoItem todoItem = new TodoItem("Buy hiking pole");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        String serialized = objectMapper.writeValueAsString(todoItem);
        TodoItem deserialized = objectMapper.readValue(serialized, TodoItem.class);

        assertEquals(todoItem.getTitle(), deserialized.getTitle());
        assertEquals(todoItem.getCompleted(), deserialized.getCompleted());
        assertEquals(todoItem.getOrder(), deserialized.getOrder());
        assertEquals(todoItem.getId(), deserialized.getId());
        assertEquals(todoItem.getCreatedAt(), deserialized.getCreatedAt());
        assertEquals(todoItem.getUpdatedAt(), deserialized.getUpdatedAt());
    }
}