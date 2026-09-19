package br.ceub.fatecs.engsof.exercicio.heranca;

public class Equipamento {
    private boolean Ligado;

    public Equipamento() {
       setLigado(false);
    }

    public void liga(){
        if (isLigado() == false){
            setLigado(true);
        }
    }

    public void desliga(){
        if (isLigado() == true){
            setLigado(false);
        }
    }

    public void imprime(){
        System.out.println("Ligado: " + isLigado());

    }


    public boolean isLigado() {
        return Ligado;
    }

    public void setLigado(boolean ligado) {
        Ligado = ligado;
    }
}
