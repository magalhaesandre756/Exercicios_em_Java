package br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.carro;

import br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.interfaces.Conectavel;
import br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.interfaces.Rastreavel;
import br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.veiculo.Veiculo;

public class Carro extends Veiculo implements Conectavel, Rastreavel {
    private int quantidadePortas;

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public Carro(String marca, String modelo, int ano, int quantidadePortas) {
        super(marca, modelo, ano);
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public void exibirDados() {
        System.out.println("=== CARRO ===");
        super.exibirDados();
        System.out.println("Portas: " + getQuantidadePortas());
        System.out.println("Localização: " + obterLocalizacao());
    }

    @Override
    public void realizarManutencao() {
        System.out.println("Troca de óleo e verificação dos freios.");
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
