package main;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

         Tests tests = new Tests();
         tests.startTest(new Procesy());
         tests.startTest(new Procesy(20));
        tests.startTest(new Procesy(100));
        tests.startTest(new Procesy(300));
        tests.startTest(new Procesy(1000));

    }
}
