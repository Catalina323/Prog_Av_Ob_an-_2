package Proiect;

import java.util.Arrays;

public class Comanda {

    private Buchet[] buchete;
    private Aranjament[] aranjamente;
    private Angajat angajat;

    private static Contabilitate contabilitate = Contabilitate.getInstance();
    private static Depozit depozit = Depozit.getInstance();

    public Comanda(Buchet ... buchete) {
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

            this.contabilitate.venituri += buchet.CalculeazaPretVanzare();

        }

    }
    public Comanda(Aranjament ... aranjamente) {
        this.aranjamente = aranjamente;

        int i = -1;
        for (Aranjament aranjament : aranjamente) {

            int[] vect = {0, 0, 0, 0, 0, 0, 0, 0, 0};
            //in ordinea: trandafir frezie hortensie lalea bujor verdeata small medium large

            if (aranjament.trandafiri > 0) {
                if (depozit.getNr_trandafiri() > aranjament.trandafiri) {
                    vect[0] = aranjament.trandafiri;
                } else {
                    System.out.println("flori insuficiente");
                    i++;
                    aranjamente[i] = null;
                    continue;
                    //sterge buchetul din comanda;

                }
            }
            if (aranjament.frezii > 0) {
                if (depozit.getNr_frezii() > aranjament.frezii) {
                    vect[1] = aranjament.frezii;
                } else {
                    System.out.println("flori insuficiente");
                    i++;
                    aranjamente[i] = null;
                    continue;

                    //sterge buchetul din comanda;

                }
            }
            if (aranjament.hortensii > 0) {
                if (depozit.getNr_hortensii() > aranjament.hortensii) {
                    vect[2] = aranjament.hortensii;
                } else {
                    System.out.println("flori insuficiente");
                    i++;
                    aranjamente[i] = null;
                    continue;
                    //sterge buchetul din comanda;

                }
            }
            if (aranjament.lalele > 0) {
                if (depozit.getNr_lalele() > aranjament.lalele) {
                    vect[3] = aranjament.lalele;
                } else {
                    System.out.println("flori insuficiente");
                    i++;
                    aranjamente[i] = null;
                    continue;

                    //sterge buchetul din comanda;

                }
            }
            if (aranjament.bujori > 0) {
                if (depozit.getNr_bujori() > aranjament.bujori) {
                    vect[4] = aranjament.bujori;
                } else {
                    System.out.println("flori insuficiente");
                    i++;
                    aranjamente[i] = null;
                    continue;
                    //sterge buchetul din comanda;
                }
            }
            if (aranjament.verdeata) {
                if (depozit.getNr_verdeturi() > 0) {
                    vect[5] = 1;
                } else {
                    System.out.println("verdeata insuficienta");
                    i++;
                    aranjamente[i] = null;
                    continue;
                    //sterge buchetul din comanda;

                }
            }

            if(aranjament.getDimensiune() == Dimensiuni.SMALL){
                if(depozit.getNr_cos_small() > 0){
                    vect[6] = 1;
                }
                else{
                    System.out.println("cosuri small insuficiente");
                    i++;
                    aranjamente[i] = null;
                    continue;
                }
            }
            if(aranjament.getDimensiune() == Dimensiuni.MEDIUM){
                if(depozit.getNr_cos_medium() > 0){
                    vect[7] = 1;
                }
                else{
                    System.out.println("cosuri medium insuficiente");
                    i++;
                    aranjamente[i] = null;
                    continue;
                }
            }
            if(aranjament.getDimensiune() == Dimensiuni.LARGE){
                if(depozit.getNr_cos_large() > 0){
                    vect[8] = 1;
                }
                else{
                    System.out.println("cosuri large insuficiente");
                    i++;
                    aranjamente[i] = null;
                    continue;
                }
            }


            depozit.setNr_trandafiri(depozit.getNr_trandafiri() - vect[0]);
            depozit.setNr_frezii(depozit.getNr_frezii() - vect[1]);
            depozit.setNr_hortensii(depozit.getNr_hortensii() - vect[2]);
            depozit.setNr_lalele(depozit.getNr_lalele() - vect[3]);
            depozit.setNr_bujori(depozit.getNr_bujori() - vect[4]);
            depozit.setNr_verdeturi(depozit.getNr_verdeturi() - vect[5]);
            depozit.setNr_cos_small(depozit.getNr_cos_small() - vect[6]);
            depozit.setNr_cos_medium(depozit.getNr_cos_medium() - vect[7]);
            depozit.setNr_cos_large(depozit.getNr_cos_large() - vect[8]);


            this.contabilitate.venituri += aranjament.CalculeazaPretVanzare();

        }

    }

    public Angajat getAngajat() {
        return angajat;
    }

    public void setAngajat(Angajat angajat) {
        this.angajat = angajat;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "buchete=" + Arrays.toString(buchete) +
                ", aranjamente=" + Arrays.toString(aranjamente) +
                '}';
    }
}
