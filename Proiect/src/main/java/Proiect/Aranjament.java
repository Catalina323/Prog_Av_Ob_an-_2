package Proiect;

public class Aranjament extends Buchet{

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

    public Aranjament(String nume, Dimensiuni dimensiune) {
        this.nume = nume;
        this.dimensiune = dimensiune;
    }
}
