package main;

import java.util.Objects;
import java.util.Random;

public class Proces {
    private int czasDoKoncaWykon;
    private int czasPojawSystemie;

    public Proces(int ilosc) {
        Random rndm = new Random();
        this.czasDoKoncaWykon = rndm.nextInt(1, 15);
        this.czasPojawSystemie = rndm.nextInt(ilosc);
    }

    public Proces(Proces proces) {
        this.czasDoKoncaWykon = proces.getCzasDoKoncaWykon();
        this.czasPojawSystemie = proces.getCzasPojawSystemie();
    }
    public Proces(int czasDoKoncaWykon, int czasPojawSystemie)
    {
        this.czasDoKoncaWykon = czasDoKoncaWykon;
        this.czasPojawSystemie = czasPojawSystemie;
    }

    public int getCzasDoKoncaWykon() {
        return czasDoKoncaWykon;
    }

    public int getCzasPojawSystemie() {
        return czasPojawSystemie;
    }

    public void decreaseCzasDoKoncaWykon(int t) {
        this.czasDoKoncaWykon -= t;
    }

    @Override
    public String toString() {
        return "Czas pojawienia się procesu w systemie: " + czasPojawSystemie +
                ",  czas pozostały do końca wykonania: " + czasDoKoncaWykon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proces proces = (Proces) o;
        return czasDoKoncaWykon == proces.czasDoKoncaWykon && czasPojawSystemie == proces.czasPojawSystemie;
    }
}
