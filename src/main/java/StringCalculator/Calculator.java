package StringCalculator;

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
            Matcher matcher = Pattern.compile("[^-?\\p{Digit}" + regex + "]").matcher(num[1]);
            String message = getNegativeNumbers(numbers);
            while (matcher.find()) {
                int index = matcher.start();
                message = (message.equals("") ? message : message + "\n") + "‘" + num[0] +
                        "’ expected but ‘" + num[1].charAt(index) + "’ found at position " + index + ".";
            }
            return getSum(num[1], regex, message);
        } else if (!numbers.contains(",")) {
            return Integer.parseInt(numbers);
        } else {
            String message = getNegativeNumbers(numbers);
            return getSum(numbers, "[,\\n]", message);
        }
    }

    private Integer getSum(String numbers, String regex, String message) {
        try {
            if (message.length() != 0) {
                throw new RuntimeException(message);
            }
            return Arrays.stream(numbers.split(regex)).mapToInt(Integer::parseInt).filter(m -> m <= 1000).sum();
        } catch (NumberFormatException e) {
            throw new NumberFormatException("");
        }
    }

    private String getNegativeNumbers(String numbers) {
        String message = "";
        Matcher matcher = Pattern.compile("-\\p{Digit}").matcher(numbers);
        StringBuilder negative = new StringBuilder();
        while (matcher.find()) {
            negative.append((!negative.toString().equals("")) ? ", " : "").append(matcher.group());
        }
        if (!negative.toString().equals("")) {
            message = "Negative number(s) not allowed: " + negative;
        }
        return message;
    }
}
