package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;
/**
 * Used to hold the numeric values in the Stack.
 * 
 * @author mirzm
 */

public class NumStack {
  /**
   * numStack is the Stack which holds the numeric values.
   */
  private Stack numStack = new Stack();
  
  /**
   * Adds the numeric value to the Stack.
   * 
   * @param i The numeric value held in the Stack. 
   */
  void push(float i) {
    Entry newEntry = new Entry(i);
    numStack.push(newEntry);
  }
  
  /**
   * Checks to see if the Stack is empty.
   * 
   * @return True or False dependent on if the Stack is empty or not.
   */
  boolean isEmpty() {
    return numStack.size() == 0;
  }
  
  /**
   * Removes the last numeric value added to the Stack and returns it.
   * 
   * @return The last numeric value added to the Stack.
   * @throws BadTypeException If the value is not numeric.
   */
  float pop() throws BadTypeException {
    if (numStack.listSize == 0) {
      throw new EmptyStackException();
    } else {
      Entry ne = numStack.pop();
      
      return ne.getValue();
    }
  }

}
