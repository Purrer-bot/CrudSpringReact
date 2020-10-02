package com.purrer.crud.unused;

import java.util.Objects;

public class Losted {

    private int id;

    public Losted(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Losted losted = (Losted) o;
        return id == losted.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
