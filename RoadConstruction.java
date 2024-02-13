package Model;

/**
 * A class containing a RoadConstruction object
 *
 * @author Alexa Kelemen
 * version 1.0
 */
public class RoadConstruction extends GeneralProject
{
  private double length;
  private double width;
  private int bridgesAndTunnels;
  private String geoChallenges;

  /**
   * Instances of the RoadConstruction class are crated in the constructor
   *
   * @param budget
   * @param timeline
   * @param projectType
   * @param manHours
   * @param projectName
   * @param resources
   * @param length
   * @param width
   * @param bridgesAndTunnels
   * @param geoChallenges
   */
  public RoadConstruction(double budget, int timeline, String projectType,
      double manHours, String projectName, ConstructionResources resources,
      double length, double width, int bridgesAndTunnels, String geoChallenges)
  {
    super(budget, timeline, projectType, manHours, projectName, resources);
    this.length = length;
    this.width = width;
    this.bridgesAndTunnels = bridgesAndTunnels;
    this.geoChallenges = geoChallenges;

  }

  /**
   * This is a constructor for setting the default values in the RoadConstructionViewGUI
   * budget 0,timeline 18,projectType: Road Construction, manHours 0,projectName"",new ConstructionResources
   * length 0,width 0,bridgesAndTunnels 0,geoChallenges "none"
   */

  public RoadConstruction()
  {
    super(0, 18, "Road Construction", 0, "", new ConstructionResources());
    length = 0;
    width = 0;
    bridgesAndTunnels = 0;
    geoChallenges = "none";
  }

  /**
   * A method returning the length
   *
   * @return length
   */
  public double getLength()
  {
    return length;
  }

  /**
   * A method setting the length
   *
   * @param length
   */

  public void setLength(double length)
  {
    this.length = length;
  }

  /**
   * A method returning the width
   *
   * @return width
   */
  public double getWidth()
  {
    return width;
  }

  /**
   * a method setting the width
   *
   * @param width
   */
  public void setWidth(double width)
  {
    this.width = width;
  }

  /**
   * a method returning the bridgesAndTunnels
   *
   * @return bridgesAndTunnels
   */
  public int getBridgesAndTunnels()
  {
    return bridgesAndTunnels;
  }

  /**
   * a method setting the bridesAndTunnels
   *
   * @param bridgesAndTunnels
   */
  public void setBridgesAndTunnels(int bridgesAndTunnels)
  {
    this.bridgesAndTunnels = bridgesAndTunnels;
  }

  /**
   * a method setting the geoChallenges
   *
   * @return geoChallenges
   */

  public String getGeoChallenges()
  {
    return geoChallenges;
  }

  /**
   * a method setting the geoChallenges
   *
   * @param geoChallenges
   */
  public void setGeoChallenges(String geoChallenges)
  {
    this.geoChallenges = geoChallenges;
  }

  /**
   * A string representation of RoadConstruction
   *
   * @return String
   */
  public String toString()
  {
    return "Project Name: " + super.getProjectName() + "   (" + super.getProjectType() + ")\nWidth of Road: " + width + "   Length of Road: " + length + "   Number of Bridges and Tunnels: " + bridgesAndTunnels + "   Geographical Challenges: " + geoChallenges + "\n" + super.toString() + "\n" + super.getResources().toString();
  }

  /**
   * the equals method which returns a boolean and describes if the object given is equal to the resources we have or not
   * @param obj
   * @returns false if the object is null or not equal
   * @returns true if the object is equal to the variables we have
   */

  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }

    RoadConstruction other = (RoadConstruction) obj;

    return super.equals(other) && length == other.length && width == other.width
        && bridgesAndTunnels == other.bridgesAndTunnels && geoChallenges.equals(
        other.geoChallenges);

  }
}
