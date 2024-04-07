package Proiect;

public class Contabilitate implements PreturiCumparare {

    protected double cheltuieli;
    protected double venituri;



    public double calculeazaProfit(){
        return venituri - cheltuieli;
    }

    public void cumparaTrandafiri(Depozit depozit, int nrTrandafiri){
        depozit.setNr_trandafiri(depozit.getNr_trandafiri() + nrTrandafiri);
        cheltuieli += nrTrandafiri * pret_trandafir_c;
    }
    public void cumparaFrezii(Depozit depozit, int nrFrezii){
        depozit.setNr_frezii(depozit.getNr_frezii() + nrFrezii);
        cheltuieli += nrFrezii * pret_frezie_c;
    }
    public void cumparaHortensii(Depozit depozit, int nrHortensii){
        depozit.setNr_hortensii(depozit.getNr_hortensii() + nrHortensii);
        cheltuieli += nrHortensii * pret_hortensie_c;
    }
    public void cumparaLalele(Depozit depozit, int nrLalele){
        depozit.setNr_lalele(depozit.getNr_lalele() + nrLalele);
        cheltuieli += nrLalele * pret_lalea_c;
    }
    public void cumparaBujori(Depozit depozit, int nrBujori){
        depozit.setNr_bujori(depozit.getNr_bujori() + nrBujori);
        cheltuieli += nrBujori * pret_bujor_c;
    }
    public void cumparaVerdeata(Depozit depozit, int nrVerdeturi){
        depozit.setNr_verdeturi(depozit.getNr_verdeturi() + nrVerdeturi);
        cheltuieli += nrVerdeturi * pret_verdeata_c;
    }

    public void cumparaCosSmall(Depozit depozit, int nrSmall){
        depozit.setNr_cos_small(depozit.getNr_cos_small() + nrSmall);
        cheltuieli += nrSmall * pret_cos_small_c;
    }

    public void cumparaCosMedium(Depozit depozit, int nrMedium){
        depozit.setNr_cos_medium(depozit.getNr_cos_medium() + nrMedium);
        cheltuieli += nrMedium * pret_cos_medium_c;
    }

    public void cumparaCosLarge(Depozit depozit, int nrLarge){
        depozit.setNr_cos_large(depozit.getNr_cos_large() + nrLarge);
        cheltuieli += nrLarge * pret_cos_large_c;
    }

}
