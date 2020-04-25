package com.example.aplikacjadlagracza.ui.mojeGry;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikacjadlagracza.DatabaseHelper;
import com.example.aplikacjadlagracza.DodajPartieDialog;
import com.example.aplikacjadlagracza.GraMoja;
import com.example.aplikacjadlagracza.R;

import java.util.ArrayList;

public class MojeGryFragment extends Fragment {

    private MojeGryViewModel mojeGryViewModel;
    private RecyclerView recyclerView;
    private DatabaseHelper myDb;
    private ArrayList<GraMoja> listaMoichGier;
    private MojeGryAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mojeGryViewModel =
                ViewModelProviders.of(this).get(MojeGryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_mojegry, container, false);
        //pobranie danych z bazy danych
        myDb = new DatabaseHelper(getActivity());
        Cursor cursor = myDb.getMojeGry();
        if(cursor.getCount() == 0) {
            final TextView textView = root.findViewById(R.id.text_mojeGry);
            mojeGryViewModel.getText().observe(this, new Observer<String>() {
                @Override
                public void onChanged(@Nullable String s) {
                    textView.setText(s);
                }
            });
        } else {
            listaMoichGier = new ArrayList<>();
            while (cursor.moveToNext()){
                int id = cursor.getInt(0);
                String nazwa = cursor.getString(1);
                int liczbaPartii = cursor.getInt(2);
                int liczbaWygranych = cursor.getInt(3);
                double procentWygranych = cursor.getDouble(4);
                double cena = cursor.getDouble(5);
                double cenaJednejPartii = cursor.getDouble(6);
                GraMoja graMoja = new GraMoja(id, nazwa, liczbaPartii, liczbaWygranych, procentWygranych, cena, cenaJednejPartii);
                listaMoichGier.add(graMoja);
            }
            recyclerView = (RecyclerView) root.findViewById(R.id.mojeGryList);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            adapter = new MojeGryAdapter(getActivity(), listaMoichGier);
            recyclerView.setAdapter(adapter);
        }
        return root;
    }
}