

import java.util.ArrayList;
/**
 * Class that contains and manages catalogue of auction lots
 * 
 * @author jf
 * @version 14.3.2015
 *
 */
public class Catalogue
{
  ArrayList<Lot> lots;
  
  /**
   * Constructs a catalogue object
   * Initializes the Lot list field
   */
  public Catalogue()
  {
    lots = new ArrayList<Lot>();
  }
  
  /**
   * Adds a Lot object to list of lots field
   * @param lot The Lot object being added
   */
  public void addLot(Lot lot)
  {
    // TODO 1 Complete implementation
  }
  
  /**
   * Constructs a string representation of this object
   * @return string representation of this object
   */
  public String toString()
  {
    
    String details = "There is no catalogue description: please fix me";
    // TODO 2 Complete implementation
    return details;
  }
  
}
