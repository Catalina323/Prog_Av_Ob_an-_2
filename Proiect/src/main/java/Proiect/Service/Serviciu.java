package Proiect.Service;

import Proiect.Domain.*;
import Proiect.Repository.*;

import java.util.Optional;

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
        Angajat angajati[] = new Angajat[4];
        AngajatRepository angajatRepository = new AngajatRepository();
        Optional<Angajat> angajat = angajatRepository.getById(1);
        if(angajat.isPresent()){
            angajati[0] = angajat.get();
        }
        Optional<Angajat> angajat2 = angajatRepository.getById(1);
        if(angajat2.isPresent()){
            angajati[1] = angajat2.get();
        }
        Optional<Angajat> angajat3 = angajatRepository.getById(1);
        if(angajat3.isPresent()){
            angajati[2] = angajat3.get();
        }
        Optional<Angajat> angajat4 = angajatRepository.getById(1);
        if(angajat4.isPresent()){
            angajati[3] = angajat4.get();
        }
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

    //reface sticul astfel incat sa avem nr de bucati din fiecare
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


    // creeaza un client si il adauga in baza de date. returneaza id ul clientului din baza de date
    public int ClientNou(Client client){
        ClientRepository clientRepository = new ClientRepository();
        return clientRepository.insert(client);
    }

    //Creaza o comanda 9 de buchete (returneaza id ul comenzii din baza de date)
    public int comanda_buchete(int idClient, Client client, Buchet... buchete){
        Comanda comanda = new Comanda(buchete);
        comanda.setIdAngajat(angajatul_zilei);
        ComandaRepository comandaRepository = new ComandaRepository();
        int idComanda = comandaRepository.insert(angajatul_zilei, idClient);
        client.plaseazaComanda(comanda);

        BuchetRepository buchetRepository = new BuchetRepository();
        for(Buchet buchet:buchete){
            buchetRepository.insert(buchet, idComanda);
        }

        return idComanda;
    }

    //Realizeaza o comanda 9 de aranjamente
    public Client comanda_aranjamente(int idClient, Client client, Aranjament... aranjamente){
        Comanda comanda = new Comanda(aranjamente);
        comanda.setIdAngajat(angajatul_zilei);
        ComandaRepository comandaRepository = new ComandaRepository();
        int idComanda = comandaRepository.insert(angajatul_zilei, idClient);
        client.plaseazaComanda(comanda);

        AranjamentRepository aranjamentRepository = new AranjamentRepository();
        for(Aranjament aranjament:aranjamente){
            aranjamentRepository.insert(aranjament, idComanda);
        }

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
