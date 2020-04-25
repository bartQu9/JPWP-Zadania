package com.example.aplikacjadlagracza.ui.gry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikacjadlagracza.DodajPartieDialog;
import com.example.aplikacjadlagracza.Gra;
import com.example.aplikacjadlagracza.GraMoja;
import com.example.aplikacjadlagracza.R;

import java.util.ArrayList;

public class GryAdapter extends RecyclerView.Adapter<GryHolder> {

    private Context context;
    private ArrayList<Gra> listaGier;
    private ImageButton dodajPartieButton;

    public GryAdapter(Context context, ArrayList<Gra> listaGier) {
        this.context = context;
        this.listaGier = listaGier;
    }

    @NonNull
    @Override
    public GryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pojedyncza_gra, null);
        return new GryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GryHolder holder, int position) {
        holder.getTextNazwa().setText(listaGier.get(position).getNazwa());
        holder.getTextLiczbaPartii().setText(String.valueOf(listaGier.get(position).getLiczbaPartii()));
        holder.getTextLiczbaWygranych().setText(String.valueOf(listaGier.get(position).getLiczbaWygranych()));
        holder.getTextProcentWygranych().setText(String.valueOf(listaGier.get(position).getProcentWygranych()));
        final Gra gra = (Gra) listaGier.get(position);
        //dodajPartieButton = (ImageButton) findViewById(R.id.dodajPartieButton);
        holder.getDodajPartieButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog(gra);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaGier.size();
    }
    public void openDialog(Gra gra) {
        DodajPartieDialog dodajPartieDialog = new DodajPartieDialog();
        dodajPartieDialog.setGra(gra);
        dodajPartieDialog.show(((AppCompatActivity)context).getSupportFragmentManager(), "dialog");
    }
}
