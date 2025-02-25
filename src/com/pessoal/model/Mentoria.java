package com.pessoal.model;

import java.time.LocalDate;

public class Mentoria extends Conteudo {
    private LocalDate data = LocalDate.now();

    public Mentoria(String titulo, String linguagem, String mentor) {
        super(titulo, mentor, linguagem);
    }

    public Mentoria(Mentoria mentoria) {
        super(mentoria.getTitulo(), mentoria.getMentor(), mentoria.getConquista().getLinguagem());
        this.data = mentoria.data;
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
        return this.getClass().getSimpleName() + " " + this.getTitulo();
    }
}
