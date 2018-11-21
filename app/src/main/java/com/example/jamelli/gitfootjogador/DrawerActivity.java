package com.example.jamelli.gitfootjogador;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;
import android.support.v4.app.Fragment;

import com.example.jamelli.gitfootjogador.fragment.FragmentCadastro;
import com.example.jamelli.gitfootjogador.fragment.FragmentInicio;
import com.example.jamelli.gitfootjogador.fragment.FragmentMostrar;

public class DrawerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        BottomNavigationView bottomnav = findViewById(R.id.bottom_navigation);
        //Desativar animação
        //BottomNavigationViewHelper.disableShiftMode(bottomnav);
        bottomnav.setOnNavigationItemSelectedListener(navListenner);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentInicio()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListenner = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragmentSelecionado = null;

            switch (item.getItemId()){
                case R.id.nav_first_fragment:
                    fragmentSelecionado = new FragmentInicio();
                    break;
                case R.id.nav_second_fragment:
                    fragmentSelecionado = new FragmentCadastro();
                    break;

                case R.id.nav_third_fragment:
                    fragmentSelecionado = new FragmentMostrar();
                    break;

            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentSelecionado).commit();
            return true;
        }
    };

}
