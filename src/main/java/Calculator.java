import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {
    public Integer calculate(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else if (numbers.endsWith(",|\n")) {
            throw new RuntimeException("Can not to using a separator at the end");
        } else if (numbers.startsWith("//")) {
            String[] num = numbers.substring(2).split("\n");
            String regex = num[0];
            if (regex.contains("|")) {
                regex = regex.replaceAll("\\|", "\\\\|");
            }
            Matcher matcher = Pattern.compile("[^\\p{Digit}" + regex + "}]").matcher(num[1]);
            if (matcher.find()) {
                int index = matcher.start();
                throw new RuntimeException("‘" + num[0] + "’ expected but ‘" + num[1].charAt(index) + "’ found at position " + index + ".");
            }
            return getSum(num[1], regex);
        } else if (!numbers.contains(",")) {
            return Integer.parseInt(numbers);
        } else {
            return getSum(numbers, "[,\\n]");
        }
    }

    private Integer getSum(String numbers, String regex) {
        try {
            int[] negative = Arrays.stream(numbers.split(regex)).mapToInt(Integer::parseInt).filter(m -> m < 0).toArray();
            if (negative.length != 0) {
                throw new RuntimeException("Negative number(s) not allowed: " + Arrays.toString(negative));
            }
            return Arrays.stream(numbers.split(regex)).mapToInt(Integer::parseInt).sum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
