package uk.ac.rhul.cs2800;

/**
 * RevPolishCalc evaluates Reverse Polish String Expressions.
 * 
 * @author Hassan Mirza
 */
public class RevPolishCalc implements Calculator {
  
  /**
   * Holds numerical values.
   */
  NumStack values = new NumStack();
  
  /**
   * Holds operators.
   */
  OpStack operators = new OpStack();
  
  /**
   * Holds strings when converting Infix to Postfix.
   */
  StrStack strings = new StrStack();
  
  /**
   * This method calculates the result of the expression passed into its parameter.
   * 
   * @param what The expression that is being evaluated.
   * @return The result of the expression.
   * @throws InvalidExpressionException This Exception is thrown if the expression isn't valid.
   */
  public float evaluate(String what) throws InvalidExpressionException {
    while (!strings.isEmpty()) {
      strings.pop();
    }
    while (!operators.isEmpty()) {
      operators.pop();
    }
    while (!values.isEmpty()) {
      values.pop();
    }
    
    String postfixStr = arrangeString(what);
    char[] ch = postfixStr.toCharArray();
    float num1;
    float num2;
    float result = 0f;
    
    for (char c : ch) {
      if (isFloat(c)) {
        values.push(Float.parseFloat(Character.toString(c)));
      } else if (isSymbol(c)) {
        num1 = values.pop();
        num2 = values.pop();        
        if (getSymbol(c) == Symbol.PLUS) {          
          result = num1 + num2;
          values.push(result);
        } else if (getSymbol(c) == Symbol.MINUS) {
          result = num2 - num1;
          values.push(result);
        } else if (getSymbol(c) == Symbol.TIMES) {
          result = num1 * num2;
          values.push(result);
        } else if (getSymbol(c) == Symbol.DIVIDE) {
          result = num1 / num2;
          values.push(result);
        }
      }
    }
    
    return values.pop();
  }
  
  
  /**
   * Converts the Infix expression to Postfix.
   * 
   * @param str The infix expression being converted into Postfix.
   * @return The converted Postfix expression as a String.
   */
  String arrangeString(String str) {
    char[] ch = str.replace(" ", "").toCharArray();
    String outputStr = "";
    
    for (char c : ch) {
      if (!isSymbol(c)) {
        strings.push(Character.toString(c));
        outputStr += c;
      } else if (c == '(') {
        operators.push(getSymbol(c));
      } else if (c == ')') {
        while (!operators.isEmpty()) {
          Symbol temp = operators.pop();
            
          if (temp != Symbol.LEFT_BRACKET) {
            strings.push(symbolToString(temp));
            outputStr += symbolToString(temp);
          } else {
            break;
          }
        } 
      } else if (c == '+' || c == '-' || c == '*' || c == '/') {
        if (operators.isEmpty()) {
          operators.push(getSymbol(c));
        } else {
          while (!operators.isEmpty()) {
            Symbol temp = operators.pop();
            if (temp == Symbol.LEFT_BRACKET) {
              operators.push(temp);
              break;
            } else if (temp == Symbol.PLUS || temp == Symbol.MINUS 
                || temp == Symbol.TIMES || temp == Symbol.DIVIDE) {
              if (getPriority(temp) < getPriority(getSymbol(c))) {
                operators.push(temp);
                break;
              } else {
                strings.push(symbolToString(temp));
                outputStr += symbolToString(temp);
              }
            }
          }
          operators.push(getSymbol(c));
        }
      }        
    }
    while (!operators.isEmpty()) {     
      Symbol temp = operators.pop();
      strings.push(symbolToString(temp));
      outputStr += symbolToString(temp);
    }
    return outputStr;
  }
  
  /**
   * Used to check the precedence of the Symbols. Used when converting Infix to Postfix.
   * 
   * @param sym The Symbol which is being checked for priority.
   * @return A number indicating the priority of the Symbol.
   */
  int getPriority(Symbol sym) {
    if (sym == Symbol.PLUS || sym == Symbol.MINUS) {
      return 1;
    } else {
      return 2;
    }
  }
  
  /**
   * Converts Symbols into their String form.
   * 
   * @param sym The Symbol being converted into a String.
   * @return The String value of the Symbol.
   */
  String symbolToString(Symbol sym) {
    if (sym.equals(Symbol.DIVIDE)) {
      return "/";
    } else if (sym.equals(Symbol.LEFT_BRACKET)) {
      return "(";
    } else if (sym.equals(Symbol.MINUS)) {
      return "-";
    } else if (sym.equals(Symbol.PLUS)) {
      return "+";
    } else if (sym.equals(Symbol.RIGHT_BRACKET)) {
      return ")";
    } else {
      return "*";
    }
  }
  
  /**
   * Checks to see if the char passed in as a parameter is a float.
   * 
   * @param c The char being checked to see if it is a float.
   * @return True or False dependent on if the char is a float or not.
   */
  boolean isFloat(char c) {
    try {
      Float num = Float.parseFloat(Character.toString(c));
      return true;
    } catch (NumberFormatException e) {
      System.out.println(e);
    }
    return false;
  }
  
  /**
   * Checks to see if the char passed in is a Symbol or not.
   * 
   * @param c The char being checked to see if it is a Symbol or not.
   * @return True or False dependent on if the char is a Symbol or not.
   */
  boolean isSymbol(char c) {
    if (c == '(' || c == ')' || c == '*' 
        || c == '/' || c == '+' || c == '-') {
      return true;
    } else {
      return false;
    }    
  }
  
  /**
   * Gets the Symbol for the char passed in as a parameter.
   * 
   * @param c The char being converted into a Symbol.
   * @return The Symbol version of the char parameter.
   */
  Symbol getSymbol(char c) {
    if (c == '(') {
      return Symbol.LEFT_BRACKET;
    } else if (c == ')') {
      return Symbol.RIGHT_BRACKET;
    } else if (c == '*') {
      return Symbol.TIMES;
    } else if (c == '/') {
      return Symbol.DIVIDE;
    } else if (c == '+') {
      return Symbol.PLUS;
    } else if (c == '-') {
      return Symbol.MINUS;
    } else {
      return Symbol.INVALID;
    }
  }
}