package model;

import java.util.LinkedHashSet;
import java.util.Set;

public class Dev {
    private int xp = 0;
    private int id;
    private String nome;
    private Set<Bootcamp> bootcampsInscrito = new LinkedHashSet<>();
    private Set<Bootcamp> bootcampsConcluidos = new LinkedHashSet<>();
    private Set<Conquista> conquistas = new LinkedHashSet<>();
    
    public Dev(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public int getXp() {
        return xp;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Set<Conquista> getConquistas() {
        return conquistas;
    }

    public Set<Bootcamp> getBootcampsInscrito() {
        return bootcampsInscrito;
    }

    public Set<Bootcamp> getBootcampsConcluidos() {
        return bootcampsConcluidos;
    }
    
    public void inscrever(Bootcamp bootcamp_a_matricular) {
        Bootcamp bootcamp = new Bootcamp(bootcamp_a_matricular);
        this.bootcampsInscrito.add(bootcamp);
        System.out.println("Cadastrado no Bootcamp " + bootcamp.getNome() + ".");
    }

    public void ganharXP(int xp) {
        this.xp += xp;
    }

    public void ganharConquista(Conquista conquista) {
        this.conquistas.add(conquista);
    }

    @Override
    public String toString() {
        String bootcampsIncritoString = "";
        String bootcampsConcluidosString = "";
        String conquistaString = "";

        if (bootcampsInscrito.isEmpty()) {
            bootcampsIncritoString += "\nNenhum";
        } else {
            for (Bootcamp bootcamp : bootcampsInscrito) {
                bootcampsIncritoString += ("\n" + bootcamp);
            }  
        }

        if (bootcampsConcluidos.isEmpty()) {
            bootcampsConcluidosString += "\nNenhum";
        } else {
            for (Bootcamp bootcamp : bootcampsConcluidos) {
                bootcampsConcluidosString += ("\n" + bootcamp);
            }
        }

        if (conquistas.isEmpty()) {
            conquistaString += "\nNenhuma";
        } else {
            for (Conquista conquista : conquistas) {
                conquistaString += ("\n" + conquista);
            }
        }

        return "=========Usuário========\n"
             + "Nome: " + nome + " - Nº" + id + "\n"
             + "========================\n"
             + "Bootcamps Incritos:" + bootcampsIncritoString + "\n"
             + "Bootcamps Concluidos:" + bootcampsConcluidosString + "\n"
             + "========================\n"
             + "Conquistas:" + conquistaString + "\n";
    }
}
