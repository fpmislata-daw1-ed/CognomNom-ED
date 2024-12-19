package ud4.exercises.staticmethods;

public class NextSecond {
    public static String nextSecond(int hores, int minuts, int segons){
        segons += 1;
        if (segons >= 60) {
            segons -= 60;
            minuts += 1;
        }
        return String.format("%02d:%02d:%02d", hores, minuts, segons);
    }

}
