package NumberGame;

public class NumberInput {
    public void validateInput(String input){
        if(input.length() < 4){
            throw new RuntimeException("The input cannot be less than four digits");
        }
    }
}
