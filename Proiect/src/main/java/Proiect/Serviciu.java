package Proiect;

public class Serviciu {
    Depozit depozit;
    Contabilitate contabilitate;

    public Serviciu(){
        initializare_florarie();
    }

    public void initializare_florarie(){
        depozit = Depozit.getInstance();
        contabilitate = Contabilitate.getInstance();
    }

    //afiseaza bilantul florariei
    public void calculeza_bilant()
    {
        System.out.println("Venituri: " + contabilitate.venituri);
        System.out.println("Cheltuieli: " + contabilitate.cheltuieli);
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
    public void cumpara_stoc(){
        depozit.aprovizioneazaDepozit(20 - depozit.getNr_trandafiri(),
                20 - depozit.getNr_frezii(), 20 - depozit.getNr_hortensii(),
                20 - depozit.getNr_lalele(), 20 - depozit.getNr_bujori(),
                20 - depozit.getNr_verdeturi(), 20 - depozit.getNr_cos_small(),
                20 - depozit.getNr_cos_medium(), 20 - depozit.getNr_cos_large());
    }

    //Afiseaza istoricul comenzilor unui client
    public void istoric_comenzi(Client client){
        for(Comanda comanda:client.getIstoricComenzi()){
            if(comanda != null){
                System.out.println(comanda);
            }
        }
    }

    //Creaza o comanda de buchete 9
    public Comanda comanda_buchete(Buchet ... buchete){
        Comanda comanda = new Comanda(buchete);
        return comanda;
    }

    //Realizeaza o comanda de aranjamente 9
    public Comanda comanda_aranjamente(Aranjament ... aranjamente){
        Comanda comanda = new Comanda(aranjamente);
        return comanda;
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
        System.out.println("Profit" + (buchet.CalculeazaPretVanzare() - buchet.CalculeazaPretProducere()));
    }

    public void bilant_per_aranjament(Aranjament aranjament){
        System.out.println("Pret producere: " + aranjament.CalculeazaPretProducere());
        System.out.println("Pret vanzare: " + aranjament.CalculeazaPretVanzare());
        System.out.println("Profit" + (aranjament.CalculeazaPretVanzare() - aranjament.CalculeazaPretProducere()));
    }


}
