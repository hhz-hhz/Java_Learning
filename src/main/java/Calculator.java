import java.util.Arrays;

public class Calculator {
    public int calculate(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else if (!numbers.contains(",")) {
            return Integer.parseInt(numbers);
        } else {
            return Arrays.stream(numbers.split("[,\\n]")).mapToInt(Integer::parseInt).sum();
        }
    }
}
