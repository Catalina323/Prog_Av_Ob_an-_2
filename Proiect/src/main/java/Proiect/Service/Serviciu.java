package Proiect.Service;

import Proiect.Domain.*;

import static java.util.Arrays.sort;

public class Serviciu {
    private Depozit depozit;
    private Contabilitate contabilitate;
    private Angajat[] angajati;
    private int angajatul_zilei = 0;


    public Serviciu(){
        initializare_florarie();
    }

    private void initializare_florarie(){
        depozit = Depozit.getInstance();
        contabilitate = Contabilitate.getInstance();
        angajati = new Angajat[4];
        angajati[0] = new Angajat("Nica", "Catalina", 20, 3500, 2024, 2);
        angajati[1] = new Angajat("Neacsu", "Anamaria", 21, 2300, 2024, 3);
        angajati[2] = new Angajat("State", "Madalina", 20, 2700, 2023, 5);
        angajati[3] = new Angajat("Calota", "Ana", 22, 3000, 2023, 6);
    }

    public void afiseaza_angajati(){
        for(Angajat angajat:angajati){
            System.out.println(angajat);
        }
    }


    public void sorteaza_angajati_dupa_salariu(){
        sort(angajati);
    }

    public void sorteaza_angajati_dupa_data_angajare(){
        sort(angajati, new ComparatorAngajatData());
    }

    public int getAngajatul_zilei() {
        return angajatul_zilei;
    }

    public void setAngajatul_zilei(int angajatul_zilei) {
        this.angajatul_zilei = angajatul_zilei;
    }

    //afiseaza bilantul florariei
    public void calculeza_bilant()
    {
        System.out.println("Venituri: " + contabilitate.getVenituri());
        System.out.println("Cheltuieli: " + contabilitate.getCheltuieli());
        System.out.println("Profit: " + contabilitate.calculeazaProfit());
    }


    public void afiseaza_raport_stoc(){
        boolean marfa_suficienta = true;
        if(depozit.getNr_trandafiri() < 5){
            marfa_suficienta = false;
            System.out.println("Trandafiri: " + depozit.getNr_trandafiri() + " insuficienti");
        }
        if(depozit.getNr_frezii() < 5){
            marfa_suficienta = false;
            System.out.println("Frezii: " + depozit.getNr_frezii() + " insuficiente");
        }
        if(depozit.getNr_hortensii() < 5){
            marfa_suficienta = false;
            System.out.println("Hortensii: " + depozit.getNr_hortensii() + " insuficiente");
        }
        if(depozit.getNr_lalele() < 5){
            marfa_suficienta = false;
            System.out.println("Lalele: " + depozit.getNr_lalele() + " insuficiente");
        }
        if(depozit.getNr_bujori() < 5){
            marfa_suficienta = false;
            System.out.println("Bujori: " + depozit.getNr_bujori() + " insuficienti");
        }
        if(depozit.getNr_verdeturi() < 5){
            marfa_suficienta = false;
            System.out.println("Verdeturi: " + depozit.getNr_verdeturi() + " insuficiente");
        }
        if(depozit.getNr_cos_small() < 5){
            marfa_suficienta = false;
            System.out.println("Cosuri small: " + depozit.getNr_cos_small() + " insuficiente");
        }
        if(depozit.getNr_cos_medium() < 5){
            marfa_suficienta = false;
            System.out.println("Cosuri medium: " + depozit.getNr_cos_medium() + " insuficiente");
        }
        if(depozit.getNr_cos_large() < 5){
            marfa_suficienta = false;
            System.out.println("Cosuri large: " + depozit.getNr_cos_large() + " insuficiente");
        }

        if(marfa_suficienta){
            System.out.println("Avem suficienta marfa!");
        }

    }

    //reface sticul astfel incat sa avem 20 de bucati din fiecare
    public void cumpara_stoc(int nr){
        depozit.aprovizioneazaDepozit(nr - depozit.getNr_trandafiri(),
                nr - depozit.getNr_frezii(), nr - depozit.getNr_hortensii(),
                nr - depozit.getNr_lalele(), nr - depozit.getNr_bujori(),
                nr - depozit.getNr_verdeturi(), nr - depozit.getNr_cos_small(),
                nr - depozit.getNr_cos_medium(), nr - depozit.getNr_cos_large());
    }

    public void afiseaza_stoc(){
        System.out.println(depozit);
    }


    //Afiseaza istoricul comenzilor unui client
    public void istoric_comenzi(Client client){
        for(Comanda comanda:client.getIstoricComenzi()){
            if(comanda != null){
                System.out.println(comanda);
            }
        }
    }

    //Creaza o comanda 9 de buchete
    public Client comanda_buchete(Client client, Buchet... buchete){
        Comanda comanda = new Comanda(buchete);
        comanda.setAngajat(angajati[angajatul_zilei]);
        client.plaseazaComanda(comanda);
        return client;
    }

    //Realizeaza o comanda 9 de aranjamente
    public Client comanda_aranjamente(Client client, Aranjament... aranjamente){
        Comanda comanda = new Comanda(aranjamente);
        comanda.setAngajat(angajati[angajatul_zilei]);
        client.plaseazaComanda(comanda);
        return client;
    }

    public void calculeaza_pret_buchet(Buchet buchet){
        System.out.println(buchet.CalculeazaPretVanzare());
    }
    public void calculeaza_pret_aranjament(Aranjament aranjament){
        System.out.println(aranjament.CalculeazaPretVanzare());
    }

    public void bilant_per_buchet(Buchet buchet){
        System.out.println("Pret producere: " + buchet.CalculeazaPretProducere());
        System.out.println("Pret vanzare: " + buchet.CalculeazaPretVanzare());
        System.out.println("Profit: " + (buchet.CalculeazaPretVanzare() - buchet.CalculeazaPretProducere()));
    }

    public void bilant_per_aranjament(Aranjament aranjament){
        System.out.println("Pret producere: " + aranjament.CalculeazaPretProducere());
        System.out.println("Pret vanzare: " + aranjament.CalculeazaPretVanzare());
        System.out.println("Profit: " + (aranjament.CalculeazaPretVanzare() - aranjament.CalculeazaPretProducere()));
    }


}
