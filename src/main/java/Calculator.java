public class Calculator {
    public int calculate(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else if (!numbers.contains(",")) {
            return Integer.parseInt(numbers);
        } else {
            String[] num = numbers.split(",");
            return Integer.parseInt(num[0]) + Integer.parseInt(num[1]);
        }
    }
}
