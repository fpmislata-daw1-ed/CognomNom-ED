package ud7.exercises;

import java.util.Scanner;
import java.util.Locale;

public class Math {
    public static int resta(int a, int b){
        return a - b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        int a = in.nextInt();
        int b = in.nextInt();
    }
}
