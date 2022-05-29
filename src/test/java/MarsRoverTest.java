import Rover.Grid;
import Rover.MarsRover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarsRoverTest {

    private Grid grid;

    @BeforeEach
    void setUp(){
        grid = new Grid(5,5);
    }

    @Test
    void should_return_12_when_given_11N_and_move() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.move(grid);
        assertEquals(1,marsRover.getX());
        assertEquals(2,marsRover.getY());
    }
    @Test
    void should_return_10_when_given_11S_and_move() {
        MarsRover marsRover = new MarsRover(1,1,"S");
        marsRover.move(grid);
        assertEquals(1,marsRover.getX());
        assertEquals(0,marsRover.getY());
    }
    @Test
    void should_return_01_when_given_11W_and_move() {
        MarsRover marsRover = new MarsRover(1,1,"W");
        marsRover.move(grid);
        assertEquals(0,marsRover.getX());
        assertEquals(1,marsRover.getY());
    }
    @Test
    void should_return_21_when_given_11E_and_move() {
        MarsRover marsRover = new MarsRover(1,1,"E");
        marsRover.move(grid);
        assertEquals(2,marsRover.getX());
        assertEquals(1,marsRover.getY());
    }
    @Test
    void should_return_55_when_given_55N_and_move() {
        MarsRover marsRover = new MarsRover(5,5,"N");
        marsRover.move(grid);
        assertEquals(5,marsRover.getX());
        assertEquals(5,marsRover.getY());
    }
    @Test
    void should_return_00_when_given_00S_and_move() {
        MarsRover marsRover = new MarsRover(0,0,"S");
        marsRover.move(grid);
        assertEquals(0,marsRover.getX());
        assertEquals(0,marsRover.getY());
    }
    @Test
    void should_return_00_when_given_00W_and_move() {
        MarsRover marsRover = new MarsRover(0,0,"W");
        marsRover.move(grid);
        assertEquals(0,marsRover.getX());
        assertEquals(0,marsRover.getY());
    }
    @Test
    void should_return_55_when_given_55E_and_move() {
        MarsRover marsRover = new MarsRover(5,5,"E");
        marsRover.move(grid);
        assertEquals(5,marsRover.getX());
        assertEquals(5,marsRover.getY());
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