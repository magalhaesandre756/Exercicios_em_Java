package br.ceub.fatecs.engsof.exercicio.pacotes.circulo;

public class Circulo {
    private double raio;
    private double pi = 3.14;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double areaCirculo() {
        double area;
        return area = pi * raio * raio;

    }

    public double perimetroCirculo() {
        double perimetro;
         return perimetro = 2 * pi * raio;

    }

    public void imprimirDadosCirculo() {
        System.out.println("O valor da area e: " + areaCirculo());
        System.out.println("O valor do perimetro e : " + perimetroCirculo());
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }




}
