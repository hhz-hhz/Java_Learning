import NumberGame.NumberInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class NumberInputTest {
    private NumberInput numberInput;

    @BeforeEach
    void setUp() {
        numberInput = new NumberInput();
    }

    @Test
    void should_throw_exception_when_input_size_is_less_than_4() {
        Executable executable = () -> numberInput.validateInput("123");
        Exception exception = assertThrows(RuntimeException.class, executable);
        assertEquals("The input cannot be less than four digits", exception.getMessage());
    }

    @Test
    void should_throw_exception_when_input_is_not_number() {
        Executable executable = () -> numberInput.validateInput("123a");
        Exception exception = assertThrows(RuntimeException.class, executable);
        assertEquals("The input should be a number", exception.getMessage());
    }

    @Test
    void should_throw_exception_when_input_has_same_nums() {
        Executable executable = () -> numberInput.validateInput("1232");
        Exception exception = assertThrows(RuntimeException.class, executable);
        assertEquals("The input should be different", exception.getMessage());
    }
}