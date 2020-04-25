package com.example.aplikacjadlagracza.ui.oAplikacji;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OAplikacjiViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OAplikacjiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("\n \n \n Aplikacja dla gracza została stworzona z myślą o osobach lubiących grać w planszówki. " +
                "Dzięki niej w łatwy sposób można zapisać wynik danej rozgrywki (przegrana lub wygrana), " +
                "a także zobaczyć jak często wygrywamy w daną grę. " +
                "Dodatkowo dla gier, których jesteśmy właścicielami możemy sprawdzić ile kosztowała " +
                "nas pojedyncza rozgrywka danej gry. " +
                "W ten sposób widzimy jak bardzo opłacał się jej zakup.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}