package main;

import java.util.ArrayList;

public class Tests {
    public void startTest(Procesy procesy)
    {
        System.out.println("Ilość procesów: " + procesy.getProcesy().size());

        System.out.println("średni czas oczekiwania, FCFS: " + procesy.startFCFS() / procesy.getProcesy().size());
        System.out.println("średni czas oczekiwania, SJF: " + procesy.startSJF() / procesy.getProcesy().size());
        System.out.println("średni czas oczekiwania, SRTF: " + procesy.startSRTF() / procesy.getProcesy().size());
        System.out.println("średni czas oczekiwania, rotacyjny: " + procesy.startRotacyjny() / procesy.getProcesy().size() + "\n");


    }
}
