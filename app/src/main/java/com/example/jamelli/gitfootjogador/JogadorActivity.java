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
import android.view.MenuItem;
import android.widget.Toast;

import com.example.jamelli.gitfootjogador.fragment.FragmentCadastro;
import com.example.jamelli.gitfootjogador.fragment.FragmentInicio;
import com.example.jamelli.gitfootjogador.fragment.FragmentMostrar;
import com.firebase.ui.auth.AuthUI;

public class JogadorActivity extends AppCompatActivity {
    DrawerLayout drawer;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogador);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content, new FragmentInicio()).commit();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int idItem = menuItem.getItemId();
                Fragment frags = null;

                switch (idItem){
                    case R.id.nav_first_fragment:
                        frags = new FragmentInicio();
                        drawer.closeDrawer(GravityCompat.START);
                        //Toast.makeText(JogadorActivity.this, "ID:"+idItem, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_second_fragment:
                        frags = new FragmentCadastro();
                        drawer.closeDrawer(GravityCompat.START);
                        //Toast.makeText(JogadorActivity.this, "ID:"+idItem, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_third_fragment:
                        frags = new FragmentMostrar();
                        drawer.closeDrawer(GravityCompat.START);
                        //Toast.makeText(JogadorActivity.this, "ID:"+idItem, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_fourth_fragment:
                        frags = new FragmentCadastro();
                        drawer.closeDrawer(GravityCompat.START);
                        //Toast.makeText(JogadorActivity.this, "ID:"+idItem, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_fifth_fragment:
                        frags = new FragmentMostrar();
                        drawer.closeDrawer(GravityCompat.START);
                        //Toast.makeText(JogadorActivity.this, "ID:"+idItem, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_sixth_fragment:
                        frags = new FragmentMostrar();
                        drawer.closeDrawer(GravityCompat.START);
                        //Toast.makeText(JogadorActivity.this, "ID:"+idItem, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_sair:
                        drawer.closeDrawer(GravityCompat.START);
                        AuthUI.getInstance().signOut(JogadorActivity.this);
                        //Toast.makeText(JogadorActivity.this, "ID:"+idItem, Toast.LENGTH_SHORT).show();
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
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
