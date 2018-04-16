package projet.src;


/**
 * Class Color
 */
public class Color {

  private int r;
  private int g;
  private int b;

  public Color (int red, int green, int blue) {
	this.r = red;
	this.g = green;
	this.b = blue;
  };

  /**
   * Set the value of r
   * @param newVar the new value of r
   */
  private void setR (int newVar) {
    r = newVar;
  }

  /**
   * Get the value of r
   * @return the value of r
   */
  private int getR () {
    return r;
  }

  /**
   * Set the value of g
   * @param newVar the new value of g
   */
  private void setG (int newVar) {
    g = newVar;
  }

  /**
   * Get the value of g
   * @return the value of g
   */
  private int getG () {
    return g;
  }

  /**
   * Set the value of b
   * @param newVar the new value of b
   */
  private void setB (int newVar) {
    b = newVar;
  }

  /**
   * Get the value of b
   * @return the value of b
   */
  private int getB () {
    return b;
  }
}
