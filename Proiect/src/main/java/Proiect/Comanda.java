package Proiect;

import java.util.Arrays;

public class Comanda {

    private Buchet[] buchete;
    private Aranjament[] aranjamente;

    private static Contabilitate contabilitate = Contabilitate.getInstance();
    private static Depozit depozit = Depozit.getInstance();

    public Comanda(Buchet[] buchete) {
        this.buchete = buchete;
        int i = -1;
        for(Buchet buchet:buchete){

            int[] vect = {0,0,0,0,0,0};
            //in ordinea: trandafir frezie hortensie lalea bujor verdeata

            if(buchet.trandafiri > 0){
                if(depozit.getNr_trandafiri() > buchet.trandafiri){
                    vect[0] = buchet.trandafiri;
                }
                else{
                    System.out.println("flori insuficiente");
                    i++;
                    buchete[i] = null;
                    continue;
                    //sterge buchetul din comanda;

                }
            }
            if(buchet.frezii > 0){
                if(depozit.getNr_frezii() > buchet.frezii){
                    vect[1] = buchet.frezii;
                }
                else{
                    System.out.println("flori insuficiente");
                    i++;
                    buchete[i] = null;
                    continue;

                    //sterge buchetul din comanda;

                }
            }
            if(buchet.hortensii > 0){
                if(depozit.getNr_hortensii() > buchet.hortensii){
                    vect[2] = buchet.hortensii;
                }
                else{
                    System.out.println("flori insuficiente");
                    i++;
                    buchete[i] = null;
                    continue;
                    //sterge buchetul din comanda;

                }
            }
            if(buchet.lalele > 0){
                if(depozit.getNr_lalele() > buchet.lalele){
                    vect[3] = buchet.lalele;
                }
                else{
                    System.out.println("flori insuficiente");
                    i++;
                    buchete[i] = null;
                    continue;

                    //sterge buchetul din comanda;

                }
            }
            if(buchet.bujori > 0){
                if(depozit.getNr_bujori() > buchet.bujori){
                    vect[4] = buchet.bujori;
                }
                else{
                    System.out.println("flori insuficiente");
                    i++;
                    buchete[i] = null;
                    continue;
                    //sterge buchetul din comanda;
                }
            }
            if(buchet.verdeata){
                if(depozit.getNr_verdeturi() > 0){
                    vect[5] = 1;
                }
                else{
                    System.out.println("verdeata insuficienta");
                    i++;
                    buchete[i] = null;
                    continue;
                    //sterge buchetul din comanda;

                }
            }

            depozit.setNr_trandafiri(depozit.getNr_trandafiri() - vect[0]);
            depozit.setNr_frezii(depozit.getNr_frezii() - vect[1]);
            depozit.setNr_hortensii(depozit.getNr_hortensii() - vect[2]);
            depozit.setNr_lalele(depozit.getNr_lalele() - vect[3]);
            depozit.setNr_bujori(depozit.getNr_bujori() - vect[4]);
            depozit.setNr_verdeturi(depozit.getNr_verdeturi() - vect[5]);

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
