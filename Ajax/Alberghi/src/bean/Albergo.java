package bean;

public class Albergo {

    private int prezzo;
    private int id;
    private int camere;

    public Albergo(int id,int camere, int prezzo){
        this.prezzo=prezzo;
        this.id=id;
        this.camere=camere;


    }

    public int getCamere() {
        return camere;
    }

    public int getId() {
        return id;
    }

    public int getPrezzo() {
        return prezzo;
    }

    @Override
    public String toString() {
        return "Albergo: " +
                "prezzo=" + getPrezzo() +
                ",id=" + getId() +
                ",camere=" + getCamere();
    }
}
