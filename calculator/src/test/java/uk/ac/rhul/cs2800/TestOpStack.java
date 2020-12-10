package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;

/**
 * Tests used in the development of the OpStack class.
 * 
 * @author Hassan Mirza
 */
class TestOpStack {

  /**
   * Test to see if a new OpStack can be created.
   */
  @Test
  void opsCreation() {
    OpStack ops = new OpStack();
  }
  
  /**
   * Test to see if Symbols can be pushed onto the Stack.
   */
  @Test
  void opsPush() {
    OpStack ops = new OpStack();
    ops.push(Symbol.DIVIDE);
  }
  
  /**
   * Test to see if the isEmpty function is working as intended.
   */
  @Test
  void opsIsEmpty() {
    OpStack ops = new OpStack();
    assertEquals(ops.isEmpty(), true);
  }

  
  /**
   * Test to see if the EmptyStackException is thrown.
   */
  @Test
  void opsPop0() {
    OpStack ops = new OpStack();
    try {
      ops.pop();
    } catch (EmptyStackException e) {
      System.out.println(e);
    }
  }
  
  /**
   * Test to see if the correct value is popped from the Stack.
   */
  @Test
  void opsPop1() {
    OpStack ops = new OpStack();
    ops.push(Symbol.DIVIDE);
    
    if (ops.pop() != Symbol.DIVIDE) { 
      fail("Incorrect value popped!");
    }
  }
  
  /**
   * Test to see if the size of the Stack changes.
   */
  @Test
  void opsPop2() {
    OpStack ops = new OpStack();
    ops.push(Symbol.DIVIDE);
    
    assertEquals(ops.isEmpty(), false);
    
    ops.pop();
    
    assertEquals(ops.isEmpty(), true);
  }
}
