package com.hr180011_huseyin_gokhan_karacavus_final_proje.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.hr180011_huseyin_gokhan_karacavus_final_proje.R;
import com.hr180011_huseyin_gokhan_karacavus_final_proje.model.FilmModel;
import com.hr180011_huseyin_gokhan_karacavus_final_proje.util.Constants;
import com.hr180011_huseyin_gokhan_karacavus_final_proje.util.GlideUtil;
import com.hr180011_huseyin_gokhan_karacavus_final_proje.util.ObjectUtil;

public class DetayActivity extends AppCompatActivity {
    ImageView imgFilmKapak;
    TextView txtFilmAdi;
    TextView txtVizyonTarihi;
    TextView txtFilmTuru;
    TextView txtOzet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        init();
    }

    private void init()
    { String FilmString =getIntent().getStringExtra(Constants.TIKLANAN_FİLM_BASLIGI);
        FilmModel FilmModel = ObjectUtil.jsonStringToFilm(FilmString);
        imgFilmKapak =findViewById(R.id.imgKapak);
        txtFilmAdi =findViewById(R.id.txtFilmAdi);
        txtFilmTuru =findViewById(R.id.txtFilmTuru);
        txtVizyonTarihi =findViewById(R.id.txtFilmVizyonTarihi);
        txtOzet=findViewById(R.id.txtOzet);
        txtFilmAdi.setText(FilmModel.getFilmAdi());
        txtFilmTuru.setText(FilmModel.getFilmTuru());
        txtVizyonTarihi.setText(FilmModel.getFilmVizyonTarihi());
        txtOzet.setText(Html.fromHtml(FilmModel.getOzet(),Html.FROM_HTML_MODE_COMPACT));
        GlideUtil.resmiIndiripGoster(getApplicationContext(),FilmModel.getKapakFotoUrl(),imgFilmKapak); }

}