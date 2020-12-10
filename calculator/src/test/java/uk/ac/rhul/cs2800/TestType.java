package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests used to develop the Type enum.
 * 
 * @author Hassan Mirza.
 */
class TestType {

  /**
   * Test to see if enum value of NUMBER is what it is expected to be.
   */
  @Test
  void testNumber() {
    assertEquals("NUMBER", Type.NUMBER.toString());
  }

  /**
   * Test to see if enum value of SYMBOL is what it is expected to be.
   */
  @Test
  void testSymbol() {
    assertEquals("SYMBOL", Type.SYMBOL.toString());
  }

  /**
   * Test to see if enum value of STRING is what it is expected to be.
   */
  @Test
  void testString() {
    assertEquals("STRING", Type.STRING.toString());
  }

  /**
   * Test to see if the value of INVALID is what it is expected to be.
   */
  @Test
  void testInvalid() {
    assertEquals("INVALID", Type.INVALID.toString());
  }

}
