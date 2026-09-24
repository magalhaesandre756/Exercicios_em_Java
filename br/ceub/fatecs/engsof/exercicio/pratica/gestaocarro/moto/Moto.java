package br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.moto;

import br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.interfaces.Rastreavel;
import br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.veiculo.Veiculo;

public class Moto extends Veiculo implements Rastreavel {
    private boolean possuiPartidaEletrica;

    public boolean isPossuiPartidaEletrica() {
        return possuiPartidaEletrica;
    }

    public Moto(String marca, String modelo, int ano, boolean possuiPartidaEletrica) {
        super(marca, modelo, ano);
        this.possuiPartidaEletrica = possuiPartidaEletrica;
    }

    @Override
    public void exibirDados() {
        System.out.println("=== MOTO ===");
        super.exibirDados();
        System.out.println("Tem partida eletrica : " + isPossuiPartidaEletrica());
        System.out.println("Localização: " + obterLocalizacao());
    }

    @Override
    public void realizarManutencao() {
        System.out.println("Verificação da corrente e dos pneus.");
    }

    @Override
    public String obterLocalizacao() {
        return "Brasilia-DF";
    }
}
