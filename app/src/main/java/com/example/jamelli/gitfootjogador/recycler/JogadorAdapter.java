package com.example.jamelli.gitfootjogador.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.jamelli.gitfootjogador.R;
import com.example.jamelli.gitfootjogador.modelo.Jogador;
import com.example.jamelli.gitfootjogador.util.GlideUtil;

import java.util.List;

public class JogadorAdapter extends RecyclerView.Adapter{
    Context context;
    List<Jogador> jogadores;
    public JogadorAdapter(Context c,List<Jogador> j){

        this.context = c;
        this.jogadores = j;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_jogador, parent, false);
        JogadorViewHolder holder = new JogadorViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final JogadorViewHolder jholder = (JogadorViewHolder) holder;
        final Jogador jchoise = jogadores.get(position);
        boolean photo = jchoise.getPhotoUrl() != null;
        if(photo){
            jholder.photoImageView.setVisibility(View.VISIBLE);
            GlideUtil.loadProfileIcon(jchoise.getPhotoUrl(),jholder.photoImageView);
        }else{
            jholder.photoImageView.setVisibility(View.GONE);
        }
        jholder.emailTextView.setText(jchoise.getEmail());
        jholder.nomeTextView.setText(jchoise.getNome());
        jholder.posicaoTextView.setText(jchoise.getPosicao());
        if(jchoise.getPe_melhor().toLowerCase().equals("direito")){
            jholder.peTextView.setText("destro");
        }else if(jchoise.getPe_melhor().toLowerCase().equals("esquerdo")){
            jholder.peTextView.setText("canhoto");
        }else{
            jholder.peTextView.setText("ambidestro");
        }
        jholder.psTextView.setText("Pretenção salarial "+String.valueOf(jchoise.getPretencao_salarial()));
        jholder.pcTextView.setText("Pretenção Contratual "+String.valueOf(jchoise.getPretencao_contratual()));
        //frutaholder.textViewNome.setText(frutaescolhida.getNome());
        //frutaholder.img.setImageResource(frutaescolhida.getImg());
    }

    @Override
    public int getItemCount() {
        return jogadores == null ? 0 : jogadores.size();
    }
}
