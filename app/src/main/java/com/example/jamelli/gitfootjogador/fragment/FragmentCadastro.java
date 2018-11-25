package com.example.jamelli.gitfootjogador.fragment;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.jamelli.gitfootjogador.R;
import com.example.jamelli.gitfootjogador.modelo.Jogador;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FragmentCadastro extends Fragment {
    private Button btn_cad;
    private FirebaseDatabase fdatabase;
    private DatabaseReference dataref;
    private EditText et_pe,et_pisicao,et_ps,et_pc;
    public FragmentCadastro() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle b) {
        View v = inflater.inflate(R.layout.fragment_cadastro, container, false);
        btn_cad = v.findViewById(R.id.btnCadJogador);
        initViewObjects(v);
        initDBandAuth();
        btn_cad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email ="teste@gmail.com";
                String nome = "teste";
                Jogador j = new Jogador(
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
        });

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
        fdatabase = FirebaseDatabase.getInstance();
        dataref = fdatabase.getReference().child("jogador");
    }

    public void clearFields(){
        et_pe.setText("");
        et_pisicao.setText("");
        et_ps.setText("");
        et_pc.setText("");
    }
}
