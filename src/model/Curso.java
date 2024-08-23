package model;

public class Curso extends Conteudo{
    private int carga_horaria;
    private String titulo;
    private String linguagem;
    private String mentor;
    private Conquista conquista;

    public Curso(int carga_horaria, String titulo, String linguagem, String mentor) {
        this.carga_horaria = carga_horaria;
        this.titulo = titulo;
        this.linguagem = linguagem;
        this.mentor = mentor;
        this.conquista = new Conquista(titulo, linguagem);
    }

    public Curso(Curso curso) {
        this.carga_horaria = curso.carga_horaria;
        this.titulo = curso.titulo;
        this.linguagem = curso.linguagem;
        this.mentor = curso.mentor;
        this.conquista = curso.conquista;
    }

    public String getTitulo() {
        return titulo;
    }
    
    public String getLinguagem() {
        return linguagem;
    }

    public String getMentor() {
        return mentor;
    }

    public Conquista getConquista() {
        return conquista;
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
        return this.getClass().getSimpleName() + " " + this.titulo;
    }

}
