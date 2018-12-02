package com.example.jamelli.gitfootjogador;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jamelli.gitfootjogador.fragment.FragmentCadastro;
import com.example.jamelli.gitfootjogador.fragment.FragmentInicio;
import com.example.jamelli.gitfootjogador.fragment.FragmentLocalizacao;
import com.example.jamelli.gitfootjogador.fragment.FragmentMapeamento;
import com.example.jamelli.gitfootjogador.fragment.FragmentMostrar;
import com.example.jamelli.gitfootjogador.fragment.FragmentSobre;
import com.example.jamelli.gitfootjogador.util.FirebaseUtil;
import com.example.jamelli.gitfootjogador.util.GlideUtil;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseUser;

import de.hdodenhof.circleimageview.CircleImageView;

public class JogadorActivity extends AppCompatActivity {
    DrawerLayout drawer;
    NavigationView navigationView;
    TextView txtNome;
    TextView txtEmail;
    CircleImageView photo;
    String photoUrl,nome,email;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogador);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        txtNome = navigationView.getHeaderView(0).findViewById(R.id.tv_bv2);
        photo = navigationView.getHeaderView(0).findViewById(R.id.profile_image2);
        try{
            nome = FirebaseUtil.getJogador().getNome();
            photoUrl = FirebaseUtil.getJogador().getPhotoUrl();
            txtNome.setText(nome);
            GlideUtil.loadProfileIcon(photoUrl,photo);
        }catch (NullPointerException e){
            Log.i("deu bode",e.toString());
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content, new FragmentCadastro()).commit();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int idItem = menuItem.getItemId();
                Fragment frags = null;

                switch (idItem){
                    case R.id.nav_home_fragment:
                        frags = new FragmentInicio();
                        toolbar.setTitle("Inicio");
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_cadastro_fragment:
                        frags = new FragmentCadastro();
                        toolbar.setTitle("Adicionar Informações");
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_localizacao_fragment:
                        frags = new FragmentLocalizacao();
                        toolbar.setTitle("Enviar Localização");
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_mapeamento_fragment:
                        frags = new FragmentMapeamento();
                        toolbar.setTitle("Mapeando os olheiros");
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_abaout_fragment:
                        frags = new FragmentSobre();
                        toolbar.setTitle("Sobre");
                        drawer.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_sair:
                        drawer.closeDrawer(GravityCompat.START);
                        AuthUI.getInstance().signOut(JogadorActivity.this);
                        break;
                }
                if(idItem != R.id.nav_sair){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content, frags).commit();
                }

                return true;
            }
        });
    }


    @Override
    public void onBackPressed() {

    }
}
