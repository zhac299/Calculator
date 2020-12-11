package uk.ac.rhul.cs2800;

public class RevPolishCalc implements Calculator {
  
  NumStack values = new NumStack();
  
  OpStack operators = new OpStack();
  
  StrStack strings = new StrStack();
  
  public float evaluate(String what) throws InvalidExpressionException {
    return 0f;
  }
  
  void arrangeString(String str) {
    String[] strArray = str.split(" ");
    
    Float num = null;
    Symbol sym = null;
    
    for (String i : strArray) {
      
      if (isFloat(i)) {
        num = Float.parseFloat(i);
        values.push(num);
        
        strings.push(i);
        
      } else if (isSymbol(i)) {
        sym = getSymbol(i); 
        System.out.println("sym:" + sym);
        System.out.println(operators.isEmpty());
        if (!operators.isEmpty()) {
          Entry tempEntry = operators.opStack.top();          
          Symbol tempSym = null;          
          
          try {
            tempSym = tempEntry.getSymbol();
            System.out.println("tempSym:" + tempSym);
          } catch (BadTypeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          
          //BODMAS
          if (tempSym.equals(Symbol.MINUS)) {
            operators.push(sym);
          } else if (tempSym.equals(Symbol.PLUS)) {
            
            if (!sym.equals(Symbol.MINUS)) {
              operators.push(sym);
            } else {
              operators.pop();
              strings.push("+");
              operators.push(sym);
            }
            
          } else if (tempSym.equals(Symbol.TIMES)) {
            
            if (!sym.equals(Symbol.PLUS) && !sym.equals(Symbol.MINUS)) {
              operators.push(sym);
            } else if (sym.equals(Symbol.PLUS)) {
              operators.pop();
              strings.push("+");
              operators.push(sym);                   
            } else if (sym.equals(Symbol.MINUS)) {
              operators.pop();
              strings.push("-");
              operators.push(sym);
            }
                        
          } else if (tempSym.equals(Symbol.DIVIDE)) {
            
            if (sym.equals(Symbol.TIMES)) {
              operators.pop();
              strings.push("*");
              operators.push(sym);
            } else if (sym.equals(Symbol.PLUS)) {
              operators.pop();
              strings.push("+");
              operators.push(sym);
            } else if (sym.equals(Symbol.MINUS)) {
              operators.pop();
              strings.push("-");
              operators.push(sym);
            }
              
          } else if (tempSym.equals(Symbol.LEFT_BRACKET)) {
            operators.push(sym);
          } else if (tempSym.equals(Symbol.RIGHT_BRACKET)) {
            Symbol temp = null;
            
            while (!temp.equals(Symbol.LEFT_BRACKET)) {
              temp = operators.pop();
              strings.push(symbolToString(temp));
            }
          }
          
        } else {
          operators.push(sym);
        }        
      }
    }
  }
  
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
  
  boolean isFloat(String str) {
    try {
      Float num = Float.parseFloat(str);
      return true;
    } catch (NumberFormatException e) {
      System.out.println(e);
    }
    return false;
  }
  
  boolean isSymbol (String str) {
    if (str.equals("(") || str.equals(")") || str.equals("*") 
        || str.equals("/") || str.equals("+") || str.equals("-")) {
      return true;
    } else {
      return false;
    }    
  }
  
  Symbol getSymbol(String str) {
    if (str.equals("(")) {
      return Symbol.LEFT_BRACKET;
    } else if (str.equals(")")) {
      return Symbol.RIGHT_BRACKET;
    } else if (str.equals("*")) {
      return Symbol.TIMES;
    } else if (str.equals("/")) {
      return Symbol.DIVIDE;
    } else if (str.equals("+")) {
      return Symbol.PLUS;
    } else if (str.equals("-")) {
      return Symbol.MINUS;
    } else {
      return Symbol.INVALID;
    }
  }
}
