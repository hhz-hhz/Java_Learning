package StringCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public Integer calculate(String numbers) {
//        String message = "";
        List<String> message = new ArrayList<>();
        if (numbers.isEmpty()) {
            return 0;
        } else if (numbers.startsWith("//")) {
            String[] num = numbers.substring(2).split("\n");
            String regex = num[0];
            message.add(validateEndSeparator(numbers, regex));
            message.add(getNegativeNumbers(numbers));
            message.addAll(validateSeparator(regex, num[1]));
            regex = getRegex(regex);
            message.removeAll(Collections.singleton(null));
            return getSum(num[1], regex, message);
        } else if (numbers.chars().allMatch(Character::isDigit)) {
            return Integer.parseInt(numbers);
        } else {
            message.add(validateEndSeparator(numbers, ","));
            message.add(validateEndSeparator(numbers, "\n"));
            message.add(getNegativeNumbers(numbers));
            message.addAll(validateSeparator(",\\n", numbers));
            message.removeAll(Collections.singleton(null));
            return getSum(numbers, "[,\\n]", message);
        }
    }

    private List<String> validateSeparator(String regex, String numbers) {
        List<String> message = new ArrayList<>();
        String regexString = (regex.equals(",\\n") ? ",' or newlines" : regex);
        regex = getRegex(regex);
        Matcher matcher = Pattern.compile("[^-?\\p{Digit}" + regex + "]").matcher(numbers);
        while (matcher.find()) {
            int index = matcher.start();
            message.add("‘" + regexString +
                    "’ expected but ‘" + numbers.charAt(index) + "’ found at position " + index + ".");
        }
        return message;
    }

    private String getRegex(String regex) {
        if (regex.contains("|")) {
            regex = regex.replaceAll("\\|", "\\\\|");
        }
        return regex;
    }

    private String validateEndSeparator(String numbers, String separator) {
        if (numbers.endsWith(separator)) {
            return "Can not to using a separator at the end";
        }
        return null;
    }

    private Integer getSum(String numbers, String regex, List<String> message) {
        try {
            if (message.size() != 0) {
                throw new RuntimeException(String.join("\n", message));
            }
            return Arrays.stream(numbers.split(regex)).mapToInt(Integer::parseInt).filter(m -> m <= 1000).sum();
        } catch (NumberFormatException e) {
            throw new NumberFormatException("");
        }
    }

    private String getNegativeNumbers(String numbers) {
        Matcher matcher = Pattern.compile("-\\p{Digit}").matcher(numbers);
        StringBuilder negative = new StringBuilder();
        while (matcher.find()) {
            negative.append((!negative.toString().equals("")) ? ", " : "").append(matcher.group());
        }
        if (!negative.toString().equals("")) {
            return "Negative number(s) not allowed: " + negative;
        }
        return null;
    }
}
