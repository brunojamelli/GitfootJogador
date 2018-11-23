package com.example.jamelli.gitfootjogador.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jamelli.gitfootjogador.R;

public class JogadorAdapter extends RecyclerView.Adapter{
    Context context;
    public JogadorAdapter(Context c){
        this.context = c;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_jogador, parent, false);
        JogadorViewHolder holder = new JogadorViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        JogadorViewHolder frutaholder = (JogadorViewHolder) holder;
        //Fruta frutaescolhida = listaFrutas.get(position);
        //frutaholder.textViewNome.setText(frutaescolhida.getNome());
        //frutaholder.img.setImageResource(frutaescolhida.getImg());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
