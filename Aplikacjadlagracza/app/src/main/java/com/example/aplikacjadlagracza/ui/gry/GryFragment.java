package com.example.aplikacjadlagracza.ui.gry;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikacjadlagracza.DatabaseHelper;
import com.example.aplikacjadlagracza.Gra;
import com.example.aplikacjadlagracza.R;

import java.util.ArrayList;

public class GryFragment extends Fragment {

    private GryViewModel gryViewModel;
    private RecyclerView recyclerView;
    private DatabaseHelper myDb;
    private ArrayList<Gra> listaGier;
    private GryAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        gryViewModel =
                ViewModelProviders.of(this).get(GryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gry, container, false);
        //pobranie danych z bazy danych
        myDb = new DatabaseHelper(getActivity());
        Cursor cursor = myDb.getGry();
        if(cursor.getCount() == 0) {
            final TextView textView = root.findViewById(R.id.text_gry);
            gryViewModel.getText().observe(this, new Observer<String>() {
                @Override
                public void onChanged(@Nullable String s) {
                    textView.setText(s);
                }
            });
        } else {
            listaGier = new ArrayList<>();
            while (cursor.moveToNext()){
                int id = cursor.getInt(0);
                String nazwa = cursor.getString(1);
                int liczbaPartii = cursor.getInt(2);
                int liczbaWygranych = cursor.getInt(3);
                double procentWygranych = cursor.getDouble(4);
                Gra gra = new Gra(id, nazwa, liczbaPartii, liczbaWygranych, procentWygranych);
                listaGier.add(gra);
            }
            recyclerView = (RecyclerView) root.findViewById(R.id.gryList);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            adapter = new GryAdapter(getActivity(), listaGier);
            recyclerView.setAdapter(adapter);
        }
        return root;
    }
}