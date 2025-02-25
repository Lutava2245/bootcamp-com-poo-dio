package com.pessoal.model;

public abstract class Conteudo {
    protected static final int XP_PADRAO = 10;
    private String titulo;
    private String mentor;
    private Conquista conquista;

    public Conteudo() {
    }

    public Conteudo(String titulo, String mentor, String linguagem) {
        this.titulo = titulo;
        this.mentor = mentor;
        this.conquista = new Conquista(mentor, linguagem);
    }

    public String getTitulo() {
        return titulo;
    }
    
    public String getMentor() {
        return mentor;
    }

    public Conquista getConquista() {
        return conquista;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public void setConquista(Conquista conquista) {
        this.conquista = conquista;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + this.titulo;
    }

    protected abstract int gerarXP();
}
