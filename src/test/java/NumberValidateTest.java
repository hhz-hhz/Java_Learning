import NumberGame.NumberValidate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidateTest {
    @Test
    void should_return_0A0B_when_input_is_different_from_actual() {
        NumberValidate NumberValidate = new NumberValidate();

        assertEquals("0A0B", NumberValidate.validateDigit("1234","5678"));
    }

    @Test
    void should_return_0A1B_when_input_is_different_from_actual() {
        NumberValidate NumberValidate = new NumberValidate();

        assertEquals("0A1B", NumberValidate.validateDigit("1234", "5671"));
    }

    @Test
    void should_return_1A0B_when_input_is_different_from_actual() {
        NumberValidate NumberValidate = new NumberValidate();

        assertEquals("1A0B", NumberValidate.validateDigit("1234", "1678"));
    }

    @Test
    void should_return_xAyB_when_input_is_different_from_actual() {
        NumberValidate NumberValidate = new NumberValidate();

        assertEquals("2A2B", NumberValidate.validateDigit("1234", "1324"));
    }

}