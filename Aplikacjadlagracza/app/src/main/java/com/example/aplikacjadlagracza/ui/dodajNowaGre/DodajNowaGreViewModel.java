package com.example.aplikacjadlagracza.ui.dodajNowaGre;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DodajNowaGreViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DodajNowaGreViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("\n \n \n Naciśnij 'MOJA GRA', jeżeli chcesz dodać grę, której jesteś właścicielem.\n" +
                "Naciśnij 'GRA', jeżeli chcesz dodać grę, której nie posiadasz (np. grałeś/aś w nią u znajomych). \n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}