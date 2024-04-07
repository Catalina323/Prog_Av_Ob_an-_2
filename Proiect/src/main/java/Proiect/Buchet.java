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

        public Buchet build(){
            return this.buchet;
        }

        public Builder(String nume){
            buchet.nume = nume;
        }

        public Builder withTrandafir(int nr){
            buchet.trandafiri = new Trandafir[nr];
            return this;
        }

        public Builder withFrezie(int nr){
            buchet.frezii = new Frezie[nr];
            return this;
        }

        public Builder withHortensie(int nr){
            buchet.hortensii = new Hortensie[nr];
            return this;
        }





    }


}


