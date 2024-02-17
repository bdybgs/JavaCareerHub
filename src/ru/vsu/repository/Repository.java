package ru.vsu.repository;
import java.util.List;

public interface Repository <T> {
    List<T> getAll();
    //T getByID(int id);
    void add(T obj);
    //void delete(int id);
    //void update(int id, T newObj);
}
