package br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro;

import br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.carroeletrico.CarroEletrico;
import br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.caminhao.Caminhao;
import br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.carro.Carro;
import br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.moto.Moto;
import br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.veiculo.Veiculo;
import br.ceub.fatecs.engsof.exercicio.pratica.gestaocarro.interfaces.*;

import java.util.ArrayList;
import java.util.List;


public class Principal {
    public static void main(String[] args) {
        // 1. Instanciar Carro, Moto, Caminhao e CarroEletrico
        Carro carro1 = new Carro("volks", "jetta", 2025, 4);
        Moto moto1 = new Moto("suzuki", "ninja", 2016, true);
        Carro carro2 = new Carro("GWM", "tank", 2026, 5);
        CarroEletrico eletrico = new CarroEletrico("BYD", "SONG", 2026, 4);
        Caminhao caminhao = new Caminhao("volvo", "Carregatudo3000", 2026, 2.5);

        // 2. Adicionar os objetos a uma List<Veiculo>
        List<Veiculo> frota = new ArrayList<>();
        frota.add(carro1);
        frota.add(moto1);
        frota.add(carro2);
        frota.add(eletrico);
        frota.add(caminhao);

        System.out.println("########## 3. LISTAGEM POLIMÓRFICA (exibirDados + realizarManutencao) ##########\n");

        // 3. Percorrer a lista invocando exibirDados() e realizarManutencao()
        // 4. Usar instanceof apenas para acessar capacidades específicas (Conectavel/Rastreavel)
        for (Veiculo veiculo : frota) {
            veiculo.exibirDados();
            veiculo.realizarManutencao();

            if (veiculo instanceof Conectavel) {
                ((Conectavel) veiculo).conectarInternet();
            }

            if (veiculo instanceof Rastreavel) {
                String localizacao = ((Rastreavel) veiculo).obterLocalizacao();
                System.out.println("Localização: " + localizacao);
            }

            System.out.println("--------------------------------------------------\n");
        }

        System.out.println("########## CARREGAR BATERIA DO VEÍCULO ELÉTRICO ##########\n");

        // Requisito funcional: carregar a bateria dos veículos elétricos
        System.out.println("Nível antes de carregar: " + eletrico.getNivelBateria());
        eletrico.carregarBateria();
        System.out.println("Nível depois de carregar: " + eletrico.getNivelBateria());
        System.out.println();

        System.out.println("########## 5. TESTES DE ACELERAR E FREAR (com validação) ##########\n");

        // Acelerar e frear normalmente
        carro1.acelerar(20);
        carro1.frear(10);

        // Sobrecarga: acelerar sem parâmetro (valor padrão)
        carro1.acelerar();

        // Sobrecarga: acelerar com repetições
        carro1.acelerar(5, 3);

        // Frear além da velocidade atual: não deve ficar negativo
        carro1.frear(1000);
        System.out.println();

        // ==================================================================
        // TESTES QUE LANÇAM ERRO (IllegalArgumentException)
        // Cada linha abaixo, se descomentada, INTERROMPE o programa na hora,
        // porque nenhum código está tratando o erro. Por isso estão comentadas.
        // Descomente UMA de cada vez para testar, rode, veja a mensagem de
        // erro no console, comente de novo antes de testar a próxima.
        // ==================================================================

        // Ano inválido no construtor:
        // new Carro("Ford", "Model T", 1800, 2);

        // Acelerar com valor negativo:
        // moto1.acelerar(-10);

        // Acelerar com valor zero:
        // moto1.acelerar(0);

        // Frear com valor negativo:
        // moto1.frear(-5);

        // ==================================================================
        // LIMITE DO POLIMORFISMO: o compilador não deixa nem chegar a rodar.
        // Descomente para ver o ERRO DE COMPILAÇÃO (não é erro de execução):
        // ==================================================================

        // for (Veiculo veiculo : frota) {
        //     veiculo.getQuantidadePortas(); // erro: método não existe em Veiculo
        // }

        System.out.println("########## TOTAL DE VEÍCULOS CADASTRADOS ##########\n");

        // Exibir a quantidade total de veículos cadastrados
        System.out.println("Total de veículos cadastrados: " + frota.size());

    }

}