package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests for RevPolishCalc.
 * 
 * @author Hassan Mirza
 */
class TestRevPolishCalc {

  /**
   * Test to see if a RevPolishCalc object can be created.
   */
  @Test
  void rpcCreation() {
    RevPolishCalc rpc = new RevPolishCalc();
  }
  
  /**
   * Test to see if the correct answer from an expression is returned.
   */
  @Test
  void rpcEvaluate() {
    RevPolishCalc rpc = new RevPolishCalc();
    float result = 0f;
    
    try {
      result = rpc.evaluate("( 5 * ( 6 + 7 ) ) - 2");
    } catch (InvalidExpressionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    assertEquals(result, 63);
  }
  
  /**
   * Test to see if Infix can be converted into Postfix.
   */
  @Test
  void rpcArrangeString() {
    RevPolishCalc rpc = new RevPolishCalc();
   
    StrStack testStrings = new StrStack();
    testStrings.push("5");
    testStrings.push("4");
    testStrings.push("*");
    testStrings.push("6");
    testStrings.push("+");
   
    rpc.arrangeString("5 * 4 + 6");     
   
    String strString0 = "";
    String strString1 = "";
   
    while (!rpc.strings.isEmpty()) {
      strString0 += rpc.strings.pop();
    }
   
    while (!testStrings.isEmpty()) {
      strString1 += testStrings.pop();
    }
   
    assertEquals(strString0, strString1);
    
    StrStack testStrings1 = new StrStack();
    testStrings1.push("5");
    testStrings1.push("6");
    testStrings1.push("7");
    testStrings1.push("+");
    testStrings1.push("*");
    testStrings1.push("2");
    testStrings1.push("-");
    
    String outputStr = rpc.arrangeString("( 5 * ( 6 + 7 ) ) - 2");
    
    strString0 = "";
    strString1 = "";
    
    while (!rpc.strings.isEmpty()) {
      strString0 += rpc.strings.pop();
    }
   
    while (!testStrings1.isEmpty()) {
      strString1 += testStrings1.pop();
    }     

    assertEquals(strString0, strString1);
    assertEquals(outputStr, "567+*2-");
  }
  
  /**
   * Test to see if the system can calculate the priority of Symbols.
   */
  @Test
  void rpcGetPriority() {
    RevPolishCalc rpc = new RevPolishCalc();
    
    assertEquals(rpc.getPriority(Symbol.PLUS), 1);
    assertEquals(rpc.getPriority(Symbol.MINUS), 1);
    assertEquals(rpc.getPriority(Symbol.TIMES), 2);
    assertEquals(rpc.getPriority(Symbol.DIVIDE), 2);
  }
  
  /**
   * Test to see if Symbols can be converted into Strings.
   */
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
  
  /**
   * Test to see if float can be recognised from char values.
   */
  @Test
  void rpcIsFloat() {
    RevPolishCalc rpc = new RevPolishCalc();
    
    assertEquals(rpc.isFloat('0'), true);
    assertEquals(rpc.isFloat('f'), false);
    assertEquals(rpc.isFloat('1'), true);
  }
  
  /**
   * Test to see if Symbols can be recognised from their char values.
   */
  @Test
  void rpcIsSymbol() {
    RevPolishCalc rpc = new RevPolishCalc();
    
    assertEquals(rpc.isSymbol(')'), true);
    assertEquals(rpc.isSymbol('('), true);
    assertEquals(rpc.isSymbol('*'), true);
    assertEquals(rpc.isSymbol('/'), true);
    assertEquals(rpc.isSymbol('+'), true);
    assertEquals(rpc.isSymbol('-'), true);
    assertEquals(rpc.isSymbol('f'), false);
  }
  
  /**
   * Test to see if the correct Symbols are returned from their char versions.
   */
  @Test
  void rpcGetSymbol() {
    RevPolishCalc rpc = new RevPolishCalc();
    
    assertEquals(rpc.getSymbol(')'), Symbol.RIGHT_BRACKET);
    assertEquals(rpc.getSymbol('('), Symbol.LEFT_BRACKET);
    assertEquals(rpc.getSymbol('*'), Symbol.TIMES);
    assertEquals(rpc.getSymbol('/'), Symbol.DIVIDE);
    assertEquals(rpc.getSymbol('+'), Symbol.PLUS);
    assertEquals(rpc.getSymbol('-'), Symbol.MINUS);
    assertEquals(rpc.getSymbol('f'), Symbol.INVALID);    
  }

}
