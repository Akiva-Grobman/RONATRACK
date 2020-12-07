package com.akivagrobman.ronatrack;

public class BasicInfo {

    String height, weight, age, gender;

    public BasicInfo(String height, String weight, String age, String gender) {
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.gender = gender;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
