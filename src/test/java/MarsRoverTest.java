import Rover.MarsRover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarsRoverTest {
    @Test
    void should_return_12_when_given_11N_and_move() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.move();
        assertEquals(1,marsRover.getX());
        assertEquals(2,marsRover.getY());
    }

    @Test
    void should_return_E_when_given_11N_and_turn_r() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.turn("R");
        assertEquals("E", marsRover.getOrientation());
    }
}