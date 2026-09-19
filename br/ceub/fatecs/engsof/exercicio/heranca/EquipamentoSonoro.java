package br.ceub.fatecs.engsof.exercicio.heranca;

public class EquipamentoSonoro extends Equipamento {
    private short volume;
    private boolean stereo;


    public EquipamentoSonoro() {
        setVolume((short) 0);
        setStereo(false);

    }

    public void ligaStereo(){
        if(isStereo()==false){
            setStereo(true);
        }
    }
    public void mono(){
        if(isStereo()==true){
            setStereo(false);
        }
    }

    public void volume(short volume){
        this.volume = volume;
    }

    @Override
    public void liga(){
        super.liga();
        ligaStereo();
        setVolume((short) 5);

    }
    @Override
    public void imprime(){
        super.imprime();
        System.out.println("Volume: " + getVolume());
        System.out.println("Stereo: " + isStereo());
    }


    public short getVolume() {
        return volume;
    }

    public void setVolume(short volume) {
        this.volume = volume;
    }

    public boolean isStereo() {
        return stereo;
    }

    public void setStereo(boolean stereo) {
        this.stereo = stereo;
    }
}
