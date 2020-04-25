package com.example.aplikacjadlagracza.ui.mojeGry;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikacjadlagracza.R;

public class MojeGryHolder extends RecyclerView.ViewHolder {

    private TextView textNazwa;
    private TextView textLiczbaPartii;
    private TextView textLiczbaWygranych;
    private TextView textProcentWygranych;
    private TextView textCena;
    private TextView textCenaPojedynczejPartii;
    private ImageButton dodajPartieButton;

    public MojeGryHolder(@NonNull View itemView) {
        super(itemView);
        this.textNazwa = (TextView) itemView.findViewById(R.id.textNazwa);
        this.textLiczbaPartii = (TextView) itemView.findViewById(R.id.textLiczbaPartii);
        this.textLiczbaWygranych = (TextView) itemView.findViewById(R.id.textLiczbaWygranych);
        this.textProcentWygranych = (TextView) itemView.findViewById(R.id.textProcentWygranych);
        this.textCena = (TextView) itemView.findViewById(R.id.textCena);
        this.textCenaPojedynczejPartii = (TextView) itemView.findViewById(R.id.textCenaPojedynczejPartii);
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

    public TextView getTextCena() {
        return textCena;
    }

    public void setTextCena(TextView textCena) {
        this.textCena = textCena;
    }

    public TextView getTextCenaPojedynczejPartii() {
        return textCenaPojedynczejPartii;
    }

    public void setTextCenaPojedynczejPartii(TextView textCenaPojedynczejPartii) {
        this.textCenaPojedynczejPartii = textCenaPojedynczejPartii;
    }
}
