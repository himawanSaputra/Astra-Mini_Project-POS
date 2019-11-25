package com.ai.pos.service;

import java.util.List;

public interface Service<T extends Object> {
    T get(Integer id);
    List<T> getAll();
    void insert(T object);
    void update(T object);
    void delete(T object);
}
