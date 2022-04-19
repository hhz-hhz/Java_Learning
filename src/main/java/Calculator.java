import java.util.Arrays;

public class Calculator {
    public int calculate(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }else if(numbers.endsWith(",|\n")){
            throw new RuntimeException("Can not to using a separator at the end");
        }else if (!numbers.contains(",")) {
            return Integer.parseInt(numbers);
        } else {
            try {
                return Arrays.stream(numbers.split("[,\\n]")).mapToInt(Integer::parseInt).sum();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
