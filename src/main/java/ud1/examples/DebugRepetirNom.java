package ud1.examples;

public class DebugRepetirNom {
    public static void main(String[] args) {
        String name = "Nom";
        String surname = "Cognom";
        int repeticions = 100;

        for (int i = 0; i < repeticions; i++) {
            System.out.printf("%d. %s %s\n", i, name, surname);
        }
    }
}