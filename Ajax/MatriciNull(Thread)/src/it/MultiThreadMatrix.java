package it;

class MultiThreadMatrix extends Thread {

    private static final Character ch = Character.MIN_VALUE;
    private final String riga;
    private boolean result = true;
    private long time;

    public MultiThreadMatrix(String riga) {
        this.riga = riga;

    }

    public void run() {
        System.out.println("Ricevuta riga: " + riga);
        time = System.currentTimeMillis();
        calculate();
        time -= System.currentTimeMillis();

    }

    public void calculate() {
        for (int i = 0; i < riga.length(); i++) {
            if (riga.charAt(i) != ch) {
                result = false;
            }
        }
        result = true;
    }

    public long getTime() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return time;

    }

    public boolean isEmpty() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}


