public class Calculator {
    public int calculate(String numbers){
        if(numbers.isEmpty()){
            return 0;
        }
        return Integer.parseInt(numbers);
    }
}
