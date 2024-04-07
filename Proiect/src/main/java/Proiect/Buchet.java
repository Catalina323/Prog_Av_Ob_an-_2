package Proiect;

public class Buchet {

    private String nume;
    private int trandafiri;
    private int frezii;
    private int hortensii;
    private int lalele;
    private int bujori;
    private boolean verdeata;

    public static class Builder{

        private Buchet buchet = new Buchet();

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


