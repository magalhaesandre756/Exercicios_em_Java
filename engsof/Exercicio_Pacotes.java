package br.ceub.fatecs.engsof;

import br.ceub.fatecs.engsof.Circulo.Circulo;
import br.ceub.fatecs.engsof.Quadrado.Quadrado;
import br.ceub.fatecs.engsof.Triangulo.Triangulo;


public class Exercicio_Pacotes {
    public static void main(String[] args) {
        Quadrado quadrado = new Quadrado(20);
        Triangulo triangulo = new Triangulo(5,6,8,9,10);
        Circulo circulo = new Circulo(6);

        System.out.println("---------");
        quadrado.imprimirDadosQuadrado();
        System.out.println("---------");
        triangulo.imprimirDadosTriangulo();
        System.out.println("---------");
        circulo.imprimirDadosCirculo();
    }


}
