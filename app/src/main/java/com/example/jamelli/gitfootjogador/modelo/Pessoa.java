package com.example.jamelli.gitfootjogador.modelo;

public class Pessoa {
    private String photoUrl;
    private String email;
    private String nome;

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa() {
    }

    public Pessoa(String photoUrl, String email, String nome) {
        this.photoUrl = photoUrl;
        this.email = email;
        this.nome = nome;
    }
}
