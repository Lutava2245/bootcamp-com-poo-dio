package model;

import java.time.LocalDate;

public class Mentoria extends Conteudo {
    private String titulo;
    private String linguagem;
    private String mentor;
    private Conquista conquista;
    private LocalDate data = LocalDate.now();

    public Mentoria(String titulo, String linguagem, String mentor) {
        this.titulo = titulo;
        this.linguagem = linguagem;
        this.mentor = mentor;
        this.conquista = new Conquista(titulo, linguagem);
    }

    public Mentoria(Mentoria mentoria) {
        this.titulo = mentoria.titulo;
        this.linguagem = mentoria.linguagem;
        this.mentor = mentoria.mentor;
        this.conquista = mentoria.conquista;
        this.data = mentoria.data;
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

    public LocalDate getData() {
        return data;
    }

    @Override
    protected int gerarXP() {
        return XP_PADRAO * 3;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + this.titulo;
    }

}
