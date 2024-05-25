package Proiect.Domain;

import java.util.Comparator;
public class ComparatorAngajatData implements Comparator<Angajat>{

    public int compare(Angajat a1, Angajat a2) {
        return a1.getData_angajare().compareTo(a2.getData_angajare());
    }
}
