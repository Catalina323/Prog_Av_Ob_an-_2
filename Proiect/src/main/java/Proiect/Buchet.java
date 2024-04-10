package Proiect;

public class Buchet implements PreturiVanzare, PreturiCumparare{

    private String nume;
    protected int trandafiri = 0;
    protected int frezii = 0;
    protected int hortensii = 0;
    protected int lalele = 0;
    protected int bujori = 0;
    protected boolean verdeata = false;

    public double CalculeazaPretVanzare(){
        double pretVerdeata;
        if(verdeata){
            pretVerdeata = pret_verdeata_v;
        }
        else{
            pretVerdeata = 0;
        }
        return trandafiri * pret_trandafir_v +
                frezii * pret_frezie_v +
                hortensii * pret_hortensie_v +
                lalele * pret_lalea_v +
                bujori * pret_bujor_v +
                pretVerdeata +
                5;  //pentru ambalaj si efort
    }

    public double CalculeazaPretProducere(){
        double pretVerdeata;
        if(verdeata){
            pretVerdeata = pret_verdeata_c;
        }
        else{
            pretVerdeata = 0;
        }
        return trandafiri * pret_trandafir_c +
                frezii * pret_frezie_c +
                hortensii * pret_hortensie_c +
                lalele * pret_lalea_c +
                bujori * pret_bujor_c +
                pretVerdeata;
    }

    @Override
    public String toString() {
        return "Buchet{" +
                "nume='" + nume + '\'' +
                '}';
    }

    public static class Builder{

        protected Buchet buchet = new Buchet();

        public Buchet build()
        {
            return this.buchet;
        }

        public Builder(String nume)
        {
            buchet.nume = nume;
        }

        public Builder withTrandafiri(int nr){
            buchet.trandafiri = nr;
            return this;
        }

        public Builder withFrezii(int nr){
            buchet.frezii = nr;
            return this;
        }

        public Builder withHortensii(int nr){
            buchet.hortensii = nr;
            return this;
        }

        public Builder withLalele(int nr){
            buchet.lalele = nr;
            return this;
        }

        public Builder withBujori(int nr){
            buchet.bujori = nr;
            return this;
        }

        public Builder withVerdeata(){
            buchet.verdeata = true;
            return this;
        }
    }


}


