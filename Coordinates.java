package projet.src;

import java.util.*;


/**
 * Class Coordinates
 */
public class Coordinates {

  private int x;
  private int y;  
  
  public Coordinates (int abs, int ord){
	this.x = abs;
	this.y = ord;
  };
  
  /**
   * Set the value of x
   * @param newVar the new value of x
   */
  private void setX (int newVar) {
    x = newVar;
  }

  /**
   * Get the value of x
   * @return the value of x
   */
  private int getX () {
    return x;
  }

  /**
   * Set the value of y
   * @param newVar the new value of y
   */
  private void setY (int newVar) {
    y = newVar;
  }

  /**
   * Get the value of y
   * @return the value of y
   */
  private int getY () {
    return y;
  }
}
