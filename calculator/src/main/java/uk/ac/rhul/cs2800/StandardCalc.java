package uk.ac.rhul.cs2800;

/**
 * Evaluates Infix String Expressions.
 * 
 * @author Hassan Mirza
 */
public class StandardCalc implements Calculator {
  
  /**
   * Used to evaluate Infix expressions.
   */
  RevPolishCalc rpCalc = new RevPolishCalc();
  
  /**
   * Takes an Infix expression and returns the result of it.
   * 
   * @param what The Infix expression being evaluated.
   * @return The result of the Infix expression.
   * @throws InvalidExpressionException Thrown if an invalid expression is entered.
   */
  public float evaluate(String what) throws InvalidExpressionException {        
    return rpCalc.evaluate(what);
  }

}
