package com.example.jamelli.gitfootjogador.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jamelli.gitfootjogador.R;

public class FragmentSobre extends Fragment {
    public FragmentSobre(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle b) {
        View v = inflater.inflate(R.layout.fragment_sobre, container, false);

        TextView t2 = v.findViewById(R.id.tv_abaout);
        t2.setMovementMethod(LinkMovementMethod.getInstance());

        return v;
    }
}
