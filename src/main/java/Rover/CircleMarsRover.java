package Rover;


public class CircleMarsRover extends MarsRover{

  public CircleMarsRover(int x, int y, String orientation) {
    super(x, y, orientation);
  }


  @Override
  public void borderMove(Grid grid){
    x = (x < 0 ? grid.getWidth() : (x > grid.getWidth() ? 0 : x));
    y = (y < 0 ? grid.getHeight() : (y > grid.getHeight() ? 0 : y));
  }
}
