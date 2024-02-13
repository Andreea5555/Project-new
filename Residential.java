package Model;

/**
 * A class containing a Residential object
 *
 * @author Andreea Caisim
 * version 1.0
 */
public class Residential extends GeneralProject
{
  private int numberOfKitchens;
  private int numberOfBathrooms;
  private int otherRoomsWithPlumbing;
  private String projectState;
  private double size;

  /**
   * Instances of the Residential class are created in the constructor and sets the default values
   *
   * @param size
   * @param projectState
   * @param otherRoomsWithPlumbing
   * @param numberOfBathrooms
   * @param numberOfKitchens
   * @param budget
   * @param timeline
   * @param projectType
   * @param manHours
   * @param projectName
   * @param resources
   */
  public Residential(double size, String projectState,
      int otherRoomsWithPlumbing, int numberOfBathrooms, int numberOfKitchens,
      double budget, int timeline, String projectType, double manHours,
      String projectName, ConstructionResources resources)
  {
    super(budget, timeline, projectType, manHours, projectName, resources);
    this.numberOfBathrooms = numberOfBathrooms;
    this.numberOfKitchens = numberOfKitchens;
    this.otherRoomsWithPlumbing = otherRoomsWithPlumbing;
    this.projectState = projectState;
    this.size = size;
  }

  /**
   * This is a constructor for setting the default values in the ResidentialViewGUI
   * numberOfBathrooms 1,numberOfKitchen 1,otherRoomsWithPlumbing,projectState "new build",size 0,budget 0, timeline 9,projectType: Residential Construction, manHours 0,projectName"none",new ConstructionResources
   * length 0,width 0,bridgesAndTunnels 0,geoChallenges "none"
   */
  public Residential()
  {
    super(0, 9, "Residential Project", 0, "none", new ConstructionResources());
    numberOfBathrooms = 1;
    numberOfKitchens = 1;
    otherRoomsWithPlumbing = 1;
    projectState = "new build";
    size = 0;

  }

  /**
   * A method returning the numberOfKitchens
   *
   * @return numberOfKitchens
   */
  public int getNumberOfKitchens()
  {
    return numberOfKitchens;
  }

  /**
   * A method returning the numberOfBathrooms
   *
   * @return numberOfBathrooms
   */
  public int getNumberOfBathrooms()
  {
    return numberOfBathrooms;
  }

  /**
   * A method returning the otherRoomsWithPlumbing
   *
   * @return otherRoomsWithPlumbing
   */
  public int getOtherRoomsWithPlumbing()
  {
    return otherRoomsWithPlumbing;
  }

  /**
   * A method returning the projectState
   *
   * @return projectState
   */
  public String getProjectState()
  {
    return projectState;
  }

  /**
   * A method returning the size
   *
   * @return size
   */
  public double getSize()
  {
    return size;
  }

  /**
   * a method setting the size
   *
   * @param size
   */
  public void setSize(double size)
  {
    this.size = size;
  }

  /**
   * a method setting the numberOfKitchens
   *
   * @param numberOfKitchens
   */
  public void setNumberOfKitchens(int numberOfKitchens)
  {
    this.numberOfKitchens = numberOfKitchens;
  }

  /**
   * a method setting the numberOfBathrooms
   *
   * @param numberOfBathrooms
   */
  public void setNumberOfBathrooms(int numberOfBathrooms)
  {
    this.numberOfBathrooms = numberOfBathrooms;
  }

  /**
   * a method setting the otherRoomsWithPlumbing
   *
   * @param otherRoomsWithPlumbing
   */
  public void setOtherRoomsWithPlumbing(int otherRoomsWithPlumbing)
  {
    this.otherRoomsWithPlumbing = otherRoomsWithPlumbing;
  }

  /**
   * a method setting the projectState
   *
   * @param projectState
   */
  public void setProjectState(String projectState)
  {
    this.projectState = projectState;
  }

  /**
   * the equals method which returns a boolean and describes if the object given is equal to the resources we have or not
   * @param obj
   * @returns false if the object is null or not equal
   * @returns true if the object is equal to the variables we have
   */
  public boolean equals(Object obj)
  {
    if (obj == null || obj.getClass() != getClass())
    {
      return false;
    }
    Residential other = (Residential) obj;
    return other.numberOfKitchens == numberOfKitchens
        && other.numberOfBathrooms == numberOfBathrooms
        && other.otherRoomsWithPlumbing == otherRoomsWithPlumbing
        && other.projectState.equals(projectState) && other.size == size;
  }

  /**
   * A string representation of Residential
   *
   * @return String
   */
  public String toString()
  {
    return "Project Name: " + super.getProjectName() + "   (" + super.getProjectType() + ")\nNumber of Kitchens: " + numberOfKitchens + "   Number of Bathrooms: " + numberOfBathrooms + "   Other Rooms With Plumbing: " + otherRoomsWithPlumbing + "   Project State: " + projectState + "\n" + super.toString() + "\n" + super.getResources().toString();
  }
}
