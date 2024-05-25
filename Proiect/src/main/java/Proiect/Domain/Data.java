package Proiect.Domain;

public class Data implements Comparable<Data>{
    private int luna;
    private int an;

    public Data(int luna, int an) {
        this.luna = luna;
        this.an = an;
    }

    @Override
    public String toString() {
        return "Data{" +
                ", luna=" + luna +
                ", an=" + an +
                '}';
    }


    public int getLuna() {
        return luna;
    }

    public void setLuna(int luna) {
        this.luna = luna;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    @Override
    public int compareTo(Data o) {
        if(an == o.an){
            return luna - o.luna;
        }
        else {
            return an - o.an;
        }
    }
}
