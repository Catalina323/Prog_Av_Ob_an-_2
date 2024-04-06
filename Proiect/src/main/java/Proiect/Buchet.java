package Proiect;

public class Buchet {

    String nume;
    private Trandafir[] trandafiri = null;
    private Frezie[] frezii = null;
    private Hortensie[] hortensii = null;

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


