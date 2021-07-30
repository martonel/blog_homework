package hu.ulyssys.course.homework.service.impl;

import hu.ulyssys.course.homework.entities.AbstractType;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractServiceImpl<T extends AbstractType> {
    private List<T> list = new ArrayList<>();

    public List<T> getAll() {
        return list;
    }

    public void add(T blog) {
        list.add(blog);
    }

    public void remove(T blog) {
        list.remove(blog);
    }

}
