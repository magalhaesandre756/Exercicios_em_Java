package br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.carroeletrico;

import br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.carro.Carro;
import br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.interfaces.Conectavel;
import br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.interfaces.Eletrico;
import br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.interfaces.Rastreavel;

public class CarroEletrico extends Carro
        implements Eletrico, Conectavel, Rastreavel {
    private int nivelBateria;

    public CarroEletrico(String marca, String modelo, int ano, int quantidadePortas) {
        super(marca, modelo, ano, quantidadePortas);


    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Nível da bateria: " + getNivelBateria());
        System.out.println("Localização: " + obterLocalizacao());
    }

    @Override
    public void carregarBateria() {
        nivelBateria = 100;

    }

    @Override
    public int getNivelBateria() {
        return nivelBateria;
    }

    @Override
    public void conectarInternet() {
        System.out.println("Veiculo Conectado.");
    }

    @Override
    public String obterLocalizacao() {
        return "Brasilia-DF";
    }
}
