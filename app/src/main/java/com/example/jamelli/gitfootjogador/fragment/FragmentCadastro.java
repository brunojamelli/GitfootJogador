package com.example.jamelli.gitfootjogador.fragment;

import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.jamelli.gitfootjogador.R;
import com.example.jamelli.gitfootjogador.modelo.Jogador;
import com.example.jamelli.gitfootjogador.util.FirebaseUtil;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FragmentCadastro extends Fragment {
    private Button btn_cad;
    private FirebaseDatabase fdatabase;
    private DatabaseReference dataref;
    private EditText et_pe,et_pisicao,et_ps,et_pc;
    private boolean existe;
    public FragmentCadastro() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle b) {
        View v = inflater.inflate(R.layout.fragment_cadastro, container, false);
        btn_cad = v.findViewById(R.id.btnCadJogador);
        initViewObjects(v);
        initDBandAuth();



        return v;
    }

    private void initViewObjects(View v){
        //et_email = v.findViewById(R.id.etEmail);
        et_pe = v.findViewById(R.id.etPe);
        et_pisicao = v.findViewById(R.id.etPos);
        et_ps = v.findViewById(R.id.etPS);
        et_pc = v.findViewById(R.id.etPC);
    }

    private void initDBandAuth(){
        dataref = FirebaseUtil.getBaseRefJogador();
    }

    public void clearFields(){
        et_pe.setText("");
        et_pisicao.setText("");
        et_ps.setText("");
        et_pc.setText("");
    }

    public boolean checkExistingPlayer(String email){
        existe = false;
        dataref.orderByChild("email").equalTo(email).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.i("achou","achou -> "+dataSnapshot.toString());
                existe = true;
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) { }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) { }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) { }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });

        return existe;
    }

    public void clickCadJogador(View v){
        boolean teste = checkExistingPlayer("teste1@gmail.com");
        String email ="teste2@gmail.com";
        String nome = "teste";
        String foto ="";

        Jogador j = new Jogador(
                foto,
                email,
                nome,
                et_pe.getText().toString(),
                et_pisicao.getText().toString(),
                Double.parseDouble(et_ps.getText().toString()),
                Double.parseDouble(et_pc.getText().toString())
        );
        dataref.push().setValue(j);

        clearFields();
    }
}
