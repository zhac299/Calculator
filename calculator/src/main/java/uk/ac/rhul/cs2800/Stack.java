package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * The Stack class represents a Stack of Entry values.
 * 
 * @author Hassan Mirza.
 */
public class Stack {
  /**
   * listSize holds the size of a Stack object.
   */
  int listSize = 0;
  /**
   * entries holds the data inside of a Stack object.
   */
  List<Entry> entries = new ArrayList<Entry>();

  /**
   * Adds an item to the Stack.
   * 
   * @param obj The Entry object that is getting added onto the Stack.
   */
  void push(Entry obj) {
    entries.add(obj);
    listSize++;
  }

  /**
   * Removes and returns the object at the top of the Stack.
   * 
   * @return The last object added to the Stack or null.
   * @throws EmptyStackException If the List entries is empty this Exception is thrown.
   */
  Entry pop() throws EmptyStackException {
    if (entries.size() == 0) {
      throw new EmptyStackException();
    }

    Entry temp = entries.get(entries.size() - 1);

    entries.remove(entries.size() - 1);
    --listSize;

    if (temp != null) {
      return temp;
    } else {
      return null;
    }

  }

  /**
   * Gets the last Entry object added to the Stack and returns it without removing it.
   * 
   * @return The latest Entry object added to the Stack or null.
   * @throws EmptyStackException If the List entries is empty this Exception is thrown.
   */
  Entry top() throws EmptyStackException {
    if (entries.size() == 0) {
      throw new EmptyStackException();
    }

    Entry temp = entries.get(entries.size() - 1);

    if (temp != null) {
      return temp;
    } else {
      return null;
    }
  }

  /**
   * Counts up how many objects are stored in Stack.
   * 
   * @return Count of how many Entry are stored inside of Stack.
   */
  int size() {
    int count = 0;
    for (Entry entObj : entries) {
      count++;
    }
    listSize = count;
    return count;
  }
}
