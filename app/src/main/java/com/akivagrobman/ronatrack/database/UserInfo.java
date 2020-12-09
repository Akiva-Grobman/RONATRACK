package com.akivagrobman.ronatrack.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_info_table")
public class UserInfo {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private final int id;

    @ColumnInfo(name = "age")
    private final int age;

    @ColumnInfo(name = "weight")
    private final int weight;

    @ColumnInfo(name = "height")
    private final int height;

    @NonNull
    @ColumnInfo(name = "gender")
    private final String gender;

    public UserInfo(int id, int age, int weight, int height, @NonNull String gender) {
        this.id = id;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public String getGender() {
        return gender;
    }

}

