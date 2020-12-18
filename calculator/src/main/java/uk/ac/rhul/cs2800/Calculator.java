package uk.ac.rhul.cs2800;

/**
 * Allows calculation of String expressions.
 * 
 * @author Hassan Mirza
 */
public interface Calculator {
  public float evaluate(String what) throws InvalidExpressionException;
}
