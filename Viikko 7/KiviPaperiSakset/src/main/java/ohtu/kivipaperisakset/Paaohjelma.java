package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        IO io = new PeliIO(scanner);
        Pelitehdas pelitehdas = new Pelitehdas(io);

        pelitehdas.suorita();

    }


}
