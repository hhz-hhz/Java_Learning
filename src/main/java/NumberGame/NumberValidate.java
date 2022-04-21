package NumberGame;

public class NumberValidate {
    public String validateDigit(String actual, String input) {
        //        HashSet<Integer> objects = new HashSet<>();
        //        actual.chars().forEach(objects::add);
        //        HashSet<Integer> objects1 = new HashSet<>();
        //        input.chars().forEach(objects1::add);
        //        long count = objects.stream().filter(objects1::contains).count();
        //        long countA = 0;
        //        for (int i = 0; i < 4; i++) {
        //            if(actual.charAt(i) == input.charAt(i)){
        //                countA++;
        //            }
        //        }
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
