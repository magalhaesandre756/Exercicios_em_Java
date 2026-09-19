package br.ceub.fatecs.engsof.exercicio.heranca;

public class ExercicioHeranca {
    public static void main(String[] args) {
        Equipamento equipamento = new Equipamento();
        EquipamentoSonoro eqsom = new EquipamentoSonoro();

        System.out.println("superclasse:");
        equipamento.liga();
        equipamento.imprime();

        System.out.println("subclasse:");
        eqsom.liga();
        eqsom.imprime();
    }
}
