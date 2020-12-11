package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestRevPolishCalc {

  @Test
  void rpcCreation() {
    RevPolishCalc rpc = new RevPolishCalc();
  }
  
  @Test
  void rpcArrangeString() {
    RevPolishCalc rpc = new RevPolishCalc();
   
    NumStack testValues = new NumStack();
    testValues.push(Float.parseFloat("5"));
    testValues.push(Float.parseFloat("4"));
    testValues.push(Float.parseFloat("6"));
   
    StrStack testStrings = new StrStack();
    testStrings.push("5");
    testStrings.push("4");
    testStrings.push("6");
    testStrings.push("+");
    testStrings.push("*");
   
    rpc.arrangeString("5 * 4 + 6");   
   
    String valueStr0 = "";
    String valueStr1 = "";
   
    while(!rpc.values.isEmpty()) {
      valueStr0 += rpc.values.pop();
    }
   
    while(!testValues.isEmpty()) {
      valueStr1 += testValues.pop();
    }   
   
    assertEquals(valueStr0, valueStr1);
   
    String strString0 = "";
    String strString1 = "";
   
    while(!rpc.strings.isEmpty()) {
      strString0 += rpc.strings.pop();
    }
   
    while(!testStrings.isEmpty()) {
      strString1 += testStrings.pop();
    }
   
    assertEquals(strString0, strString1);
  }
  
  @Test
  void rpcSymbolToString() {
    RevPolishCalc rpc = new RevPolishCalc();
    
    assertEquals(rpc.symbolToString(Symbol.DIVIDE), "/");
    assertEquals(rpc.symbolToString(Symbol.LEFT_BRACKET), "(");
    assertEquals(rpc.symbolToString(Symbol.MINUS), "-");
    assertEquals(rpc.symbolToString(Symbol.PLUS), "+");
    assertEquals(rpc.symbolToString(Symbol.RIGHT_BRACKET), ")");
    assertEquals(rpc.symbolToString(Symbol.TIMES), "*");
  }
  
  @Test
  void rpcIsFloat() {
    RevPolishCalc rpc = new RevPolishCalc();
    
    assertEquals(rpc.isFloat("0.000"), true);
    assertEquals(rpc.isFloat("foo"), false);
    assertEquals(rpc.isFloat("1"), true);
  }
  
  @Test
  void rpcIsSymbol() {
    RevPolishCalc rpc = new RevPolishCalc();
    
    assertEquals(rpc.isSymbol(")"), true);
    assertEquals(rpc.isSymbol("("), true);
    assertEquals(rpc.isSymbol("*"), true);
    assertEquals(rpc.isSymbol("/"), true);
    assertEquals(rpc.isSymbol("+"), true);
    assertEquals(rpc.isSymbol("-"), true);
    assertEquals(rpc.isSymbol("foo"), false);
  }
  
  @Test
  void rpcGetSymbol() {
    RevPolishCalc rpc = new RevPolishCalc();
    
    assertEquals(rpc.getSymbol(")"), Symbol.RIGHT_BRACKET);
    assertEquals(rpc.getSymbol("("), Symbol.LEFT_BRACKET);
    assertEquals(rpc.getSymbol("*"), Symbol.TIMES);
    assertEquals(rpc.getSymbol("/"), Symbol.DIVIDE);
    assertEquals(rpc.getSymbol("+"), Symbol.PLUS);
    assertEquals(rpc.getSymbol("-"), Symbol.MINUS);
    assertEquals(rpc.getSymbol("foo"), Symbol.INVALID);    
  }

}
