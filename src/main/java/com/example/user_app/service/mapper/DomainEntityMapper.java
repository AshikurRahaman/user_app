package com.example.user_app.service.mapper;

import java.util.List;

public interface DomainEntityMapper<T,S> {
    public T entityToModel(S entity);

    public S modelToEntity(T model);

    public List<T> entityToModel(List<S> entity);

    public List<S> modelToEntity(List<T> model);
}
