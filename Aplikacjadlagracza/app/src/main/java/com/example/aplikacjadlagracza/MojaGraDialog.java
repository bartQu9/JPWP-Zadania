package com.example.aplikacjadlagracza;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.example.aplikacjadlagracza.ui.dodajNowaGre.DodajNowaGreFragment;

//wyskakujace okienko -> dodaj moją grę
public class MojaGraDialog extends AppCompatDialogFragment {
     private  EditText nazwaMojejGry;
     private EditText cenaMojejGry;
     private mojaGraDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.moja_gra, null);
        builder.setView(view)
                .setTitle("Dodaj swoją grę")
                .setNegativeButton("Wyjdź", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Dodaj", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String cena = cenaMojejGry.getText().toString();
                        String nazwa = nazwaMojejGry.getText().toString();
                        listener.applyTexts(Double.parseDouble(cena), nazwa);

                    }
                });

        nazwaMojejGry = view.findViewById(R.id.nazwaMojejGry);
        cenaMojejGry = view.findViewById(R.id.cenaMojejGry);
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (mojaGraDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+"must implement mojaGraDialogListener");
        }
    }


    public interface mojaGraDialogListener{
        void applyTexts(double cena, String nazwa);
    }
}
