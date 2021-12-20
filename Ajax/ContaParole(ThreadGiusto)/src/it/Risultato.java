package it;

public class Risultato {
    private final long tempo;
    private final int risultato;

    public Risultato(int risultato, long tempo) {
        this.risultato = risultato;
        this.tempo = tempo;
    }

    public long getTempo() {
        return tempo;
    }

    public int getRisultato() {
        return risultato;
    }

}
