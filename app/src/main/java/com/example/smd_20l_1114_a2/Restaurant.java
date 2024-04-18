package com.example.smd_20l_1114_a2;

public class Restaurant {
    private String name, location, phone, description;
    private double rating;

    public Restaurant(){}

    public Restaurant(String name, String loc, String phn, String desc, double rat){
        this.name = name;
        this.location = loc;
        this.phone = phn;
        this.description = desc;
        this.rating = rat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
