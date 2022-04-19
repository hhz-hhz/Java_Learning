import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    public Integer calculate(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else if (numbers.endsWith(",|\n")) {
            throw new RuntimeException("Can not to using a separator at the end");
        } else if (numbers.startsWith("//")) {
            String[] num = numbers.substring(2).split("\n");
            String regex = num[0];
            if(regex.contains("|")){
                regex = regex.replaceAll("\\|","\\\\|");
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
//            List<String> temp = Arrays.stream(numbers.split(regex)).collect(Collectors.toList());
            return Arrays.stream(numbers.split(regex)).mapToInt(Integer::parseInt).sum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
