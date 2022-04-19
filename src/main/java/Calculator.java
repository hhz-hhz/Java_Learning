import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            String message = "";
            if (matcher.find()) {
                int index = matcher.start();
                message = "‘" + num[0] + "’ expected but ‘" + num[1].charAt(index) + "’ found at position " + index + ".";
            }
            return getSum(num[1], regex, message);
        } else if (!numbers.contains(",")) {
            return Integer.parseInt(numbers);
        } else {
            return getSum(numbers, "[,\\n]", "");
        }
    }

    private Integer getSum(String numbers, String regex, String message) {
        try {
            int[] negative = Arrays.stream(numbers.split(regex)).mapToInt(Integer::parseInt).filter(m -> m < 0).toArray();
            if (negative.length != 0) {
                message = "Negative number(s) not allowed: " + Arrays.toString(negative) + message;
            }
            if (!message.isEmpty()) {
                throw new RuntimeException(message);
            }
            return Arrays.stream(numbers.split(regex)).mapToInt(Integer::parseInt).filter(m -> m <= 1000).sum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
