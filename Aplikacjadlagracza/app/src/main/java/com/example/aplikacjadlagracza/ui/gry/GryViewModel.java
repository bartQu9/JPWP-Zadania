package com.example.aplikacjadlagracza.ui.gry;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Nie dodano jeszcze żadnej gry");
    }

    public LiveData<String> getText() {
        return mText;
    }
}