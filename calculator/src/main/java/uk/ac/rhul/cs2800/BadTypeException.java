package uk.ac.rhul.cs2800;

/**
 * This Exception is thrown when a Entry does not match up to the right Type.
 * 
 * @author Hassan Mirza
 */
public class BadTypeException extends Exception {
  public BadTypeException(String message) {
    super(message);
  }

}
