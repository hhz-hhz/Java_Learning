package NumberGame;

import java.util.stream.IntStream;

public class NumberInput {
    public void validateInput(String input){
        if(input.length() < 4){
            throw new RuntimeException("The input cannot be less than four digits");
        }else if(!input.chars().allMatch(Character::isDigit)){
            throw new RuntimeException("The input should be a number");
        }else if(input.chars().distinct().count() < 4){
            throw new RuntimeException("The input should be different");
        }
    }
}
