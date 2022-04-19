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
        assertEquals(0, calculator.calculate(""));
    }

    @Test
    void should_return_1_when_input_is_1() {
        assertEquals(1, calculator.calculate("1"));
    }

    @Test
    void should_return_num_when_input_is_a_num() {
        assertEquals(3, calculator.calculate("3"));
    }

    @Test
    void should_return_sum_when_input_is_two_nums() {
        assertEquals(3, calculator.calculate("1,2"));
    }

    @Test
    void should_return_sum_when_input_is_an_unknown_number_of_arguments() {
        assertEquals(45, calculator.calculate("1,2,3,4,5,6,7,8,9"));
    }

    @Test
    void should_return_sum_when_input_is_using_newlines_as_separators() {
        assertEquals(45, calculator.calculate("1,2,3,4,5\n6,7\n8,9"));
    }

    @Test
    void should_throw_exception_when_input_is_using_two_separators() {
        try {
            calculator.calculate("1,2,3,4,5,\n6,7\n8,9");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "");
        }
    }

    @Test
    void should_throw_exception_when_input_is_using_separators_in_the_end() {
        try {
            calculator.calculate("1,2,3,4,5,\n6,7\n8,9,\n");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Can not to using a separator at the end");
        }
    }

    @Test
    void should_return_sum_when_using_different_delimiters() {
        assertEquals(6, calculator.calculate("//sqp\n1sqp2sqp3"));
    }

    @Test
    void should_return_sum_when_using_special_delimiters() {
        assertEquals(6, calculator.calculate("//|\n1|2|3"));
    }

    @Test
    void should_throw_exception_when_input_is_using_wrong_separators() {
        try {
            calculator.calculate("//|\n1|2,-3");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "‘|’ expected but ‘,’ found at position 3.");
        }
    }

    @Test
    void should_throw_exception_when_input_is_using_negative_number() {
        try {
            calculator.calculate("2,-4,-9");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Negative number(s) not allowed: -4, -9");
        }
    }

    @Test
    void should_throw_exception_with_all_error_message() {
        try {
            calculator.calculate("//|\n1|2,-3");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Negative number(s) not allowed: -3\n‘|’ expected but ‘,’ found at position 3.");
        }
    }

    @Test
    void should_return_sum_without_add_number_bigger_than_1000() {
        assertEquals(3, calculator.calculate("//sqp\n1sqp2sqp300000"));
    }
}