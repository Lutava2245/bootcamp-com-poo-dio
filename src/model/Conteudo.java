package model;

public abstract class Conteudo {
    protected static final int XP_PADRAO = 10;
    private String titulo;
    private String mentor;
    private Conquista conquista;
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getMentor() {
        return mentor;
    }

    public Conquista getConquista() {
        return conquista;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + this.titulo;
    }

    protected abstract int gerarXP();
}
