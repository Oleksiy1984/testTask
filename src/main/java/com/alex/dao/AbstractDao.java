package com.alex.dao;

import com.alex.dao.connection.Executor;

public abstract class AbstractDao<T> implements GenericDao<T> {

    private final Executor executor = new Executor();

    @Override
    public Executor getExecutor() {
        return executor;
    }
}
