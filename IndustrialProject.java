package Model;
/**
 * A class containing IndustrialProject
 *
 * @author Sophia Justin
 * version 1.0
 */

public class IndustrialProject extends GeneralProject
{
  private double size;
  private String typeOfFacility;

  /**
   * Instances of the IndustrialProject class are crated in the constructor
   * @param typeOfFacility
   * @param size
   * @param budget
   * @param timeline
   * @param projectType
   * @param manHours
   * @param projectName
   * @param resources
   */
  public IndustrialProject(String typeOfFacility, double size, double budget, int timeline, String projectType, double manHours, String projectName, ConstructionResources resources)
  {
    super(budget, timeline, projectType, manHours, projectName, resources);
    this.size = size;
    this.typeOfFacility = typeOfFacility;
  }

  /**
   * this method is a constructor which sets the default values to the attributes used
   */
  public IndustrialProject()
  {
    super(0, 30, "Industrial Project", 0, "", new ConstructionResources());
    size = 0;
    typeOfFacility = "";
  }

  /**
   * A method returning the size
   *
   * @return size
   */
  public double getSize(){
    return size;
  }
  /**
   * A method returning the typeOfFacility
   *
   * @return typeOfFacility
   */
  public String getTypeOfFacility(){
    return typeOfFacility;
  }
  /**
   * A method setting the size
   *
   * @param size
   */
  public void setSize(double size){
    this.size = size;
  }
  /**
   * A method setting the typeOfFacility
   *
   * @param typeOfFacility
   */
  public void setTypeOfFacility(String typeOfFacility){
    this.typeOfFacility = typeOfFacility;
  }
  /**
   * A string representation of Industrial
   *
   * @return String
   */
  public String toString(){
    return "Project Name: " + super.getProjectName() + "   (" + super.getProjectType() + ")\nType of Facility: " + typeOfFacility + "   Size of Project: " + size + "\n" + super.toString() + "\n" + super.getResources().toString();
  }
  /**
   * the equals method which returns a boolean and describes if the object given is equal to the resources we have or not
   * @param obj
   * @returns false if the object is null or not equal
   * @returns true if the object is equal to the variables we have
   */
  public boolean equals(Object obj){
    if (obj == null || getClass() != obj.getClass()){
      return false;
    }
    IndustrialProject other = (IndustrialProject) obj;
    return super.equals(other) && size == other.size && typeOfFacility.equals(other.typeOfFacility);
  }
}
