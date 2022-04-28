package comparators;

import main.Proces;

import java.util.Comparator;

public class ComparatorFCFS implements Comparator<Proces> {

    @Override
    public int compare(Proces o1, Proces o2) {
        if (o1.getCzasPojawSystemie() == o2.getCzasPojawSystemie()) return 0;
        else if(o1.getCzasPojawSystemie() < o2.getCzasPojawSystemie()) return -1;
        else return 1;
    }
}
