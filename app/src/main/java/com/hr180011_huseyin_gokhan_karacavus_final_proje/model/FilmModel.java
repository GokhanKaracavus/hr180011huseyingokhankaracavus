package com.hr180011_huseyin_gokhan_karacavus_final_proje.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilmModel {

    @SerializedName("FilmAdi")
    @Expose
    private String filmAdi;
    @SerializedName("FilmVizyonTarihi")
    @Expose
    private String filmVizyonTarihi;
    @SerializedName("FilmTuru")
    @Expose
    private String filmTuru;
    @SerializedName("KapakFotoUrl")
    @Expose
    private String kapakFotoUrl;
    @SerializedName("LogoUrl")
    @Expose
    private String logoUrl;
    @SerializedName("Ozet")
    @Expose
    private String ozet;

    public String getFilmAdi() {
        return filmAdi;
    }

    public void setFilmAdi(String filmAdi) {
        this.filmAdi = filmAdi;
    }

    public String getFilmVizyonTarihi() {
        return filmVizyonTarihi;
    }

    public void setFilmVizyonTarihi(String filmVizyonTarihi) {
        this.filmVizyonTarihi = filmVizyonTarihi;
    }

    public String getFilmTuru() {
        return filmTuru;
    }

    public void setFilmTuru(String filmTuru) {
        this.filmTuru = filmTuru;
    }

    public String getKapakFotoUrl() {
        return kapakFotoUrl;
    }

    public void setKapakFotoUrl(String kapakFotoUrl) {
        this.kapakFotoUrl = kapakFotoUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getOzet() {
        return ozet;
    }

    public void setOzet(String ozet) {
        this.ozet = ozet;
    }

}
