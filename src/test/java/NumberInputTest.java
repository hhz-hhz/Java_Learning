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
}