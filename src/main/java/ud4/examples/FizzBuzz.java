package ud4.examples;

public class FizzBuzz {
    public String transform(int n){
        if (n % 15 == 0)
            return "FizzBuzz";
        else if (n % 3 == 0)
            return "Fizz";
        else if (n % 5 == 0)
            return "Buzz";

        return String.valueOf(n);
    }
}
