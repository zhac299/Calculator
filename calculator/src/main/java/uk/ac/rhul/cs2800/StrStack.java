package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * Used to hold the Strings in the Stack.
 * 
 * @author Hassan Mirza
 */
public class StrStack {
  
  /**
   * strStack is the Stack which holds the String.
   */
  Stack strStack = new Stack();
  
  /**
   * Adds the String to the Stack.
   * 
   * @param str The String which is pushed to the Stack.
   */
  void push(String str) {
    Entry tempEntry = new Entry(str);
    strStack.push(tempEntry);
  }
  
  /**
   * Checks to see if the Stack is empty.
   * 
   * @return True or False dependent on if the Stack is empty or not.
   */
  boolean isEmpty() {
    return strStack.listSize == 0;
  }
  
  /**
   * Removes the last String added to the top of the Stack.
   * 
   * @return The last String added to the Stack.
   */
  String pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    } else {
      Entry tempEntry = strStack.pop();
      
      try {
        return tempEntry.getString();
      } catch (BadTypeException e) {
        System.out.println(e);
      }
    }
    return null;
  }

}
