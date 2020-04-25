package com.example.aplikacjadlagracza.ui.gry;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikacjadlagracza.R;

public class GryHolder extends RecyclerView.ViewHolder {

    private TextView textNazwa;
    private TextView textLiczbaPartii;
    private TextView textLiczbaWygranych;
    private TextView textProcentWygranych;
    private ImageButton dodajPartieButton;

    public GryHolder(@NonNull View itemView) {
        super(itemView);
        this.textNazwa = (TextView) itemView.findViewById(R.id.textNazwa);
        this.textLiczbaPartii = (TextView) itemView.findViewById(R.id.textLiczbaPartii);
        this.textLiczbaWygranych = (TextView) itemView.findViewById(R.id.textLiczbaWygranych);
        this.textProcentWygranych = (TextView) itemView.findViewById(R.id.textProcentWygranych);
        this.dodajPartieButton = (ImageButton) itemView.findViewById(R.id.dodajPartieButton);

    }

    public ImageButton getDodajPartieButton() {
        return dodajPartieButton;
    }

    public void setDodajPartieButton(ImageButton dodajPartieButton) {
        this.dodajPartieButton = dodajPartieButton;
    }

    public TextView getTextNazwa() {
        return textNazwa;
    }

    public void setTextNazwa(TextView textNazwa) {
        this.textNazwa = textNazwa;
    }

    public TextView getTextLiczbaPartii() {
        return textLiczbaPartii;
    }

    public void setTextLiczbaPartii(TextView textLiczbaPartii) {
        this.textLiczbaPartii = textLiczbaPartii;
    }

    public TextView getTextLiczbaWygranych() {
        return textLiczbaWygranych;
    }

    public void setTextLiczbaWygranych(TextView textLiczbaWygranych) {
        this.textLiczbaWygranych = textLiczbaWygranych;
    }

    public TextView getTextProcentWygranych() {
        return textProcentWygranych;
    }

    public void setTextProcentWygranych(TextView textProcentWygranych) {
        this.textProcentWygranych = textProcentWygranych;
    }
}
