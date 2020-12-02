package uk.ac.rhul.cs2800;

/**
 * Entry is a class of what is stored inside of Stack.
 * 
 * @author Hassan Mirza.
 */
public class Entry {
  /**
   * number is used to store the float attribute of Entry.
   */
  private float number;

  /**
   * other is used to store the Symbol enum attribute of Entry.
   */
  private Symbol other;

  /**
   * str is used to store the String attribute of Entry.
   */
  private String str;

  /**
   * type is used to store the Type enum attribute of Entry.
   */
  private Type type;

  /**
   * Constructor for Entry object which sets the value of the parameter number equal to the value
   * variable. It also sets it to the appropriate Type.
   * 
   * @param value The value that the number attribute is being set to.
   */
  public Entry(float value) {
    this.number = value;
    this.type = Type.NUMBER;
  }

  /**
   * Constructor for Entry object which sets the value of the other attribute equal to the value of
   * the which variable. It also sets it to the appropriate Type.
   * 
   * @param which The value that the other attribute is being set to.
   */
  public Entry(Symbol which) {
    this.other = which;
    this.type = Type.SYMBOL;
  }

  /**
   * Constructor for Entry object which sets the value of the str attribute equal to the value of
   * the str variable. It also sets it to the appropriate Type.
   * 
   * @param str The value that the str attribute is being set to.
   */
  public Entry(String str) {
    this.str = str;
    this.type = Type.STRING;
  }

  /**
   * Getter method used to access the type attribute.
   * 
   * @return The Type value of the type attribute
   */
  public Type getType() {
    return type;
  }

  /**
   * Getter method used to access the str attribute. Throws an exception if the Entry Type is not of
   * Type STRING.
   * 
   * @return The String value held by the str attribute
   * @throws BadTypeException This Exception is thrown if the Entry Type is not of Type STRING.
   */
  public String getString() throws BadTypeException {
    if (type == Type.STRING) {
      return str;
    } else {
      throw new BadTypeException("str is not a STRING");
    }
  }

  /**
   * Getter method used to access the other attribute. Throws an exception if the Entry Type is not
   * of Type SYMBOL.
   * 
   * @return The Symbol enum value held by the other attribute
   * @throws BadTypeException This Exception is thrown if the Entry Type is not of Type SYMBOL.
   */
  public Symbol getSymbol() throws BadTypeException {
    if (type == Type.SYMBOL) {
      return other;
    } else {
      throw new BadTypeException("other is not a SYMBOL");
    }
  }

  /**
   * Getter method used to access the number attribute. Throws an exception if the Entry Type is not
   * of Type NUMBER.
   * 
   * @return The float value held by the number attribute
   * @throws BadTypeException This Exception is thrown if the Entry Type is not of Type NUMBER.
   */
  public float getValue() throws BadTypeException {

    if (type == Type.NUMBER) {
      return number;
    } else {
      throw new BadTypeException("type is not a NUMBER");
    }
  }

}
