package com.pessoal;

import com.pessoal.model.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int id = 0;
    public static List<Dev> desenvolvedores = new ArrayList<>();
    public static List<Bootcamp> bootcamps = new ArrayList<>();
    public static Scanner scan = new Scanner(System.in);
    
    public static Dev criarDev() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        sc.close();

        Dev dev = new Dev(nome, id);
        desenvolvedores.add(dev);
        System.out.println("Aluno criado, Nº" + id);
        id++;
        return dev;
    }

    public static Dev getDev(int id) {
        for (Dev dev : desenvolvedores) {
            if (dev.getId() == id) {
                return dev;
            }
        }
        return null;
    }

    public static void criarBootcamp() {
        Deque<Conteudo> lista_conteudos = new ArrayDeque<>();
        boolean criacao = true;

        System.out.print("Nome do Bootcamp: ");
        String nome_bootcamp = scan.nextLine();
        System.out.print("Linguagem do conteúdo: ");
        String linguagem = scan.nextLine();

        do {
            System.out.println("Informações do conteúdo:");
            System.out.print("Tipo (curso/mentoria): ");
            String tipo = scan.nextLine();
            System.out.print("Título: ");
            String nome_conteudo = scan.nextLine();
            System.out.print("Professor: ");
            String mentor = scan.nextLine();

            Conteudo conteudo = tipo.equalsIgnoreCase("curso")
                                ? new Curso(2, nome_conteudo, linguagem, mentor)
                                : new Mentoria(nome_conteudo, linguagem, mentor);

            lista_conteudos.add(conteudo);

            System.out.println("Adicionar mais conteudos? (S/N)");
            String resposta = scan.nextLine();

            criacao = resposta.equalsIgnoreCase("s");
            System.out.println("================");
        } while (criacao);
        
        Conquista conquista = new Conquista(nome_bootcamp, linguagem);
        Bootcamp bootcamp = new Bootcamp(nome_bootcamp, conquista);
        bootcamp.setConteudos(lista_conteudos);
        bootcamps.add(bootcamp);
    }

    public static void main(String[] args) {
        boolean finalizar = false;
        criarBootcamp();
        criarBootcamp();
        criarBootcamp();

        Dev usuario = criarDev();

        do {
            int escolha;
            int contador;
            String menu = "";

            System.out.println("""
                    ==========MENU==========
                    1 - Criar Usuário
                    2 - Mudar Usuário
                    3 - Verificar Usuário
                    4 - Matricular Bootcamp
                    5 - Fazer aula
                    0 - Finalizar
                    ========================
                    """);
            escolha = scan.nextInt();

            switch (escolha) {
                case 1:
                    usuario = criarDev();
                    break;

                case 2:
                    System.out.print("Digite o id do usuário: ");
                    int id_a_procurar = scan.nextInt();
                    
                    Dev novo_usuario = getDev(id_a_procurar);

                    if (novo_usuario == null) {
                        System.out.println("Usuário não encontrado");
                    } else {
                        usuario = novo_usuario;
                        System.out.println("Usuário " + usuario.getNome() + " entrou.");
                    }
                    break;

                case 3:
                    System.out.println(usuario);
                    break;

                case 4:
                    menu = "Escolha um bootcamp:";
                    contador = 1;
                    for (Bootcamp bootcamp : bootcamps) {
                        menu += ("\n" + contador + " - " + bootcamp);
                        contador++;
                    }
                    menu += "\n0 - Cancelar inscrição\n";

                    System.out.println(menu);
                    escolha = scan.nextInt();

                    if (escolha != 0) {
                        boolean jaInscrito = false;

                        for (Bootcamp bootcamp : usuario.getBootcampsInscrito()) {
                            jaInscrito = bootcamp.getNome().equals(bootcamps.get(escolha-1).getNome());
                            if (jaInscrito) {
                                break;
                            }
                        }
                        if (jaInscrito) {
                            System.out.println("Usuário já inscrito no Bootcamp.");
                        } else {
                            usuario.inscrever(bootcamps.get(escolha-1));
                        }
                    }
                    break;

                case 5:
                    if (usuario.getBootcampsInscrito().isEmpty()) {       
                        System.out.println("Você não está inscrito em nenhum Bootcamp.");
                        break;
                    }

                    menu = "Escolha um bootcamp:";
                    contador = 0;
                    Bootcamp[] bootcampsInscrito
                            = new Bootcamp[usuario.getBootcampsInscrito().size()];

                    for (Bootcamp bootcamp : usuario.getBootcampsInscrito()) {
                        menu += ("\n" + (contador + 1) + " - " + bootcamp);
                        bootcampsInscrito[contador] = bootcamp;
                        contador++;
                    }
                    menu += "\n0 - Cancelar\n";

                    System.out.println(menu);
                    escolha = scan.nextInt();

                    if (escolha != 0) {
                        bootcampsInscrito[escolha-1].concluirConteudo(usuario,
                                bootcampsInscrito[escolha-1].getConteudos().pop());
                    }
                    
                    break;
            
                case 0:
                    System.out.println("Obrigado por usar o programa!");
                    finalizar = true;
                    break;
                
                default:
                    System.out.println("Escolha uma das opções.");
                    break;
            }

        } while (!finalizar);
    }
}