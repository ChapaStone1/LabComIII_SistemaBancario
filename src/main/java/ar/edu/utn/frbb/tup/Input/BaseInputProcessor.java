package ar.edu.utn.frbb.tup.Input;

import java.util.Scanner;

public class BaseInputProcessor {

    protected Scanner scanner = new Scanner(System.in);
    protected static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
