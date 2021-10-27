package com.opiz.webservice.dao;

import java.util.List;

public interface Dao<T> {

    T get(long id);

    List<T> getAll();

    T save(T t);

    T update(T t);

    T delete(T t);
}
