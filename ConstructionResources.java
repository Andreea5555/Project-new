package Model;

import java.io.Serializable;

/**@author Andreea Caisim
 * The class is called Construction Resources because it holds the actual resources used
 */
public class ConstructionResources implements Serializable
{ private double actualBudget;
  private int timeSpent;
  private double manHoursUsed;

  /**
   * The constructor is putting the values given into the empty space
   * @param manHoursUsed
   * @param actualBudget
   * @param timeSpent
   */

  public ConstructionResources(double manHoursUsed,double actualBudget,int timeSpent){
    this.manHoursUsed=manHoursUsed;
    this.actualBudget=actualBudget;
    this.timeSpent=timeSpent;
  }

  //Used to set up functionality in the GUIs

  /**
   * This is a constructor for the null initialization of the values needed
   */
  public ConstructionResources()
  {
    manHoursUsed = 0;
    actualBudget = 0;
    timeSpent = 0;
  }

  /**
   * The get method of how many manHours we have
   * @return manHoursUsed
   */
  public double getManHoursUsed(){
    return manHoursUsed;
  }

  /**
   * The get method of the actualBudget we have left
   * @return actualBudget
   */
  public double getActualBudget()
  {
    return actualBudget;
  }

  /**
   * the get method for the time spent on the project until now
   * @return timeSpent
   */
  public int getTimeSpent()
  {
    return timeSpent;
  }

  /**
   * the set method for the actual budget we have
   * @param actualBudget
   */
  public void setActualBudget(double actualBudget)
  {
    this.actualBudget = actualBudget;
  }

  /**
   * the set method for the manHours used
   * @param manHoursUsed
   */
  public void setManHoursUsed(double manHoursUsed)
  {
    this.manHoursUsed = manHoursUsed;
  }

  /**
   * the set method for the time spent on the project
   * @param timeSpent
   */
  public void setTimeSpent(int timeSpent)
  {
    this.timeSpent = timeSpent;
  }

  /**
   * the equals method which returns a boolean and describes if the object given is equal to the resources we have or not
   * @param obj
   * @returns false if the object is null or not equal
   * @returns true if the object is equal to the variables we have
   */
  public boolean equals(Object obj){
    if(obj==null||obj.getClass()!=getClass()){
      return false;
    }
    ConstructionResources other=(ConstructionResources) obj;
    return other.manHoursUsed==manHoursUsed&&
    other.actualBudget==actualBudget&&
    other.timeSpent==timeSpent;
  }

  /**
   * a toString method
   * @returns a string with all the information we have about the resources
   */
  public String toString(){
    return "The budget so far: " + actualBudget + "   Time spent so far: " + timeSpent + "   Man hours used so far: " + manHoursUsed;
  }
}
