package ohtu.kivipaperisakset;

import java.util.Scanner;

public class PeliIO implements IO {

    private Scanner scanner;

    PeliIO(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public void println(String m) {
        System.out.println(m);
    }

    @Override
    public void print(String m) {
        System.out.print(m);
    }

}
