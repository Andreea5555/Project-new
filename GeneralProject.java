package Model;

import java.io.Serializable;

/**
 * this project is made by Krisztina Csilla Illés
 */
public abstract class GeneralProject implements Serializable
{
  private double budget;
  private int timeline;
  private String projectType;
  private double manHours;
  private String projectName;
  private ConstructionResources resources;

  /**
   * the constructor for the variables needed for a general project, which means all type have these variables
   * @param budget
   * @param timeline
   * @param projectType
   * @param manHours
   * @param projectName
   * @param resources
   */
  public GeneralProject(double budget, int timeline, String projectType, double manHours, String projectName, ConstructionResources resources)
  {
    this.budget = budget;
    this.timeline = timeline;
    this.projectType = projectType;
    this.manHours = manHours;
    this.projectName = projectName;
    this.resources = resources;

  }

  /**
   * the method for getting the budget of the project
   * @return budget
   */
  public double getBudget()
  {
    return budget;
  }

  /**
   * the method for getting the time spent on the project
   * @return timeline
   */
  public int getTimeline()
  {
    return timeline;
  }

  /**
   * the method for getting the project type
   * @return projectType
   */
  public String getProjectType()
  {
    return projectType;
  }

  /**
   * the method for getting the man hours spent on the project
   * @return manHours
   */
  public double getManHours()
  {
    return manHours;
  }

  /**
   * the method to get the name of the project
   * @return projectName
   */
  public String getProjectName()
  {
    return projectName;
  }

  /**
   * the method to set the budget of the project
   * @param budget
   */
  public void setBudget(double budget)
  {
    this.budget = budget;
  }

  /**
   * the method to set the time line of the project
   * @param timeline
   */
  public void setTimeline(int timeline)
  {
    this.timeline = timeline;
  }

  /**
   * the method to set the project type of the project
   * @param projectType
   */
  public void setProjectType(String projectType)
  {
    this.projectType = projectType;
  }

  /**
   * the method to set the man hours worked on the project
   * @param manHours
   */
  public void setManHours(double manHours)
  {
    this.manHours = manHours;
  }

  /**
   * the method to set the project name of the project
   * @param projectName
   */
  public void setProjectName(String projectName)
  {
    this.projectName = projectName;
  }

  /**
   * This method is giving the resources used
   * @return resources
   */
  public ConstructionResources getResources()
  {
    return resources;
  }

  /**
   * this method is setting the time spent on the actual project
   * @param timeSpent
   */
  public void setTimeSpent(int timeSpent)
  {
    resources.setTimeSpent(timeSpent);
  }

  /**
   * this method is setting the actual budget spent on the project
   * @param actualBudget
   */
  public void setActualBudget(double actualBudget)
  {
    resources.setActualBudget(actualBudget);
  }

  /**
   * this method is setiing the man hours used
   * @param manHoursUsed
   */
  public void setManHoursUsed(double manHoursUsed)
  {
    resources.setManHoursUsed(manHoursUsed);
  }

  /**
   * the method to see if the project is equal to an given object
   * @param obj
   * @returns false if the object is null or doesn't have the same class
   * @returns true if the object is equal to the project
   */
  public boolean equals(Object obj)
  {
    if(obj == null || obj.getClass() != getClass())
    {
      return false;
    }
    GeneralProject other = (GeneralProject) obj;

    return other.budget == this.budget && other.timeline == this.timeline && other.projectType.equals(this.projectType) && other.manHours == this.manHours && other.projectName.equals(this.projectName);
  }

  /**
   * a method which gives the information in a string
   * @returns all the information of the general project
   */
  public String toString()
  {
    return "The estimated budget: " + budget + "   The estimated time: " + timeline + "   The estimated man hours: " + manHours;
  }
}
