package com.example.aplikacjadlagracza.ui.dodajNowaGre;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.aplikacjadlagracza.DatabaseHelper;
import com.example.aplikacjadlagracza.GraDialog;
import com.example.aplikacjadlagracza.MojaGraDialog;
import com.example.aplikacjadlagracza.R;


public class DodajNowaGreFragment extends DialogFragment {
    private EditText nazwaMojejGry;
    private EditText cenaMojejGry;
    private MojaGraDialog.mojaGraDialogListener listener;
    private Button mojaGraBtn;
    private Button graBtn;
    private DatabaseHelper myDb;
    private DodajNowaGreViewModel dodajNowaGreViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dodajNowaGreViewModel =
                ViewModelProviders.of(this).get(DodajNowaGreViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_dodajnowagre, container, false);
        final TextView textView = root.findViewById(R.id.text_dodajNowaGre);
        myDb = new DatabaseHelper(getActivity());
        mojaGraBtn = (Button) root.findViewById(R.id.dodajMojaGreDialog);
        mojaGraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();

            }
        });

        graBtn = (Button) root.findViewById(R.id.dodajGreDialog);
        graBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open2Dialog();

            }
        });
        dodajNowaGreViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;

    }

    public void openDialog() {
        MojaGraDialog mojaGraDialog = new MojaGraDialog();
        mojaGraDialog.show(getActivity().getSupportFragmentManager(), "example dialog");
    }
    public void open2Dialog() {
        GraDialog graDialog = new GraDialog();
        graDialog.show(getActivity().getSupportFragmentManager(), "example dialog");
    }

}