package com.example.jamelli.gitfootjogador.fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jamelli.gitfootjogador.R;

public class FragmentLocalizacao extends Fragment{
    public FragmentLocalizacao(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle b) {
        View v = inflater.inflate(R.layout.fragment_localizar, container, false);

        return v;
    }
}
