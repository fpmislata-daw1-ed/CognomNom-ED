package ud4.exercises.staticmethods;

import java.util.Locale;
import java.util.Scanner;

public class Collatz {
    public static int collatz(int n){
        int counter = 0;

        while (n != 1) {
            if(n % 2 == 0)
                n = n / 2;
            else
                n = 3 * n + 1;
            counter++;
        }
         return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Introdueix un número: ");
        int inicial = in.nextInt();

        int counter = collatz(inicial);

        System.out.printf("S'ha arribat del %d al 1 després de %d passos.\n", inicial, counter);
    }
}