package com.example.jamelli.gitfootjogador.fragment;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jamelli.gitfootjogador.R;
import com.example.jamelli.gitfootjogador.modelo.Jogador;
import com.example.jamelli.gitfootjogador.recycler.JogadorAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentMostrar extends Fragment{
    private List<Jogador> jogadores;
    private RecyclerView rv;
    private JogadorAdapter adapter;
    public FragmentMostrar() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle b) {
        View v = inflater.inflate(R.layout.fragment_mostrar, container, false);
        initViewObjects(v);


        return v;
    }
    public void initViewObjects(View v){
        rv = v.findViewById(R.id.screenPlayers);
        jogadores = new ArrayList<>();
        adapter = new JogadorAdapter(getContext(),jogadores);
        rv.setAdapter(adapter);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        //((LinearLayoutManager) layout).setStackFromEnd(true);
        //((LinearLayoutManager) layout).setReverseLayout(false);
        rv.setLayoutManager(layout);
    }
}
