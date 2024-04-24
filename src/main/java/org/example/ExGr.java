package org.example;

import java.util.ArrayList;
import java.util.List;

public class ExGr {
    List<Example> group = new ArrayList<Example>();
    int id;


    public ExGr(int id) {
        this.id = id;

    }

    public List<Example> getGroup() {
        return group;
    }
    public void add(Example e) {
        group.add(e);
    }
    public void print() {
        for (Example e : group) {
            System.out.println(e.getName());
            System.out.println(e.coocked);
            System.out.println();
        }

    }
}
