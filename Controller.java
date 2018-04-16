package projet.src;

import java.util.*;


/**
 * Class Controller
 * Mediator
 */
public class Controller {

  //
  // Fields
  //

  private View view;
  private ShapeAbstractFactory shapeFactory;
  private ArrayList<Command> stack;
  
  //
  // Constructors
  //
  public Controller () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of view
   * @param newVar the new value of view
   */
  private void setView (View newVar) {
    view = newVar;
  }

  /**
   * Get the value of view
   * @return the value of view
   */
  private View getView () {
    return view;
  }

  /**
   * Set the value of shapeFactory
   * @param newVar the new value of shapeFactory
   */
  private void setShapeFactory (ShapeAbstractFactory newVar) {
    shapeFactory = newVar;
  }

  /**
   * Get the value of shapeFactory
   * @return the value of shapeFactory
   */
  private ShapeAbstractFactory getShapeFactory () {
    return shapeFactory;
  }

  /**
   * Set the value of stack
   * @param newVar the new value of stack
   */
  private void setStack (ArrayList<Command> newVar) {
    stack = newVar;
  }

  /**
   * Get the value of stack
   * @return the value of stack
   */
  private ArrayList<Command> getStack () {
    return stack;
  }

  //
  // Other methods
  //

}
