package com.ai.pos.dao;

import java.util.List;

public interface DAO<T extends Object> {

    T get(Integer id);
    List<T> getAll();
    void insert(T object);
    void update(T object);
    void delete(T object);
    List<T> search(String theSearchName);
}
