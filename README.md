# Exercícios em Java

Repositório com exercícios práticos de Java desenvolvidos durante o curso de Engenharia de Software no CEUB, com foco em Programação Orientada a Objetos e em interfaces gráficas com Swing.

Todo o código está organizado em pacotes sob `br.ceub.fatecs.engsof`.

## Estrutura do projeto

```
br/ceub/fatecs/engsof/
├── exercicio_aula_calculadora.java
└── exercicio/
    ├── heranca/
    │   ├── Equipamento.java
    │   ├── EquipamentoSonoro.java
    │   └── ExercicioHeranca.java
    ├── pacotes/
    │   ├── Exercicio_Pacotes.java
    │   ├── circulo/Circulo.java
    │   ├── quadrado/Quadrado.java
    │   └── triangulo/Triangulo.java
    ├── pratica/gestaocarro/
    │   ├── Principal.java
    │   ├── veiculo/Veiculo.java
    │   ├── carro/Carro.java
    │   ├── carroeletrico/CarroEletrico.java
    │   ├── moto/Moto.java
    │   ├── caminhao/Caminhao.java
    │   └── interfaces/
    │       ├── Conectavel.java
    │       ├── Eletrico.java
    │       └── Rastreavel.java
    └── swing/
        ├── ContaRestaurante.java
        └── ListaDeCompras.java
```

## Conteúdo

### 1. Herança (`exercicio.heranca`)

A superclasse `Equipamento` implementa as funções de ligar, desligar e imprimir o estado do equipamento. A subclasse `EquipamentoSonoro` estende essa classe adicionando controle de volume e modo estéreo, sobrescrevendo os métodos `liga()` e `imprime()` com `@Override` e reaproveitando a lógica da superclasse por meio de `super`.

### 2. Pacotes (`exercicio.pacotes`)

As classes `Circulo`, `Quadrado` e `Triangulo` ficam cada uma em seu próprio subpacote e são importadas e utilizadas pela classe principal `Exercicio_Pacotes`, praticando a organização de código em pacotes e a convenção de nomenclatura.

### 3. Gestão de Veículos (`exercicio.pratica.gestaocarro`)

Exercício mais completo, que simula um sistema de gestão de veículos.

- **Classe abstrata `Veiculo`**: define marca, modelo, ano e velocidade atual, com validação do ano (não aceita anos anteriores a 1886), o método `exibirDados()` e o método abstrato `realizarManutencao()`, que cada tipo de veículo implementa à sua maneira.
- **Sobrecarga de métodos**: `acelerar()` possui três versões (valor padrão de 10 km/h, valor informado e valor com número de repetições). O método `frear()` nunca deixa a velocidade ficar negativa.
- **Tratamento de erros**: valores inválidos (ano inválido, aceleração ou frenagem com valor zero ou negativo) lançam `IllegalArgumentException`.
- **Subclasses**: `Carro`, `Moto`, `Caminhao` e `CarroEletrico` (que estende `Carro`).
- **Interfaces**: `Eletrico` (`carregarBateria()` e `getNivelBateria()`), `Conectavel` (`conectarInternet()`) e `Rastreavel` (`obterLocalizacao()`). O `CarroEletrico` implementa as três.
- **Polimorfismo**: a classe `Principal` armazena todos os veículos em uma `List<Veiculo>`, percorre a lista chamando os métodos comuns e usa `instanceof` para acionar os comportamentos específicos de cada interface. Também traz testes de aceleração e frenagem e exemplos comentados de erros esperados.

### 4. Interfaces gráficas com Swing (`exercicio.swing`)

- **`ContaRestaurante`**: calculadora de conta de restaurante. O usuário informa o valor consumido e o número de pessoas, escolhe a taxa de serviço (0%, 5%, 10% ou 15%) e o programa calcula o total e o valor por pessoa. Possui botão para limpar o formulário e validação das entradas.
- **`ListaDeCompras`**: aplicação de lista de compras. Permite adicionar produtos com quantidade e preço, exibe cada item com seu subtotal e atualiza o total da compra automaticamente. Valida campos vazios, quantidade maior que zero, preço não negativo e entradas não numéricas, exibindo mensagens com `JOptionPane`.

### 5. Calculadora de média (`exercicio_aula_calculadora.java`)

Exercício introdutório feito em aula: solicita o nome do aluno e três notas e calcula a média.

## Tecnologias

- Java
- Java Swing
- IntelliJ IDEA

## Conceitos praticados

- Organização de código em pacotes
- Encapsulamento com getters e setters
- Construtores
- Herança, sobrescrita de métodos (`@Override`) e uso de `super`
- Classes e métodos abstratos
- Interfaces e implementação de múltiplas interfaces
- Polimorfismo e uso de `instanceof`
- Sobrecarga de métodos
- Tratamento de exceções (`IllegalArgumentException`, `NumberFormatException`)
- Coleções (`List`)
- Interfaces gráficas com Swing (`JFrame`, `JPanel`, layouts, eventos de botão e `JOptionPane`)

## Como executar

1. Clone o repositório:
   ```
   git clone https://github.com/magalhaesandre756/Exercicios_em_Java.git
   ```
2. Abra o projeto no IntelliJ IDEA (ou outra IDE Java).
3. Execute a classe com o método `main` do exercício desejado, por exemplo `Principal.java` (gestão de veículos) ou `ListaDeCompras.java` (Swing).

## Autor

André Magalhães
[LinkedIn](https://linkedin.com/in/andreoliveiramagalhaes) · [GitHub](https://github.com/magalhaesandre756)
