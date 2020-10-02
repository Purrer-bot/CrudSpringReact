package com.purrer.crud.unused;

import org.hibernate.mapping.IdGenerator;

import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

public class Unused {
    public static void main(String[] args) {
        Set<Losted> set = new HashSet<>();
        Losted l = new Losted(3);
        set.add(l);

        System.out.println(set.contains(l));

        l.setId(4);

        System.out.println(set.contains(l));
    }
}
