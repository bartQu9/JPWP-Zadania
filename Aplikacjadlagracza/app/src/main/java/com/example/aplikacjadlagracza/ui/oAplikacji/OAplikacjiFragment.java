package com.example.aplikacjadlagracza.ui.oAplikacji;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.aplikacjadlagracza.R;

public class OAplikacjiFragment extends Fragment {

    private OAplikacjiViewModel OAplikacjiViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        OAplikacjiViewModel =
                ViewModelProviders.of(this).get(OAplikacjiViewModel.class);
        View root = inflater.inflate(R.layout.fragment_oaplikacji, container, false);
        final TextView textView = root.findViewById(R.id.text_oAplikacji);
        OAplikacjiViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}