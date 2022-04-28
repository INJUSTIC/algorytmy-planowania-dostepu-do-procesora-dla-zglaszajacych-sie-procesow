package main;

import comparators.ComparatorFCFS;
import comparators.CompartorSJF;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public class Procesy {
    private ArrayList<Proces> procesy = new ArrayList<>();

    public Procesy(int ilosc) {
        for (int i = 0; i < ilosc; i++)
            this.procesy.add(new Proces(ilosc));
    }
    public Procesy()
    {
        procesy.add(new Proces(4,0));
        procesy.add(new Proces(6,3));
        procesy.add(new Proces(4,10));
        procesy.add(new Proces(2,10));
        procesy.add(new Proces(1,11));

    }
    public ArrayList<Proces> getProcesy() {
        return procesy;
    }

    public double startFCFS() {
        ArrayList<Proces> procesyCopy = new ArrayList<>();
        for (Proces proces: procesy) {
            procesyCopy.add(new Proces(proces));
        }
        ArrayList<Proces> availableProcesy = new ArrayList<>();
        int t = 0, czasOczSum = 0;

        while (procesyCopy.size() != 0 || availableProcesy.size() != 0) {
            updateAvailible(procesyCopy, availableProcesy, t);
            if (availableProcesy.size() != 0)
            {
                var dt = availableProcesy.get(0).getCzasDoKoncaWykon();
                for (int i = 0; i < dt; i++) {
                    updateAvailible(procesyCopy, availableProcesy, t);
                    czasOczSum += (availableProcesy.size() - 1);
                    t++;
                }
                availableProcesy.remove(0);
            }
            else {
                t++;
            }
        }

        return czasOczSum;
    }

    public double startSJF() {
        ArrayList<Proces> procesyCopy = new ArrayList<>();
        for (Proces proces: procesy) {
            procesyCopy.add(new Proces(proces));
        }
        ArrayList<Proces> availableProcesy = new ArrayList<>();
        int t = 0, czasOczSum = 0;

        while (procesyCopy.size() != 0 || availableProcesy.size() != 0) {
            updateAvailible(procesyCopy, availableProcesy, t);
            Collections.sort(availableProcesy, new CompartorSJF());
            if (availableProcesy.size() != 0)
            {
                var dt = availableProcesy.get(0).getCzasDoKoncaWykon();
                for (int i = 0; i < dt; i++) {
                    updateAvailible(procesyCopy, availableProcesy, t);
                    czasOczSum += (availableProcesy.size() - 1);
                    t++;
                }
                availableProcesy.remove(0);
            }
            else {
                t++;
            }
        }
        return czasOczSum;
    }

    public double startSRTF() {
        ArrayList<Proces> procesyCopy = new ArrayList<>();
        for (Proces proces: procesy) {
            procesyCopy.add(new Proces(proces));
        }
        ArrayList<Proces> availableProcesy = new ArrayList<>();
        int t = 0, czasOczSum = 0;

        while (procesyCopy.size() != 0 || availableProcesy.size() != 0) {
            updateAvailible(procesyCopy, availableProcesy, t);
            if (availableProcesy.size() != 0) {
                for (int i = 0; i < availableProcesy.size(); i++) {
                    updateAvailible(procesyCopy, availableProcesy, t);
                    Collections.sort(availableProcesy, new CompartorSJF());
                    availableProcesy.get(0).decreaseCzasDoKoncaWykon(1);
                    czasOczSum += availableProcesy.size() - 1;
                    if (availableProcesy.get(0).getCzasDoKoncaWykon() == 0) {
                        availableProcesy.remove(0);
                        i--;
                    }
                    t++;
                }
            }
            else {
                t++;
            }
        }
        return czasOczSum;
    }

    public double startRotacyjny() {
        ArrayList<Proces> procesyCopy = new ArrayList<>();
        for (Proces proces: procesy) {
            procesyCopy.add(new Proces(proces));
        }
        ArrayList<Proces> procesyCopy2 = new ArrayList<>();
        for (Proces proces: procesy) {
            procesyCopy2.add(new Proces(proces));
        }
        ArrayList<Proces> availableProcesy = new ArrayList<>();
        int t = 0, deltaT = 1, czasOczSum = 0;
        while (procesyCopy.size() != 0 || availableProcesy.size() != 0) {
            updateAvailible(procesyCopy, availableProcesy, t);
            if (availableProcesy.size() != 0) {
                for (int i = 0; i < availableProcesy.size(); i++) {
                    t += deltaT;
                    availableProcesy.get(i).decreaseCzasDoKoncaWykon(deltaT);
                    czasOczSum += availableProcesy.size() - 1;
                    if (availableProcesy.get(i).getCzasDoKoncaWykon() <= 0) {
                        availableProcesy.remove(i);
                        i--;
                    }
                    updateAvailible(procesyCopy, availableProcesy, t);
                }
            }
            else {
                t++;
            }
        }

        return czasOczSum;
    }

    private void updateAvailible(ArrayList<Proces> proc, ArrayList<Proces> aval,int t) {
        for (int i = 0; i < proc.size(); i++) {
            if (proc.get(i).getCzasPojawSystemie() <= t) {
                aval.add(proc.get(i));
                proc.remove(i);
                i--;
            }
        }
    }


}
