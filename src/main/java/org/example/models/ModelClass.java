package org.example.models;

public class ModelClass {
    public int getId() {
        return id;
    }

    public ModelClass(int id, String className) {
        this.id = id;
        this.className = className;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    private int id;
    private String className;

}
