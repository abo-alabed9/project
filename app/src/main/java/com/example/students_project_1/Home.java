package com.example.students_project_1;

public class Home {

    private int img;
    private String tv_name;

    public Home(int img, String tv_name) {
        this.img = img;
        this.tv_name = tv_name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }
}
