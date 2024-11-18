package ud2.exercises;

import java.util.Scanner;
import java.util.Locale;

public class BasicOperations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        int a = in.nextInt();
        int b = in.nextInt();

        int suma = a + b;
        int resta = a - b;
        int multiplicacio = a * b;

        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicació: " + multiplicacio);
    }
}
