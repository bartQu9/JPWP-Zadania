package com.example.aplikacjadlagracza.ui.mojeGry;

import android.app.Dialog;
import android.os.Bundle;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikacjadlagracza.DodajPartieDialog;
import com.example.aplikacjadlagracza.GraMoja;
import com.example.aplikacjadlagracza.R;

import java.util.ArrayList;

public class MojeGryAdapter extends RecyclerView.Adapter<MojeGryHolder> {

    private Context context;
    private ArrayList<GraMoja> listaMoichGier;
    private ImageButton dodajPartieButton;

    public MojeGryAdapter(Context context, ArrayList<GraMoja> listaMoichGier) {
        this.context = context;
        this.listaMoichGier = listaMoichGier;
    }

    @NonNull
    @Override
    public MojeGryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pojedyncza_mojagra, null);
        return new MojeGryHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MojeGryHolder holder, int position) {
        holder.getTextNazwa().setText(listaMoichGier.get(position).getNazwa());
        holder.getTextLiczbaPartii().setText(String.valueOf(listaMoichGier.get(position).getLiczbaPartii()));
        holder.getTextLiczbaWygranych().setText(String.valueOf(listaMoichGier.get(position).getLiczbaWygranych()));
        holder.getTextProcentWygranych().setText(String.valueOf(listaMoichGier.get(position).getProcentWygranych()));
        holder.getTextCena().setText(String.valueOf(listaMoichGier.get(position).getCena()));
        holder.getTextCenaPojedynczejPartii().setText(String.valueOf(listaMoichGier.get(position).getCenaJednejPartii()));
        final GraMoja graMoja = listaMoichGier.get(position);
        holder.getDodajPartieButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(graMoja);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaMoichGier.size();
    }

    public void openDialog(GraMoja graMoja) {
        DodajPartieDialog dodajPartieDialog = new DodajPartieDialog();
        dodajPartieDialog.setGraMoja(graMoja);
        dodajPartieDialog.show(((AppCompatActivity)context).getSupportFragmentManager(), "dialog");
    }

}
