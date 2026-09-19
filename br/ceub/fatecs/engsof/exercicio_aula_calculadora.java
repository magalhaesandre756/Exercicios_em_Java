package br.ceub.fatecs.engsof;

import java.util.Scanner;
import java.util.*;

public class exercicio_aula_calculadora {
    public static void main(String[] args) {
        Scanner  scanner = new Scanner (System.in);
        String nome;
        double nota1, nota2, nota3, media;



        System.out.println("Digite o nome do aluno: ");
        nome = scanner.next();

        System.out.println("Digite a nota 1: ");
        nota1 = scanner.nextDouble();

        System.out.println("Digite a nota 2: ");
        nota2 = scanner.nextDouble();

        System.out.println("Digite a nota 3: ");
        nota3 = scanner.nextDouble();

        media = (nota1 + nota2 + nota3) / 3;

        System.out.printf("a soma eh %f\n", media);




    }
}
