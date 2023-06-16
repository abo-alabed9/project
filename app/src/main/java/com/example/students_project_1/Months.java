package com.example.students_project_1;

public class Months {

    private String id;

    public Months(String  id) {
        this.id = id;
    }

    public Months() {

    }

    public String  getId() {
        return id;
    }

    public void setId(String  id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Months{" +
                "id=" + id +
                '}';
    }
}
