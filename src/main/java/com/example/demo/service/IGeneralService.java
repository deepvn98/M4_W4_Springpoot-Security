package com.example.demo.service;

import java.util.Optional;

public interface IGeneralService <T>{
    Iterable<T> getAll();
    Optional<T> getByID(Long id);
    T getByName(String name);
    T save (T t);
    void delete (Long id);
}
