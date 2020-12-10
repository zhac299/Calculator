package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Tests used in the development of the Stack class.
 * 
 * @author Hassan Mirza.
 */
class TestStack {

  /**
   * Test to see if a new Stack can be created.
   */
  @Test
  void testStackCreation() {
    Stack ts = new Stack();
  }

  /**
   * Test to see if Stack has the attributes required.
   */
  @Test
  void testStackAttributes() {
    Stack ts = new Stack();
    int size = ts.listSize;
    List<Entry> entries = ts.entries;
  }

  /**
   * Test to see if the push function works.
   */
  @Test
  void testPush() {
    Stack ts = new Stack();
    Entry te = new Entry(0f);
    ts.push(te);
  }

  /**
   * Test to see if the pop function works when a item is popped off the Stack.
   */
  @Test
  void testPop0() {
    Stack ts = new Stack();
    Entry te = new Entry(0f);
    ts.push(te);

    assertEquals(te, ts.pop());
  }

  /**
   * Test to see if the pop function works when a empty Stack is popped causing an
   * EmptyStackException to be thrown.
   */
  @Test
  void testPop1() {
    Stack ts = new Stack();

    try {
      assertEquals(null, ts.pop());
    } catch (EmptyStackException e) {
      System.out.println(e); // Exception is printed to console.
    }
  }


  /**
   * Test to see if the pop function decrements the listSize attribute.
   */
  @Test
  void testPop2() {
    Stack ts = new Stack();
    Entry te = new Entry(0f);

    ts.push(te);
    ts.pop();

    if (ts.listSize != 0) {
      fail("Pop did not reduce size!");
    }
  }

  /**
   * Test to check if the top function is working as intended when there are no Entry objects on the
   * Stack. EmptyStackException should be thrown.
   */
  @Test
  void testTop0() {
    Stack ts = new Stack();

    try {
      assertEquals(null, ts.top());
    } catch (EmptyStackException e) {
      System.out.println(e); // Exception is printed to console.
    }
  }

  /**
   * Test to see if the top function is working as intended when there is a Entry object on the
   * Stack.
   */
  @Test
  void testTop1() {
    Stack ts = new Stack();
    Entry te = new Entry(0f);
    ts.push(te);
    assertEquals(te, ts.top());
  }

  /**
   * Test to see if the size function is working as intended.
   */
  @Test
  void testSize() {
    Stack ts = new Stack();
    Entry te = new Entry(0f);
    assertEquals(0, ts.size());
    ts.push(te);
    assertEquals(1, ts.size());
  }
}
