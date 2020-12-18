package uk.ac.rhul.cs2800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Acts as the Controller for the Model and View assembly.
 * 
 * @author Hassan Mirza
 */
public class CalcController {
  
  static CalcModel model = new CalcModel();
  static boolean isInfix = false;
  
  /**
   * Runs the Calculator on the Console.
   * 
   * @param args Arguments passed in when program is compiled.
   * @throws IOException 
   */
  public static void main(String[] args) throws IOException {
    boolean exit = false;
    BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in)); 
    
    System.out.println("Would you like to use Infix[1] or Postfix[2]?");
    String s = userInput.readLine();
    
    if (s.equals("1")) {
      isInfix = true;
    } else {
      isInfix = false;
    }
    
    while (exit == false) {
      System.out.println("Enter expression (enter q to exit):");
      String str = userInput.readLine();
      
      if (str.equals("q")) {
        exit = true;
        System.out.println("Calculator is shutting down");
      }
      
      if (isInfix) {
        try {
          System.out.println(model.standard.evaluate(str));
        } catch (InvalidExpressionException e) {
          // TODO Auto-generated catch block
          System.out.println("Invalid Expression");
        }
      } else {
        try {
          System.out.println(model.revPolish.evaluate(str));
        } catch (InvalidExpressionException e) {
          // TODO Auto-generated catch block
          System.out.println("Invalid Expression");
        }
      }      
    }
    
    userInput.close();
  }
}
