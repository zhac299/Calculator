/**
 * 
 */
package uk.ac.rhul.cs2800;

/**
 * This Exception is thrown when a Entry does not match up to the right Type.
 * 
 * @author mirzm
 */
public class BadTypeException extends Exception {
  public BadTypeException(String message) {
    super(message);
  }

}
