package StringCalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public Integer calculate(String numbers) {
        String message = "";
        if (numbers.isEmpty()) {
            return 0;
        } else if (numbers.startsWith("//")) {
            String[] num = numbers.substring(2).split("\n");
            String regex = num[0];
            message = validateEndSeparator(numbers, regex, message);
            message = getNegativeNumbers(numbers, message);
            message = validateSeparator(regex,num[1],message);
            regex = getRegex(regex);
            return getSum(num[1], regex, message);
        } else if (!numbers.contains(",")) {
            return Integer.parseInt(numbers);
        } else {
            message = validateEndSeparator(numbers, ",", message);
            message = validateEndSeparator(numbers, "\n", message);
            message = getNegativeNumbers(numbers, message);
            message = validateSeparator(",\\n", numbers, message);
            return getSum(numbers, "[,\\n]", message);
        }
    }

    private String validateSeparator(String regex, String numbers, String message){
        String regexString  = (regex.equals(",\\n")? ",' or newlines":regex);
        regex = getRegex(regex);
        Matcher matcher = Pattern.compile("[^-?\\p{Digit}" + regex + "]").matcher(numbers);
        while (matcher.find()) {
            int index = matcher.start();
            message = (message.equals("") ? message : message + "\n") + "‘" + regexString +
                    "’ expected but ‘" + numbers.charAt(index) + "’ found at position " + index + ".";
        }
        return message;
    }

    private String getRegex(String regex) {
        if (regex.contains("|")) {
            regex = regex.replaceAll("\\|", "\\\\|");
        }
        return regex;
    }

    private String validateEndSeparator(String numbers, String separator, String message) {
        if (numbers.endsWith(separator)) {
            message = (message.equals("") ? message : message + "\n") + "Can not to using a separator at the end";
        }
        return message;
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

    private String getNegativeNumbers(String numbers, String message) {
        Matcher matcher = Pattern.compile("-\\p{Digit}").matcher(numbers);
        StringBuilder negative = new StringBuilder();
        while (matcher.find()) {
            negative.append((!negative.toString().equals("")) ? ", " : "").append(matcher.group());
        }
        if (!negative.toString().equals("")) {
            message = (message.equals("") ? message : message + "\n") + "Negative number(s) not allowed: " + negative;
        }
        return message;
    }
}
