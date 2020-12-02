package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tests used to develop the Entry class.
 * 
 * @author Hassan Mirza.
 */
class TestEntry {

  /**
   * Test to see if a new Entry object can be created with a float parameter.
   */
  @Test
  void teCreation0() {
    Entry te = new Entry(0f);
  }

  /**
   * Test to see if a new Entry object can be created with a Symbol parameter.
   */
  @Test
  void teCreation1() {
    Entry te = new Entry(Symbol.DIVIDE);
  }

  /**
   * Test to see if a new Entry object can be created with a String parameter.
   */
  @Test
  void teCreation2() {
    Entry te = new Entry("str-construct");
  }

  /**
   * Test to see if Type getter method is working.
   */
  @Test
  void teGetter0() {
    Entry te = new Entry(0f);

    assertEquals(Type.NUMBER, te.getType());
  }

  /**
   * Test to see if String getter method is working.
   */
  @Test
  void teGetter1() {
    Entry te = new Entry("test-str0");

    try {
      assertEquals("test-str0", te.getString());
    } catch (BadTypeException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Test to see if Symbol getter method is working.
   */
  @Test
  void teGetter2() {
    Entry te = new Entry(Symbol.PLUS);

    try {
      assertEquals(Symbol.PLUS, te.getSymbol());
    } catch (BadTypeException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Test to see if the float (Value) getter method is working.
   */
  @Test
  void teGetter3() {
    Entry te = new Entry(1.01f);

    try {
      assertEquals(1.01f, te.getValue());
    } catch (BadTypeException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Test to see if the BadTypeException is being thrown if the Entry object is of the wrong Type.
   */
  @Test
  void teGetterException0() {
    Entry te = new Entry(0.0f);

    try {
      assertEquals(Type.INVALID, te.getString());
    } catch (BadTypeException e) {
      System.out.println(e.getMessage()); // Outputs str is not a STRING.
    }
  }

  /**
   * Test to see if the BadTypeException is being thrown if the Entry object is of the wrong Type.
   */
  @Test
  void teGetterException1() {
    Entry te = new Entry("foo");

    try {
      assertEquals(Type.INVALID, te.getSymbol());
    } catch (BadTypeException e) {
      System.out.println(e.getMessage()); // Outputs other is not a SYMBOL
    }
  }

  /**
   * Test to see if the BadTypeException is being thrown if the Entry object is of the wrong Type.
   */
  @Test
  void teGetterException2() {
    Entry te = new Entry(Symbol.DIVIDE);

    try {
      assertEquals(Type.INVALID, te.getValue());
    } catch (BadTypeException e) {
      System.out.println(e.getMessage()); // Outputs type is not NUMBER
    }
  }
}
