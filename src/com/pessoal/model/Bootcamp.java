package com.pessoal.model;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Deque;

public class Bootcamp {
    private String nome;
    private Conquista conquista;
    private LocalDate data_inicio = LocalDate.now();
    private LocalDate data_fim = data_inicio.plusMonths(4);
    private Deque<Conteudo> conteudos = new ArrayDeque<>();
    
    public Bootcamp(String nome, Conquista conquista) {
        this.nome = nome;
        this.conquista = conquista;
    }

    public Bootcamp(Bootcamp bootcamp) {
        for (Conteudo conteudo1 : bootcamp.conteudos) {
            Conteudo conteudo = null;

            if (conteudo1.getClass().getSimpleName().equals("Curso")) {
                conteudo = new Curso((Curso) conteudo1);
            } else {
                conteudo = new Mentoria((Mentoria) conteudo1);
            }

            this.conteudos.add(conteudo);
        }

        this.nome = bootcamp.nome;
        this.conquista = bootcamp.conquista;
        this.data_inicio = bootcamp.data_inicio;
        this.data_fim = bootcamp.data_fim;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getData_inicio() {
        return data_inicio;
    }

    public LocalDate getData_fim() {
        return data_fim;
    }

    public Deque<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(Deque<Conteudo> lista_conteudos) {
        this.conteudos = lista_conteudos;
    }

    public void concluirConteudo(Dev desenvolvedor, Conteudo conteudo) {
        desenvolvedor.ganharXP(conteudo.gerarXP());
        desenvolvedor.ganharConquista(conteudo.getConquista());
        System.out.println("Você concluiu o(a) " + conteudo + "! +" + conteudo.gerarXP() + " de XP.");

        if (this.conteudos.isEmpty()) {
            desenvolvedor.ganharConquista(this.conquista);
            desenvolvedor.getBootcampsConcluidos().add(this);
            desenvolvedor.getBootcampsInscrito().remove(this);
            System.out.println("Parabéns, você concluiu o Bootcamp " + nome + "!");
        }
    }

    @Override
    public String toString() {
        return "Bootcamp " + nome + " - Data limite: " + data_fim;
    }
}
