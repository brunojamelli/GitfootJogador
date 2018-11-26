package com.example.jamelli.gitfootjogador.fragment;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jamelli.gitfootjogador.R;
import com.example.jamelli.gitfootjogador.util.FirebaseUtil;

import de.hdodenhof.circleimageview.CircleImageView;

public class FragmentInicio extends Fragment{
    private TextView txInicio;
    private CircleImageView profileFoto;
    private String nome;
    private String photoUrl;
    public static String uid;
    public FragmentInicio() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle b) {
        View v = inflater.inflate(R.layout.fragment_inicio, container, false);
        txInicio = v.findViewById(R.id.tv_bv);
        profileFoto = v.findViewById(R.id.profile_image);
        nome = FirebaseUtil.getJogador().getNome();
        photoUrl = FirebaseUtil.getJogador().getPhotoUrl();
        txInicio.setText(R.string.bem_vindo +""+nome);
        Glide.with(profileFoto.getContext())
                .load(photoUrl)
                .into(profileFoto);

        return v;
    }
}
