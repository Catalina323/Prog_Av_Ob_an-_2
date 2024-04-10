package Proiect;

import java.util.Arrays;

public class Comanda {

    private Buchet[] buchete;
    private Aranjament[] aranjamente;
    private String data;

    private static Contabilitate contabilitate = Contabilitate.getInstance();

    public Comanda(Buchet[] buchete) {
        this.buchete = buchete;

        for(Buchet buchet:buchete){
            System.out.println(buchet);
            this.contabilitate.cheltuieli += buchet.CalculeazaPretProducere();
            this.contabilitate.venituri += buchet.CalculeazaPretVanzare();
        }

    }
    public Comanda(Aranjament[] aranjamente) {
        this.aranjamente = aranjamente;

        for(Aranjament aranjament:aranjamente){
            this.contabilitate.cheltuieli += aranjament.CalculeazaPretProducere();
            this.contabilitate.venituri += aranjament.CalculeazaPretVanzare();
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
