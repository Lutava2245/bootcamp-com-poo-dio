# Bootcamps com POO

Este pequeno projeto simula um sistema de ensino com bootcamps contendo pequenos cursos.

## Tecnologias

* Java 21

## Diagrama de Classes

```mermaid
classDiagram
    class Dev {
        -int xp = 0
        -int id
        -String nome
        -Set~Bootcamp~ bootcampsInscrito
        -Set~Bootcamp~ bootcampsConcluidos
        -Set~Conquista~ conquistas
        +inscrever(Bootcamp bootcamp_a_matricular) void
        +ganharXP(int xp) void
        +ganharConquista(Conquista conquista) void
    }

    class Conteudo {
    <<abstract>>
        #int XP_PADRAO = 10
        -String titulo
        -String mentor
        -Conquista conquista
        #gerarXP()* int
    }

    class Mentoria {
        -LocalDate data
        #gerarXP() int
    }

    class Curso {
        -int carga_horaria
        #gerarXP() int
    }

    class Conquista {
        -String nome
        -String linguagem
    }

    class Bootcamp {
        -String nome
        -Conquista conquista
        -LocalDate data_inicio
        -LocalDate data_fim
        -Deque~Conteudo~ conteudos
        +concluirConteudo(Dev desenvolvedor, Conteudo conteudo) void
    }

    Bootcamp "*" -- "*" Dev
    Conteudo "*" --o "*" Bootcamp
    Conteudo "1" *-- "1" Conquista
    Mentoria <|-- Conteudo
    Curso <|-- Conteudo
```

## Contato

* Luan T. Felix - [lutavares.bros@gmail.com](mailto:lutavares.bros@gmail.com)
* [LinkedIn](https://www.linkedin.com/in/luan-tavares-felix-24273a289/)