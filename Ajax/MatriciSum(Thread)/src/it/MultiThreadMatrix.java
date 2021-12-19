package it;

import java.util.ArrayList;
import java.util.List;

class MultiThreadMatrix extends Thread {

    private List<Integer> lista;
    public MultiThreadMatrix(Integer[] riga1){
        lista=new ArrayList<>(List.of(riga1));
    }
    public void run(){
        System.out.println("Lista ricevuta: "+lista.toString());

    }
    public int calcolaRes(){
        return 1;
    }

}


