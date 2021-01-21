package com.hr180011_huseyin_gokhan_karacavus_final_proje.util;

import com.google.gson.Gson;
import com.hr180011_huseyin_gokhan_karacavus_final_proje.model.FilmModel;

public class ObjectUtil {

    public  static String filmToJsonString(FilmModel film)
    {
        Gson gson = new Gson();
        return   gson.toJson(film);
    }

    public  static FilmModel jsonStringToFilm(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,FilmModel.class);
    }
}