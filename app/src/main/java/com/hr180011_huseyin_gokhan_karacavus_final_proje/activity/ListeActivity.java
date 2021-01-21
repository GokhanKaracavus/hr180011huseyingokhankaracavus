package com.hr180011_huseyin_gokhan_karacavus_final_proje.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import com.hr180011_huseyin_gokhan_karacavus_final_proje.R;
import com.hr180011_huseyin_gokhan_karacavus_final_proje.adaptor.FilmAdaptor;
import com.hr180011_huseyin_gokhan_karacavus_final_proje.model.FilmModel;
import com.hr180011_huseyin_gokhan_karacavus_final_proje.network.Service;
import com.hr180011_huseyin_gokhan_karacavus_final_proje.util.Constants;
import com.hr180011_huseyin_gokhan_karacavus_final_proje.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class ListeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        progressDialog = new ProgressDialog(ListeActivity.this);
        progressDialog.show();
        init();

    }
    private  void  init() {  filmleriGetir(); }
    void filmleriGetir() // Filmleri Getir
    {


        new Service().getServiceApi().filmleriGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<FilmModel>>() {
                List<FilmModel> filmler=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");
                    }

                    @Override
                    public void onNext(List<FilmModel> filmList) {
                        Log.e("RETROFIT","onNext : ");
                        filmler=filmList;
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("RETROFIT","onError : " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT","onComplete : ");
                        progressDialog.dismiss();
                        if(filmler.size()>0) {

                            initRecycleView(filmler);
                        }
                    }
                });
    }


    private  void  initRecycleView(List<FilmModel> filmler)
    {
        recyclerView =findViewById(R.id.rcvFilmler);
        FilmAdaptor fAdaptor =new FilmAdaptor(filmler, getApplicationContext(), new FilmAdaptor.OnItemClickListener() {
            @Override
            public void onClick(int position) {FilmModel tıklananfilm=filmler.get(position);
                detayaGecis(tıklananfilm); }});
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(fAdaptor);
    }
    private  void detayaGecis(FilmModel tıklananfilm){

        Intent DetayActivityIntent=new Intent(getApplicationContext(), DetayActivity.class );
        String tiklananFilmString= ObjectUtil.filmToJsonString(tıklananfilm);
        DetayActivityIntent.putExtra(Constants.TIKLANAN_FİLM_BASLIGI,tiklananFilmString);
        startActivity(DetayActivityIntent);}

    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage(getResources().getString(R.string.cikis));
        builder.setPositiveButton(getResources().getString(R.string.Hayır), new DialogInterface.OnClickListener() {
            @Override            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.Evet), new DialogInterface.OnClickListener() {
            @Override            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }





}