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
    void should_return_10_when_given_11S_and_move() {
        MarsRover marsRover = new MarsRover(1,1,"S");
        marsRover.move();
        assertEquals(1,marsRover.getX());
        assertEquals(0,marsRover.getY());
    }
    @Test
    void should_return_01_when_given_11W_and_move() {
        MarsRover marsRover = new MarsRover(1,1,"W");
        marsRover.move();
        assertEquals(0,marsRover.getX());
        assertEquals(1,marsRover.getY());
    }
    @Test
    void should_return_21_when_given_11E_and_move() {
        MarsRover marsRover = new MarsRover(1,1,"E");
        marsRover.move();
        assertEquals(2,marsRover.getX());
        assertEquals(1,marsRover.getY());
    }
    @Test
    void should_return_E_when_given_11N_and_turn_R() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.turn("R");
        assertEquals("E", marsRover.getOrientation());
    }
    @Test
    void should_return_S_when_given_11E_and_turn_R() {
        MarsRover marsRover = new MarsRover(1,1,"E");
        marsRover.turn("R");
        assertEquals("S", marsRover.getOrientation());
    }
    @Test
    void should_return_W_when_given_11S_and_turn_R() {
        MarsRover marsRover = new MarsRover(1,1,"S");
        marsRover.turn("R");
        assertEquals("W", marsRover.getOrientation());
    }
    @Test
    void should_return_N_when_given_11W_and_turn_R() {
        MarsRover marsRover = new MarsRover(1,1,"W");
        marsRover.turn("R");
        assertEquals("N", marsRover.getOrientation());
    }
    @Test
    void should_return_W_when_given_11N_and_turn_L() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.turn("L");
        assertEquals("W", marsRover.getOrientation());
    }
    @Test
    void should_return_S_when_given_11W_and_turn_L() {
        MarsRover marsRover = new MarsRover(1,1,"W");
        marsRover.turn("L");
        assertEquals("S", marsRover.getOrientation());
    }
    @Test
    void should_return_E_when_given_11S_and_turn_L() {
        MarsRover marsRover = new MarsRover(1,1,"S");
        marsRover.turn("L");
        assertEquals("E", marsRover.getOrientation());
    }
    @Test
    void should_return_N_when_given_11E_and_turn_L() {
        MarsRover marsRover = new MarsRover(1,1,"E");
        marsRover.turn("L");
        assertEquals("N", marsRover.getOrientation());
    }

}