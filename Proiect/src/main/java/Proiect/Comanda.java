package Proiect;

import java.util.Arrays;

public class Comanda extends Contabilitate{

    private Buchet[] buchete;
    private Aranjament[] aranjamente;
    private String data;

    public Comanda(Buchet[] buchete, Aranjament[] aranjamente) {
        this.buchete = buchete;
        this.aranjamente = aranjamente;

        for(Buchet buchet:buchete){
            cheltuieli += buchet.CalculeazaPretProducere();
            venituri += buchet.CalculeazaPretVanzare();
        }

        for(Aranjament aranjament:aranjamente){
            cheltuieli += aranjament.CalculeazaPretProducere();
            venituri += aranjament.CalculeazaPretVanzare();
        }

    }


    @Override
    public String toString() {
        return "Comanda{" +
                "buchete=" + Arrays.toString(buchete) +
                ", aranjamente=" + Arrays.toString(aranjamente) +
                '}';
    }
}
