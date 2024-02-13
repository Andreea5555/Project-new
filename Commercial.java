package Model;
/**
 * A class containing a Commercial object
 * @author Krisztina Csilla Illés
 * version 1.0
 */

public class Commercial extends GeneralProject
{
  private int numberOfFloors;
  private double size;
  private String useOfBuilding;
  /**
   * Instances of the Commercial class are created in the constructor and sets the default values
   * @param budget
   * @param timeline
   * @param manHours
   * @param projectName
   * @param resources
   * @param numberOfFloors
   * @param size
   * @param useOfBuilding
   */
  public Commercial(double budget, int timeline,  double manHours, String projectName, ConstructionResources resources, int numberOfFloors, double size, String useOfBuilding, String projectType)
  {
    super(budget, timeline, projectType, manHours, projectName, resources);
    this.numberOfFloors = numberOfFloors;
    this.size = size;
    this.useOfBuilding = useOfBuilding;
  }

  /**
   * A constructor initializing the default values for the variables used
   */
  public Commercial()
  {
    super(0, 18, "Commercial Project", 0, "", new ConstructionResources());
    numberOfFloors = 1;
    size = 0;
    useOfBuilding = "";
  }
  /**
   * A method returning the numberOfFloors
   * @return numberOfFloors
   */
  public int getNumberOfFloors()
  {
    return numberOfFloors;
  }
  /**
   * A method returning the size
   * @return size
   */

  public double getSize()
  {
    return size;
  }
  /**
   * A method returning the useOfBuilding
   * @return useOfBuilding
   */
  public String getUseOfBuilding()
  {
    return useOfBuilding;
  }

  /**
   * A method setting the numberOfFloors
   * @param numberOfFloors
   */

  public void setNumberOfFloors(int numberOfFloors)
  {
    this.numberOfFloors = numberOfFloors;
  }
  /**
   * A method setting the size
   * @param size
   */
  public void setSize(double size)
  {
    this.size = size;
  }
  /**
   * A method setting the useOfBuilding
   * @param useOfBuilding
   */
  public void setUseOfBuilding(String useOfBuilding)
  {
    this.useOfBuilding = useOfBuilding;
  }
  /**
   * A string representation of Commercial
   * @return String
   */
  public String toString()
  {
    return "Project Name: " + super.getProjectName() + "   (" + super.getProjectType() + ")\nNumber of Floors: " + numberOfFloors + "   Size of Building: " + size + "   Use of Building: " + useOfBuilding + "\n" + super.toString() + "\n" + super.getResources().toString();
  }
  /**
   * the equals method which returns a boolean and describes if the object given is equal to the resources we have or not
   * @param obj
   * @returns false if the object is null or not equal
   * @returns true if the object is equal to the variables we have
   */
  public boolean equals(Object obj)
  {
    if(obj == null || obj.getClass() != getClass())
    {
      return false;
    }
    Commercial other = (Commercial) obj;

    return super.equals(other) && other.numberOfFloors == this.numberOfFloors && other.size == this.size && other.useOfBuilding.equals(this.useOfBuilding);
  }
}
