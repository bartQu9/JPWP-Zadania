package com.example.aplikacjadlagracza;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.example.aplikacjadlagracza.ui.mojeGry.MojeGryAdapter;
import com.example.aplikacjadlagracza.ui.mojeGry.MojeGryHolder;

public class DodajPartieDialog extends AppCompatDialogFragment {
    private RadioGroup radioGroup;
    private RadioButton wygranaRadioButton;
    private RadioButton przegranaRadioButton;
    private dodajPartieDialogListener listener;
    private TextView textLiczbaPartii;
    private DatabaseHelper myDb;
    private GraMoja graMoja;
    private Gra gra;
    private boolean wygrana;


    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDb = new DatabaseHelper(getActivity());
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.dodaj_partie, null);
        radioGroup = view.findViewById(R.id.radioGroup);
        wygranaRadioButton = view.findViewById(R.id.wygranaRadioButton);
        przegranaRadioButton = view.findViewById(R.id.przegranaRadioButton);
        builder.setView(view)
                .setTitle("Dodaj partię")
                .setNegativeButton("Wyjdź", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Dodaj", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int radioButtonId = radioGroup.getCheckedRadioButtonId();
                        RadioButton wybranyRadioButton = view.findViewById(radioButtonId);

                        if (wybranyRadioButton == wygranaRadioButton){
                            wygrana = true;
                        } else if (wybranyRadioButton == przegranaRadioButton){
                            wygrana = false;
                        }

                        if (graMoja != null) {
                            listener.applyTexts(graMoja, wygrana);
                        }
                        else if (gra != null){
                            listener.applyTexts(gra, wygrana);
                        }
                    }
                });

        return builder.create();

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (dodajPartieDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+"must implement dodajPartieDialogListener");
        }
    }

    public GraMoja getGraMoja() {
        return graMoja;
    }

    public void setGraMoja(GraMoja graMoja) {
        this.graMoja = graMoja;
    }

    public Gra getGra() {
        return gra;
    }

    public void setGra(Gra gra) {
        this.gra = gra;
    }

    public boolean isWygrana() {
        return wygrana;
    }

    public void setWygrana(boolean wygrana) {
        this.wygrana = wygrana;
    }

    public interface dodajPartieDialogListener{
        void applyTexts(GraMoja graMoja, boolean wygrana);
        void applyTexts(Gra gra, boolean wygrana);
    }
}
