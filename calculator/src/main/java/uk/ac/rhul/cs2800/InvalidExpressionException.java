package uk.ac.rhul.cs2800;

/**
 * This Exception is thrown when an invalid expression is entered.
 * 
 * @author Hassan Mirza
 */
public class InvalidExpressionException extends Exception {
  public InvalidExpressionException(String message) {
    super(message);
  }

}
