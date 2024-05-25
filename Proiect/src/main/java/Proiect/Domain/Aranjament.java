package Proiect.Domain;

public class Aranjament extends Buchet {

    private String nume;
    private Dimensiuni dimensiune;

    public double CalculeazaPretVanzare(){
        double pretVerdeata, pretCos;
        if(verdeata){
            pretVerdeata = pret_verdeata_v;
        }
        else{
            pretVerdeata = 0;
        }
        switch (dimensiune) {
            case Dimensiuni.SMALL : {
                pretCos = pret_cos_small_v;
            }
            case Dimensiuni.MEDIUM : {
                pretCos = pret_cos_medium_v;
            }
            case Dimensiuni.LARGE : {
                pretCos = pret_cos_large_v;
            }
            default : {
                pretCos = 0;
            }

        }
        return trandafiri * pret_trandafir_v +
                frezii * pret_frezie_v +
                hortensii * pret_hortensie_v +
                lalele * pret_lalea_v +
                bujori * pret_bujor_v +
                pretVerdeata +
                pretCos +
                5;
    }

    public double CalculeazaPretProducere(){
        double pretVerdeata, pretCos;
        if(verdeata){
            pretVerdeata = pret_verdeata_c;
        }
        else{
            pretVerdeata = 0;
        }
        switch (dimensiune) {
            case Dimensiuni.SMALL: {
                pretCos = pret_cos_small_c;
            }
            case Dimensiuni.MEDIUM: {
                pretCos = pret_cos_medium_c;
            }
            case Dimensiuni.LARGE: {
                pretCos = pret_cos_large_c;
            }
            default: {
                pretCos = 0;
            }
        }
        return trandafiri * pret_trandafir_c +
                frezii * pret_frezie_c +
                hortensii * pret_hortensie_c +
                lalele * pret_lalea_c +
                bujori * pret_bujor_c +
                pretVerdeata +
                pretCos;
    }


    @Override
    public String toString() {
        return "Aranjament{" +
                "nume='" + nume + '\'' +
                '}';
    }

    public Dimensiuni getDimensiune() {
        return dimensiune;
    }

    public void setDimensiune(Dimensiuni dimensiune) {
        this.dimensiune = dimensiune;
    }

    public static class Builder{

        protected Aranjament aranjament = new Aranjament();

        public Aranjament build()
        {
            return this.aranjament;
        }

        public Builder(String nume, Dimensiuni dim)
        {
            aranjament.nume = nume;
            aranjament.dimensiune = dim;
        }

        public Aranjament.Builder withTrandafiri(int nr){
            aranjament.trandafiri = nr;
            return this;
        }

        public Aranjament.Builder withFrezii(int nr){
            aranjament.frezii = nr;
            return this;
        }

        public Aranjament.Builder withHortensii(int nr){
            aranjament.hortensii = nr;
            return this;
        }

        public Aranjament.Builder withLalele(int nr){
            aranjament.lalele = nr;
            return this;
        }

        public Aranjament.Builder withBujori(int nr){
            aranjament.bujori = nr;
            return this;
        }

        public Aranjament.Builder withVerdeata(){
            aranjament.verdeata = true;
            return this;
        }
    }

}
