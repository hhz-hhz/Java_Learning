package NumberGame;

//import java.util.concurrent.atomic.AtomicInteger;

public class NumberValidate {
    public String validateDigit(String actual, String input) {
//        //without using for
//        long count = actual.chars().filter(m -> input.contains((char)m+"")).count();
//        AtomicInteger i = new AtomicInteger();
//        long countA = actual.chars().filter(m -> (char)m == input.charAt(i.getAndIncrement())).count();
//        return countA+"A"+(count-countA)+"B";

        //using for
        int countA = 0, countB = 0;
        for (int i = 0; i < 4; i++) {
            if (input.contains(actual.charAt(i) + "")) {
                if (actual.charAt(i) == input.charAt(i)) {
                    countA++;
                } else {
                    countB++;
                }
            }
        }
        return countA + "A" + countB + "B";

    }
}
