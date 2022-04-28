package comparators;

import main.Proces;

import java.util.Comparator;

public class CompartorSJF implements Comparator<Proces> {
    @Override
    public int compare(Proces o1, Proces o2) {
        if (o1.getCzasDoKoncaWykon() == o2.getCzasDoKoncaWykon()) return 0;
        else if(o1.getCzasDoKoncaWykon() < o2.getCzasDoKoncaWykon()) return -1;
        else return 1;
    }
}
