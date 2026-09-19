package br.ceub.fatecs.engsof.exercicio.pacotes.triangulo;

public class Triangulo {
    private int base;
    private int altura;
    private int lado1,lado2,lado3;

    public Triangulo(int base, int altura, int lado1, int lado2, int lado3) {
        this.base = base;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public double areaTriangulo(){
        int area;
        return area= base*altura/2;

    }
    public double perimetroTriangulo(){
        int perimetro;
        return perimetro = lado1+lado2+lado3;

    }
    public void imprimirDadosTriangulo() {
        System.out.println("O valor da area e: " + areaTriangulo());
        System.out.println("O valor do perimetro e : " + perimetroTriangulo());
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLado1() {
        return lado1;
    }

    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }

    public int getLado2() {
        return lado2;
    }

    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }

    public int getLado3() {
        return lado3;
    }

    public void setLado3(int lado3) {
        this.lado3 = lado3;
    }










}
