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

//wyskakujace okienko -> dodaj grę
public class GraDialog extends AppCompatDialogFragment {
    private EditText nazwaGry;
    private graDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.gra_dialog, null);
        builder.setView(view)
                .setTitle("Dodaj grę")
                .setNegativeButton("Wyjdź", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Dodaj", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String nazwa = nazwaGry.getText().toString();
                        listener.applyTexts(nazwa);

                    }
                });

        nazwaGry = view.findViewById(R.id.nazwaGry);
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (graDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+"must implement GraDialogListener");
        }
    }


    public interface graDialogListener{
        void applyTexts(String nazwa);
    }
}
