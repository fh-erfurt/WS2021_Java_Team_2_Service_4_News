package de.fherfurt.news.service;

import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class ActionResult<T> {
    private StatusCode statusCode;
    T value;

    public enum StatusCode {
        PAGE_NOT_FOUND,
        ITEM_NOT_FOUND,
        INVALID_REQUEST,
        VALID_REQUEST,
    }

    public StatusCode getStatusCode() {
        return this.statusCode;
    }

    public T getValue() {
        return this.value;
    }
}
