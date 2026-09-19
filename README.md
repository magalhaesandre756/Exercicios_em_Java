# Exercícios em Java

Repositório de exercícios práticos de Java, feitos durante a disciplina
de Engenharia de Software, com foco em conceitos de orientação a objetos.
Organizado como um projeto Java convencional, com pacotes seguindo a
convenção `br.ceub.fatecs.engsof`.

## Conteúdo

- `br.ceub.fatecs.engsof.exercicio.heranca` — exercício sobre herança em
  POO: a classe `Equipamento` (superclasse) implementa liga/desliga e
  impressão de estado; `EquipamentoSonoro` (subclasse) estende esse
  comportamento adicionando volume e modo estéreo, sobrescrevendo os
  métodos `liga()` e `imprime()` com `@Override` e reaproveitando a
  lógica da superclasse via `super`.
- `br.ceub.fatecs.engsof.exercicio.pacotes` — exercício sobre uso de
  pacotes em Java: as classes `Circulo`, `Quadrado` e `Triangulo` ficam
  cada uma em seu próprio subpacote (`circulo`, `quadrado`, `triangulo`)
  e são importadas e utilizadas pela classe principal
  `Exercicio_Pacotes`.
- `exercicio_aula_calculadora.java` (pacote `br.ceub.fatecs.engsof`) —
  exercício básico feito em aula, fora da estrutura de pacotes
  `exercicio`: programa que pede ao usuário o nome e 3 notas e calcula
  a média entre elas.

## Tecnologias

Java

## Aprendizados

Organização de código em pacotes seguindo convenção de nomenclatura
(`br.ceub.fatecs.engsof`), encapsulamento (get/set), construtores,
herança entre classes com sobrescrita de métodos (`@Override`) e uso de
`super` para reaproveitar comportamento da superclasse.
