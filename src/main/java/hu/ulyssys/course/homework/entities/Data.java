package hu.ulyssys.course.homework.entities;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class Data {
    public selectOne[] getStatuses() {
        return selectOne.values();
    }
}
