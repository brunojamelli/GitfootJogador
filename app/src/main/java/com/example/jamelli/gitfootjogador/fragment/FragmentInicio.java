package com.example.jamelli.gitfootjogador.fragment;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jamelli.gitfootjogador.R;
import com.example.jamelli.gitfootjogador.util.FirebaseUtil;
import com.example.jamelli.gitfootjogador.util.GlideUtil;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import de.hdodenhof.circleimageview.CircleImageView;

public class FragmentInicio extends Fragment{
    private TextView txInicio;
    private String nome;
    private String photoUrl;
    public static String uid;
    public FragmentInicio() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle b) {
        View v = inflater.inflate(R.layout.fragment_inicio, container, false);
        txInicio = v.findViewById(R.id.tv_bv);
        txInicio.setText("Opa");


        return v;
    }
}
