package uk.ac.rhul.cs2800;

/**
 * Shows the values of each of the Calculator's memories.
 * 
 * @author Hassan Mirza
 */
public class CalcModel {
  
  /**
   * Used to run any Postfix expression evaluations.
   */
  Calculator revPolish = new RevPolishCalc();
  
  /**
   * Used to run any Infix expression evaluations.
   */
  Calculator standard = new StandardCalc();
  
  /**
   * Used to evaluate both Infix and Postfix expressions.
   * 
   * @param expr The expression being evaluated.
   * @param infix Used to decide which calculator to run, Infix calculator or Postfix calculator.
   * @return The result of the expression.
   */
  public float evaluate(String expr, boolean infix) {
    float result = 0f;
    if (infix) {
      try {
        result = standard.evaluate(expr);
      } catch (InvalidExpressionException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } 
    } else {
      try {
        result = revPolish.evaluate(expr);
      } catch (InvalidExpressionException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    
    return result;
  }
}
