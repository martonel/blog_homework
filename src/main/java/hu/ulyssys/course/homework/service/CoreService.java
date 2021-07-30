package hu.ulyssys.course.homework.service;


import hu.ulyssys.course.homework.entities.AbstractType;

import java.util.List;

public interface CoreService<T extends AbstractType> {
    List<T> getAll();

    void add(T blog);

    void remove(T blog);

    void update(T blog);
}
