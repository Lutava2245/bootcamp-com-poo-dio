package model;

public class Conquista {
    private String nome;
    private String linguagem;
    
    public Conquista(String nome, String linguagem) {
        this.nome = nome;
        this.linguagem = linguagem;
    }

    public String getNome() {
        return nome;
    }

    public String getLinguagem() {
        return linguagem;
    }

    @Override
    public String toString() {
        return linguagem + " - " + nome;
    }
}
