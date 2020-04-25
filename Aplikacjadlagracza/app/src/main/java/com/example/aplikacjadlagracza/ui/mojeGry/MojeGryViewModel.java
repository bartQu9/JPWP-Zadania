package com.example.aplikacjadlagracza.ui.mojeGry;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.aplikacjadlagracza.DatabaseHelper;
import com.example.aplikacjadlagracza.GraMoja;

import java.util.ArrayList;
import java.util.List;

public class MojeGryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MojeGryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Nie dodano jeszcze żadnej gry");
    }

    public LiveData<String> getText() {
        return mText;
    }

}