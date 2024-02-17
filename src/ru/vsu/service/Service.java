package ru.vsu.service;
import java.util.List;

public interface Service <T>{
    List<T> getAll();
    //T getByID(int id);
    void add(T obj);
    //void delete(int id);
}
