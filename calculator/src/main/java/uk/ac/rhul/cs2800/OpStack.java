package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * Used to hold the Symbols in the Stack.
 * 
 * @author Hassan Mirza
 */
public class OpStack {
  
  /**
   * opStack is the Stack which holds the Symbols.
   */
  Stack opStack = new Stack();
  
  /**
   * Adds the Symbol to the Stack.
   * 
   * @param i The Symbol which is pushed to the Stack.
   */
  void push(Symbol i) {
    Entry tempEntry = new Entry(i);
    opStack.push(tempEntry);
  }
  
  /**
   * Checks to see if the Stack is empty.
   * 
   * @return True or False dependent on if the Stack is empty or not.
   */
  boolean isEmpty() {
    return opStack.listSize == 0;
  }
  
  /**
   * Removes the last Symbol added to the top of the Stack.
   * 
   * @return The last Symbol added to the Stack.
   */
  Symbol pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    } else {
      Entry tempEntry = opStack.pop();
      
      try {
        return tempEntry.getSymbol();
      } catch (BadTypeException e) {
        System.out.println(e);
      }
    }
    return null;
  }

}
