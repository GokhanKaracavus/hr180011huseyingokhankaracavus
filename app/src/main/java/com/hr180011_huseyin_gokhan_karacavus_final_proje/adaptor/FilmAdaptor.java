package com.hr180011_huseyin_gokhan_karacavus_final_proje.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.hr180011_huseyin_gokhan_karacavus_final_proje.model.FilmModel;
import com.hr180011_huseyin_gokhan_karacavus_final_proje.R;
import com.hr180011_huseyin_gokhan_karacavus_final_proje.util.GlideUtil;

import java.util.List;

public class FilmAdaptor extends RecyclerView.Adapter<FilmViewHolder> {


    List<FilmModel> filmler;
    Context context;
    OnItemClickListener listener;

    public FilmAdaptor(List<FilmModel> filmler, Context applicationContext) {
    }

    public interface OnItemClickListener{
        void onClick(int position);
    }

    public FilmAdaptor(List<FilmModel> filmler, Context context, OnItemClickListener listener) {
        this.context = context;
        this.filmler = filmler;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_filmler,parent,false);
        return new FilmViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder viewHolder, int position) {

        viewHolder.txtTarih.setText(filmler.get(position).getFilmVizyonTarihi());
        viewHolder.txtFilmAdi.setText(filmler.get(position).getFilmAdi());
        GlideUtil.resmiIndiripGoster(context,filmler.get(position).getLogoUrl(),viewHolder.imgFilmLogo);

    }

    @Override
    public int getItemCount() {
        return filmler.size();
    }
}
