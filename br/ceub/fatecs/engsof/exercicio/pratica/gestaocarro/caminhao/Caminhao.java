package br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.caminhao;

import br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.interfaces.Conectavel;
import br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.interfaces.Rastreavel;
import br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.veiculo.Veiculo;

public class Caminhao extends Veiculo implements  Conectavel, Rastreavel {
    private double capacidadeDeCarga;


    public Caminhao(String marca, String modelo, int ano, double capacidadeDeCarga) {
        super(marca, modelo, ano);
        this.capacidadeDeCarga = capacidadeDeCarga;
    }

    public double getCapacidadeDeCarga() {
        return capacidadeDeCarga;
    }

    @Override
    public void realizarManutencao() {
        System.out.println("Troca de óleo, verificação dos freios e Limpeza da caçamba. ");

    }


    @Override
    public void exibirDados() {
        System.out.println("=== CAMINHAO ===");
        super.exibirDados();
        System.out.println("Capacidade de Carga: " + capacidadeDeCarga + " Toneladas");
        System.out.println("Localização: " + obterLocalizacao());
    }

    @Override
    public String obterLocalizacao() {
        return "Brasilia-DF";
    }

    @Override
    public void conectarInternet() {
        System.out.println("Veiculo Conectado.");

    }
}
