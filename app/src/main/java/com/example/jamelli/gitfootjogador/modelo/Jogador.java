package com.example.jamelli.gitfootjogador.modelo;

public class Jogador {
    private String photoUrl;
    private String email;
    private String pe_melhor;
    private String posicao;
    private double pretencao_salarial;
    private double pretencao_contratual;

    public Jogador() {
    }

    public Jogador(String photoUrl, String email, String pe_melhor, String posicao, double pretencao_salarial, double pretencao_contratual) {
        this.photoUrl = photoUrl;
        this.email = email;
        this.pe_melhor = pe_melhor;
        this.posicao = posicao;
        this.pretencao_salarial = pretencao_salarial;
        this.pretencao_contratual = pretencao_contratual;
    }

    public Jogador(String email, String pe_melhor, String posicao, double pretencao_salarial, double pretencao_contratual) {
        this.email = email;
        this.pe_melhor = pe_melhor;
        this.posicao = posicao;
        this.pretencao_salarial = pretencao_salarial;
        this.pretencao_contratual = pretencao_contratual;
    }

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

    public String getPe_melhor() {
        return pe_melhor;
    }

    public void setPe_melhor(String pe_melhor) {
        this.pe_melhor = pe_melhor;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public double getPretencao_salarial() {
        return pretencao_salarial;
    }

    public void setPretencao_salarial(double pretencao_salarial) {
        this.pretencao_salarial = pretencao_salarial;
    }

    public double getPretencao_contratual() {
        return pretencao_contratual;
    }

    public void setPretencao_contratual(double pretencao_contratual) {
        this.pretencao_contratual = pretencao_contratual;
    }
}
