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

    //returneaza profitul florariei
    public double calculeza_profit(){
        return contabilitate.calculeazaProfit();
    }

    //reface sticul astfel incat sa avem 20 de bucati din fiecare
    public void cumpara_stoc(){
        depozit.aprovizioneazaDepozit(20 - depozit.getNr_trandafiri(),
                20 - depozit.getNr_frezii(), 20 - depozit.getNr_hortensii(),
                20 - depozit.getNr_lalele(), 20 - depozit.getNr_bujori(),
                20 - depozit.getNr_verdeturi(), 20 - depozit.getNr_cos_small(),
                20 - depozit.getNr_cos_medium(), 20 - depozit.getNr_cos_large());
    }

    





}
