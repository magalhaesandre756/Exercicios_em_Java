package br.ceub.fatecs.engsof.exercicio.pacotes.quadrado;

public class Quadrado {
    private int lado;

    public Quadrado(int lado) {
        this.lado = lado;
    }

    public double areaQuadrado(){
        int area;
        return area=lado*lado;
    }

    public double perimetroTriangulo(){
        int perimetro;
        return perimetro=4*lado;
    }
    public void imprimirDadosQuadrado() {
        System.out.println("O valor da area e: " + areaQuadrado());
        System.out.println("O valor do perimetro e : " + perimetroTriangulo());
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

}
