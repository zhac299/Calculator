package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tests for StandardCalc.
 * 
 * @author Hassan Mirza
 */
class TestStandardCalc {

  /**
   * Test to see if a StandardCalc object can be created.
   */
  @Test
  void scCreation() {
    StandardCalc sc = new StandardCalc();
  }
  
  /**
   * Test to see if the evaluate method is functioning as intended.
   */
  @Test
  void scEvaluate() {
    StandardCalc sc = new StandardCalc();
    String expression = ("( 5 * ( 6 + 7 ) ) - 2");
    float result = 0f;
    try {
      result = sc.evaluate(expression);
    } catch (InvalidExpressionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    assertEquals(result, 63);
  }

}
