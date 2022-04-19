import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void should_return_0_when_input_is_empty() {
        assertEquals(0,calculator.calculate(""));
    }
}