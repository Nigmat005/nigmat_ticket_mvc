package com.cydeo.service;

import java.util.List;
import java.util.Map;

public interface CurdService<Id,T> {
     T save(T object);
     T findById(Id id);
     List<T> findAll();
     void update(Id id,T object);
     void deleteById(Id id);
     Map<Id,T> createAll(List<T> list);
}
