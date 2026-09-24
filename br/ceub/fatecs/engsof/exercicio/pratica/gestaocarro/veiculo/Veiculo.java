package br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.veiculo;

public abstract class Veiculo {
    private String marca;
    private String modelo;
    private int ano;
    private double velocidadeAtual;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (ano >= 1886){
            this.ano = ano;
        } else{
            throw new IllegalArgumentException("Ano inválido.");
        }

    }

    public double getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public Veiculo(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        setAno(ano);
    }

    public void exibirDados(){
        System.out.println("Marca:" + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Velocidade: " + velocidadeAtual + " km/h");
    }

    public void acelerar(){
        acelerar(10);
    }
    public void acelerar(double valor){
        if (valor <=0 ){
            throw new IllegalArgumentException("Valor não pode ser negativo ou igual a zero.");
        }
        velocidadeAtual += valor;
        System.out.println("Velocidade: " + velocidadeAtual + " km/h");
    }

    public void acelerar( double valor, int repeticoes){

        for ( int i = 0 ; i < repeticoes ; i++){
            acelerar(valor);

        }
    }


    public void frear (double valor){
        if (valor <=0){
            throw new IllegalArgumentException("Valor não pode ser negativo ou igual a zero.");

        }
        velocidadeAtual -= valor;
        if (velocidadeAtual <= 0 ){
            velocidadeAtual=0;

        }
        System.out.println("Velocidade: " + velocidadeAtual + " km/h");

    }

    public abstract void realizarManutencao();
}
