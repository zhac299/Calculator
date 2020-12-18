package uk.ac.rhul.cs2800;

import java.util.function.Consumer;

/**
 * The interface utilised by the view assembly.
 * 
 * @author Hassan Mirza
 */
public interface ViewInterface {
  public String getExpression();
  
  public void setAnswer(String str);
  
  public void addCalcObserver(Runnable f);
  
  public void addTypeObserver(Consumer<Type> I);
}
