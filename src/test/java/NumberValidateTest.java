import NumberGame.NumberValidate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidateTest {
    NumberValidate numberValidate;

    @BeforeEach
    void setUp() {
        numberValidate = new NumberValidate();
    }

    @Test
    void should_return_0A0B_when_input_is_different_from_actual() {
        assertEquals("0A0B", numberValidate.validateDigit("1234","5678"));
    }

    @Test
    void should_return_0A1B_when_input_is_different_from_actual() {
        assertEquals("0A1B", numberValidate.validateDigit("1234", "5671"));
    }

    @Test
    void should_return_1A0B_when_input_is_different_from_actual() {
        assertEquals("1A0B", numberValidate.validateDigit("1234", "1678"));
    }

    @Test
    void should_return_xAyB_when_input_is_different_from_actual() {
        assertEquals("2A2B", numberValidate.validateDigit("1234", "1324"));
    }

}