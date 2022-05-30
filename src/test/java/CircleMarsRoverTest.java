import static org.junit.jupiter.api.Assertions.*;

import Rover.CircleMarsRover;
import Rover.Grid;
import Rover.MarsRover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircleMarsRoverTest {

  private Grid grid;

  @BeforeEach
  void setUp(){
    grid = new Grid(5,5);
  }

  @Test
  void should_return_50_when_given_55N_and_move() {
    MarsRover marsRover = new CircleMarsRover(5,5,"N");
    marsRover.move(grid);
    assertEquals(5,marsRover.getX());
    assertEquals(0,marsRover.getY());
  }
  @Test
  void should_return_05_when_given_00S_and_move() {
    MarsRover marsRover = new CircleMarsRover(0,0,"S");
    marsRover.move(grid);
    assertEquals(0,marsRover.getX());
    assertEquals(5,marsRover.getY());
  }
  @Test
  void should_return_50_when_given_00W_and_move() {
    MarsRover marsRover = new CircleMarsRover(0,0,"W");
    marsRover.move(grid);
    assertEquals(5,marsRover.getX());
    assertEquals(0,marsRover.getY());
  }
  @Test
  void should_return_05_when_given_55E_and_move() {
    MarsRover marsRover = new CircleMarsRover(5,5,"E");
    marsRover.move(grid);
    assertEquals(0,marsRover.getX());
    assertEquals(5,marsRover.getY());
  }

}