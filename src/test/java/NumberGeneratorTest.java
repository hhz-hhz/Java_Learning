import NumberGame.NumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {
    @Test
    void should_return_four_digit_string() {
        //given
        NumberGenerator numberGenerator = new NumberGenerator();

        //when
        String generate = numberGenerator.generate();

        //then
        assertEquals(4, generate.length());
    }

    @Test
    void should_return_four_digit_is_number_string() {
        //given
        NumberGenerator numberGenerator = new NumberGenerator();

        //when
        String generate = numberGenerator.generate();

        //then
        boolean b = generate.chars().allMatch(Character::isDigit);
        assertTrue(b);
    }

    @Test
    void should_return_four_digit_is_different() {
        //given
        NumberGenerator numberGenerator = new NumberGenerator();

        //when
        String generate = numberGenerator.generate();

        //then
        HashSet<Character> characters = new HashSet<>();
        generate.chars().forEach(x -> characters.add((char) x));
        assertEquals(4,characters.size());
    }

    @Test
    void should_return_different_number() {
        NumberGenerator numberGenerator = new NumberGenerator();

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            String generate = numberGenerator.generate();
            set.add(generate);
        }
        assertEquals(3,set.size());
    }

}