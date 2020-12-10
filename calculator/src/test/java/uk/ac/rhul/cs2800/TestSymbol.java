package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests used to develop the enum class Symbol.
 * 
 * @author Hassan Mirza.
 */
class TestSymbol {

  /**
   * Test to see if enum value of LEFT_BRACKET is what it is expected to be.
   */
  @Test
  void testLeftBracket() {
    assertEquals("LEFT_BRACKET", Symbol.LEFT_BRACKET.toString());
  }

  /**
   * Test to see if enum value of RIGHT_BRACKET is what it is expected to be.
   */
  @Test
  void testRightBracket() {
    assertEquals("RIGHT_BRACKET", Symbol.RIGHT_BRACKET.toString());
  }

  /**
   * Test to see if enum value of TIMES is what it is expected to be.
   */
  @Test
  void testTimes() {
    assertEquals("TIMES", Symbol.TIMES.toString());
  }

  /**
   * Test to see if enum value of DIVIDE is what it is expected to be.
   */
  @Test
  void testDivide() {
    assertEquals("DIVIDE", Symbol.DIVIDE.toString());
  }

  /**
   * Test to see if enum value of PLUS is what it is expected to be.
   */
  @Test
  void testPlus() {
    assertEquals("PLUS", Symbol.PLUS.toString());
  }

  /**
   * Test to see if enum value of MINUS is what it is expected to be.
   */
  @Test
  void testMinus() {
    assertEquals("MINUS", Symbol.MINUS.toString());
  }

  /**
   * Test to see if enum value of INVALID is what it is expected to be.
   */
  @Test
  void testInvalid() {
    assertEquals("INVALID", Symbol.INVALID.toString());
  }

}
