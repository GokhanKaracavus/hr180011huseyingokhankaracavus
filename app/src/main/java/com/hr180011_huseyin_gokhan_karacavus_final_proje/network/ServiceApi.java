package com.hr180011_huseyin_gokhan_karacavus_final_proje.network;

import com.hr180011_huseyin_gokhan_karacavus_final_proje.FilmApplication;
import com.hr180011_huseyin_gokhan_karacavus_final_proje.model.FilmModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    //base url
    //
    @GET("HarryPotterFilmlerApi.json")
    Observable<List<FilmModel>> filmleriGetir();
}
