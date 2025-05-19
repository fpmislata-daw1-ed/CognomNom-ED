package ud7.exercises;

import java.util.Scanner;
import java.util.Locale;

public class Math {
    public static int suma(int a, int b) {
        return a + b;
    }
    public static int resta(int a, int b){
        return a - b;
    }
    public static int multiplicacio(int a,  int b){
        return a * b;
    }
    public static int divisio(int a, int b){
        return a / b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        int a = in.nextInt();
        int b = in.nextInt();

        int suma = suma(a, b);
        int resta = resta(a, b);
        int divisio = divisio(a, b);
        int mult = multiplicacio(a, b);

        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicació: " + mult);
        System.out.println("Divisió:" + divisio);
    }
}
