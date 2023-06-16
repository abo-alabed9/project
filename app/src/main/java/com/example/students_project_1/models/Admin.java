package com.example.students_project_1.models;

public class Admin {

    private int id;
    private String user_name;
    private String email;
    private String password;


    public static final String TABLE_NAME = "admin";
    public static final String COL_ID = "id";
    public static final String COL_USER_NAME = "user_name";
    public static final String COL_EMAIL = "email";
    public static final String COL_PASSWORD = "password";


    public static final String CREATE_TABLE =" CREATE TABLE IF NOT EXISTS "+TABLE_NAME+
            " ( " + COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COL_USER_NAME + " TEXT ," +
            COL_EMAIL + " TEXT ," +
            COL_PASSWORD + " TEXT ) ";



    public Admin(int id, String user_name, String email, String password) {
        this.id = id;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
