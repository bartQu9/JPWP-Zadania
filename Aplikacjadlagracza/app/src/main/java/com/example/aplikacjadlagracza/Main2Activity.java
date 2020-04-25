package com.example.aplikacjadlagracza;

import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements MojaGraDialog.mojaGraDialogListener, GraDialog.graDialogListener, DodajPartieDialog.dodajPartieDialogListener{

    private AppBarConfiguration mAppBarConfiguration;
    private DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDb = new DatabaseHelper(this);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_mojeGry, R.id.nav_gry, R.id.nav_dodajNowaGre,
                R.id.nav_oAplikacji)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void applyTexts(double cena, String nazwa) {
        boolean dodano = myDb.dodajMojaGre(nazwa, cena);
        if (dodano){
            Toast.makeText(this, "Dodano moją grę", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Nie dodano mojej gry", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void applyTexts(String nazwa) {
        boolean dodano = myDb.dodajGre(nazwa);
        if (dodano){
            Toast.makeText(this, "Dodano grę", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Nie dodano gry", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void applyTexts(GraMoja graMoja, boolean wygrana) {
        boolean dodano = myDb.dodajPartie(graMoja, wygrana);
        if (dodano){
            Toast.makeText(this, "Dodano partię. Wejdź ponownie w Moje gry, żeby zobaczyć nowe statystyki.", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Nie dodano partii", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void applyTexts(Gra gra, boolean wygrana) {
        boolean dodano = myDb.dodajPartie(gra, wygrana);
        if (dodano){
            Toast.makeText(this, "Dodano partię. Wejdź ponownie w Gry, żeby zobaczyć nowe statystki.", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Nie dodano partii", Toast.LENGTH_LONG).show();
        }
    }


}
