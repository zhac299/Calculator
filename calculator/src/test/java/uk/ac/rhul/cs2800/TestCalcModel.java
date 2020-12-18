package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Test for CalcModel.
 * 
 * @author Hassan Mirza
 */
class TestCalcModel {

  /**
   * Test to see if CalcModel object can be created.
   */
  @Test
  void cmCreation() {
    CalcModel cm = new CalcModel();
  }
  
  /**
   * Test to see if evaluate method is working as intended.
   */
  @Test
  void cmEvaluate() {
    CalcModel cm = new CalcModel();
    
    String expression = ("( 5 * ( 6 + 7 ) ) - 2");
    
    assertEquals(cm.evaluate(expression, true), 63);
    assertEquals(cm.evaluate(expression, false), 63);
  }

}
