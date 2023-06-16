package com.example.students_project_1.models;

public class Students {

    private int id;
    private String first_Name;
    private String last_Name;
    private int birthdate;
    private int img;


    public static final String TABLE_NAME="students";
    public static final String COL_ID="id";
    public static final String COL_FIRST_NAME="first_Name";
    public static final String COL_LAST_NAME="last_Name";
    public static final String COL_BIRTHDATE="birthdate";

    public static final String CREATE_TABLE=" CREATE TABLE IF NOT EXISTS "+ TABLE_NAME +
            " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_FIRST_NAME + " TEXT, " +
            COL_LAST_NAME + " TEXT, " +
            COL_BIRTHDATE + " INTEGER " ;


    public Students(int id, String first_Name, String last_Name, int birthdate) {
        this.id = id;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.birthdate = birthdate;
        this.img=img;
    }


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public int getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(int birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", first_Name='" + first_Name + '\'' +
                ", last_Name='" + last_Name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
