package Proiect.Domain;

public class Depozit implements PreturiCumparare {

    private int nr_trandafiri;
    private int nr_hortensii;
    private int nr_frezii;
    private int nr_lalele;
    private int nr_bujori;
    private int nr_verdeturi;
    private int nr_cos_small;
    private int nr_cos_medium;
    private int nr_cos_large;

    private Contabilitate contabilitate = Contabilitate.getInstance();

    //SINGLETON PT DEPOZIT
    private static Depozit instance;

    private Depozit(){
        nr_bujori = 0;
        nr_frezii = 0;
        nr_lalele = 0;
        nr_trandafiri = 0;
        nr_hortensii = 0;
        nr_verdeturi = 0;
        nr_cos_large = 0;
        nr_cos_medium = 0;
        nr_cos_small = 0;
    }

    public static Depozit getInstance(){
        if(instance == null){
            instance = new Depozit();
        }
        return instance;
    }

    public void aprovizioneazaDepozit(int trandafiri, int frezii, int hortensii, int lalele, int bujori, int verdeturi, int small, int medium , int large){
        this.nr_trandafiri += trandafiri;
        this.nr_frezii += frezii;
        this.nr_hortensii += hortensii;
        this.nr_lalele += lalele;
        this.nr_bujori += bujori;
        this.nr_verdeturi += verdeturi;
        this.nr_cos_small += small;
        this.nr_cos_large += large;
        this.nr_cos_medium += medium;

        contabilitate.cheltuieli += trandafiri * pret_trandafir_c +
                frezii * pret_frezie_c +
                hortensii * pret_hortensie_c +
                lalele * pret_lalea_c +
                bujori * pret_bujor_c +
                verdeturi * pret_verdeata_c +
                small * pret_cos_small_c +
                medium * pret_cos_medium_c +
                large * pret_cos_large_c;

    }


    @Override
    public String toString() {
        return "Depozit{" +
                "nr_trandafiri=" + nr_trandafiri +
                ", nr_hortensii=" + nr_hortensii +
                ", nr_frezii=" + nr_frezii +
                ", nr_lalele=" + nr_lalele +
                ", nr_bujori=" + nr_bujori +
                ", nr_verdeturi=" + nr_verdeturi +
                ", nr_cos_small=" + nr_cos_small +
                ", nr_cos_medium=" + nr_cos_medium +
                ", nr_cos_large=" + nr_cos_large +
                '}';
    }

    public int getNr_trandafiri() {
        return nr_trandafiri;
    }

    public int getNr_hortensii() {
        return nr_hortensii;
    }

    public int getNr_frezii() {
        return nr_frezii;
    }

    public int getNr_lalele() {
        return nr_lalele;
    }

    public int getNr_bujori() {
        return nr_bujori;
    }

    public int getNr_verdeturi() {
        return nr_verdeturi;
    }

    public int getNr_cos_small() { return nr_cos_small; }

    public int getNr_cos_medium() {
        return nr_cos_medium;
    }

    public int getNr_cos_large() {
        return nr_cos_large;
    }

    public void setNr_trandafiri(int nr_trandafiri) {
        this.nr_trandafiri = nr_trandafiri;
    }

    public void setNr_hortensii(int nr_hortensii) {
        this.nr_hortensii = nr_hortensii;
    }

    public void setNr_frezii(int nr_frezii) {
        this.nr_frezii = nr_frezii;
    }

    public void setNr_lalele(int nr_lalele) {
        this.nr_lalele = nr_lalele;
    }

    public void setNr_bujori(int nr_bujori) {
        this.nr_bujori = nr_bujori;
    }

    public void setNr_verdeturi(int nr_verdeturi) {
        this.nr_verdeturi = nr_verdeturi;
    }

    public void setNr_cos_small(int nr_cos_small) {
        this.nr_cos_small = nr_cos_small;
    }

    public void setNr_cos_medium(int nr_cos_medium) {
        this.nr_cos_medium = nr_cos_medium;
    }

    public void setNr_cos_large(int nr_cos_large) {
        this.nr_cos_large = nr_cos_large;
    }
}
