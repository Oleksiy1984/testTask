package com.alex.dao;

import com.alex.dao.connection.Executor;

public interface GenericDao<T> {
    Executor getExecutor();
}