package com.pessoal.model;

public class Curso extends Conteudo{
    private int carga_horaria;

    public Curso() {
    }

    public Curso(int carga_horaria, String titulo, String linguagem, String mentor) {
        super(titulo, mentor, linguagem);
        this.carga_horaria = carga_horaria;
    }

    public Curso(Curso curso) {
        super(curso.getTitulo(), curso.getMentor(), curso.getConquista().getLinguagem());
        this.carga_horaria = curso.carga_horaria;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    @Override
    public int gerarXP() {
        return XP_PADRAO * carga_horaria;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + this.getTitulo();
    }

}
