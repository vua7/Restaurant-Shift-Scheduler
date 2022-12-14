package com.example.a395_team_ritchie;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Converters {

    /*@TypeConverter
    public static ArrayList<Integer> intFromDb(String value) {
        Type listType = new TypeToken<ArrayList<Integer>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String intToDb(ArrayList<Integer> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }*/

    @TypeConverter
    public static ArrayList<String> fromDb(String value) {
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    /*@TypeConverter
    public static ArrayList<Student> manyFromDb(String value) {
        Type listType = new TypeToken<ArrayList<Student>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }*/

    @TypeConverter
    public static String toDb(ArrayList<String> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

}
