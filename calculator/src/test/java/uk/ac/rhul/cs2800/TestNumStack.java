package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;

/**
 * Tests used in the development of the NumStack class.
 * 
 * @author mirzm
 */
class TestNumStack {

  /**
   * Test to see if a new NumStack can be created.
   */
  @Test
  void nsCreation() {
      NumStack ns = new NumStack();
  }
  
  /**
   * Test to see if float values can be pushed onto the Stack.
   */
  @Test
  void nsPush() {
    NumStack ns = new NumStack();
    ns.push(0f);
  }
  
  /**
   * Test to see if the isEmpty function is working as intended.
   */
  @Test
  void nsIsEmpty() {
    NumStack ns = new NumStack();
    assertEquals(ns.isEmpty(), true);
  }

  
  /**
   * Test to see if the EmptyStackException is thrown.
   */
  @Test
  void nsPop0() {
    NumStack ns = new NumStack();
    try {
      try {
        ns.pop();
      } catch (BadTypeException e) {        
        e.printStackTrace();
      }
    } catch (EmptyStackException e) {
      System.out.println(e);
    }
  }
  
  /**
   * Test to see if the correct value is popped from the Stack.
   */
  @Test
  void nsPop1() {
    NumStack ns = new NumStack();
    ns.push(0f);
    
    try {
      if (ns.pop() != 0f) { 
        fail("Incorrect value popped!");
      }
    } catch (BadTypeException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Test to see if the size of the Stack changes.
   */
  @Test
  void nsPop2() {
    NumStack ns = new NumStack();
    ns.push(0f);
    
    assertEquals(ns.isEmpty(), false);
    
    try {
      ns.pop();
    } catch (BadTypeException e) {
      e.printStackTrace();
    }
    
    assertEquals(ns.isEmpty(), true);
  }
}
