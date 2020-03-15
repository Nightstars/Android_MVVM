package com.christ.android_mvvm.model;

public class Famoussay {
    private String famous_name;
    private String famous_saying;
    public Famoussay(){

    }
    public Famoussay(String famous_name, String famous_saying) {
        this.famous_name = famous_name;
        this.famous_saying = famous_saying;
    }

    public String getFamous_name() {
        return famous_name;
    }

    public void setFamous_name(String famous_name) {
        this.famous_name = famous_name;
    }

    public String getFamous_saying() {
        return famous_saying;
    }

    public void setFamous_saying(String famous_saying) {
        this.famous_saying = famous_saying;
    }
}
