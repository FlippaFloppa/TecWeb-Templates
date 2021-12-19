package bean;

public class Prenotazione {
    private int data;
    private int orario;
    private int campi;
    private String scelta;

    public Prenotazione(){
        super();
    }

    public int getCampi() {
        return campi;
    }

    public int getData() {
        return data;
    }

    public int getOrario() {
        return orario;
    }

    public String getScelta() {
        return scelta;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        Prenotazione p=(Prenotazione)obj;
        if(this.getCampi()==p.getCampi()&&this.getData()==p.getData()&&this.getData()==p.getData())return true;
        return false;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "data=" + data +
                ", orario=" + orario +
                ", campi=" + campi +
                ", scelta='" + scelta + '\'' +
                '}';
    }
}
