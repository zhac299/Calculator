package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;

/**
 * Tests used in the development of the StrStack class.
 * 
 * @author Hassan Mirza
 */
class TestStrStack {

  /**
   * Test to see if a new StrStack can be created.
   */
  @Test
  void strsCreation() {
    StrStack strs = new StrStack();
  }
  
  /**
   * Test to see if Strings can be pushed onto the Stack.
   */
  @Test
  void strsPush() {
    StrStack strs = new StrStack();
    strs.push("foo");
  }
  
  /**
   * Test to see if the isEmpty function is working as intended.
   */
  @Test
  void strsIsEmpty() {
    StrStack strs = new StrStack();
    assertEquals(strs.isEmpty(), true);
  }

  
  /**
   * Test to see if the EmptyStackException is thrown.
   */
  @Test
  void strsPop0() {
    StrStack strs = new StrStack();
    try {
      strs.pop();
    } catch (EmptyStackException e) {
      System.out.println(e);
    }
  }
  
  /**
   * Test to see if the correct value is popped from the Stack.
   */
  @Test
  void strsPop1() {
    StrStack strs = new StrStack();
    strs.push("foo");
    
    if (!strs.pop().equals("foo")) { 
      fail("Incorrect value popped!");
    }
  }
  
  /**
   * Test to see if the size of the Stack changes.
   */
  @Test
  void strsPop2() {
    StrStack strs = new StrStack();
    strs.push("foo");
    
    assertEquals(strs.isEmpty(), false);
    
    strs.pop();
    
    assertEquals(strs.isEmpty(), true);
  }
}
