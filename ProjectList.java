package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A class of an ArrayList which contains all the projects
 *
 * @author Alexa Kelemen
 * version 1.0
 */
public class ProjectList implements Serializable
{
  private ArrayList<GeneralProject> projects;

  /**
   * A non-argument constructor which initialises the used ArrayList
   */
  public ProjectList()
  {
    projects = new ArrayList<GeneralProject>();
  }

  /**
   * a method returning the size of the ArrayList
   *
   * @return size
   */
  public int size()
  {
    return projects.size();
  }

  /**
   * A method to return the projectType of the ArrayList
   *
   * @param index
   * @return projectType index
   */
  public String getType(int index)
  {
    return projects.get(index).getProjectType();
  }

  /**
   * A method to get specific project at a given index
   *
   * @param index
   * @return projects index
   */
  public GeneralProject get(int index)
  {
    return projects.get(index);
  }

  /**
   * A method that changes the type of project from General to Residential
   *
   * @param index
   * @return Residential project index
   */
  public Residential getResidential(int index)
  {
    return (Residential) projects.get(index);
  }

  /**
   * A method that changes the type of project from General to RoadConstruction
   *
   * @param index
   * @return RoadConstruction project index
   */
  public RoadConstruction getRoadConstruction(int index)
  {
    return (RoadConstruction) projects.get(index);
  }

  /**
   * A method that changes the type of project from General to IndustrialProject
   *
   * @param index
   * @return IndustrialProject project index
   */
  public IndustrialProject getIndustrialProject(int index)
  {
    return (IndustrialProject) projects.get(index);
  }

  /**
   * this method returns a project list with all the Road Construction projects
   * @return roads
   */
  public ProjectList getAllRoadConstruction()
  {
    ProjectList roads = new ProjectList();
    for (int i = 0; i < projects.size(); i++)
    {
      if(projects.get(i) instanceof RoadConstruction)
      {
        roads.add(projects.get(i));
      }
    }
    return roads;
  }

  /**
   * this method returns a project list with all the Industrial projects
   * @return temp
   */
  public ProjectList getAllIndustrial()
  {
    ProjectList temp = new ProjectList();
    for (int i = 0; i < projects.size(); i++)
    {
      if(projects.get(i) instanceof IndustrialProject)
      {
        temp.add(projects.get(i));
      }
    }
    return temp;
  }

  /**
   * this method sorts decreasingly all the existing projects by budget
   * @return this
   */
  public ProjectList sortByBudget()
  {
    for (int i = 0; i < projects.size(); i++)
    {
      for (int j = i; j < projects.size(); j++)
      {
        if(projects.get(i).getBudget() < projects.get(j).getBudget())
        {
          GeneralProject temp = projects.get(i);
          projects.set(i, projects.get(j));
          projects.set(j, temp);
        }
      }
    }
    return this;
  }

  /**
   * this method sorts decreasingly all projects by timeline
   * @return this
   */
  public ProjectList sortByTimeline()
  {
    for (int i = 0; i < projects.size(); i++)
    {
      for (int j = i; j < projects.size(); j++)
      {
        if(projects.get(i).getTimeline() < projects.get(j).getTimeline())
        {
          GeneralProject temp = projects.get(i);
          projects.set(i, projects.get(j));
          projects.set(j, temp);
        }
      }
    }
    return this;
  }

  /**
   * this method returns a project list with all the Commercial projects
   * @return temp
   */
  public ProjectList getAllCommercial()
  {
    ProjectList temp = new ProjectList();
    for (int i = 0; i < projects.size(); i++)
    {
      if(projects.get(i) instanceof Commercial)
      {
        temp.add(projects.get(i));
      }
    }
    return temp;
  }

  /**
   * this method returns a project list that contains all the Residential projects
   * @return temp
   */
  public ProjectList getAllResidential()
  {
    ProjectList temp = new ProjectList();
    for (int i = 0; i < projects.size(); i++)
    {
      if(projects.get(i) instanceof Residential)
      {
        temp.add(projects.get(i));
      }
    }
    return temp;
  }

  /**
   * A method that changes the type of project from General to IndustrialProject
   *
   * @param index
   * @return CommercialProject project index
   */

  public Commercial getCommercial(int index)
  {
    return (Commercial) projects.get(index);
  }

  /**
   * This method add a project to the ArrayList
   *
   * @param generalProject
   */
  public void add(GeneralProject generalProject)
  {
    projects.add(generalProject);
  }

  /**
   * This method replaces the model.GeneralProject object at index with project
   *
   * @param generalProject
   * @param index
   */
  public void set(GeneralProject generalProject, int index)
  {
    projects.set(index, generalProject);
  }
  //

  /**
   * This method gets the model.GeneralProject object with the given
   * budget,timeline,manHours,projectName,resources,numberOfFloors,size,useOfBuilding
   * if one exists, else return null
   *
   * @param budget
   * @param timeline
   * @param projectType
   * @param manHours
   * @param projectName
   * @return
   */

  public GeneralProject get(double budget, int timeline, String projectType,
      double manHours, String projectName)
  {
    for (int i = 0; i < projects.size(); i++)
    {
      GeneralProject temp = projects.get(i);

      if (temp.getBudget() == budget && temp.getTimeline() == timeline
          && temp.getProjectType().equals(projectType)
          && temp.getManHours() == manHours && temp.getProjectName()
          .equals(projectName))
      {
        return temp;
      }
    }

    return null;
  }

  /**
   * Return the index of the model.GeneralProject object with the given
   * // budget,timeline,projectType,manHours,porjectName if one exists, else return -1
   *
   * @param budget
   * @param timeline
   * @param projectType
   * @param manHours
   * @param projectName
   * @return
   */
  public int getIndex(double budget, int timeline, String projectType,
      double manHours, String projectName)
  {
    for (int i = 0; i < projects.size(); i++)
    {
      GeneralProject temp = projects.get(i);

      if (temp.getBudget() == budget && temp.getTimeline() == timeline
          && temp.getProjectType().equals(projectType)
          && temp.getManHours() == manHours && temp.getProjectName()
          .equals(projectName))
      {
        return i;
      }
    }
    return -1;
  }

  /**
   * This method removes a generalProject from the ArrayList
   *
   * @param generalProject
   */
  public void remove(GeneralProject generalProject)
  {
    projects.remove(generalProject);
  }

  /**
   * the equals method which returns a boolean and describes if the object given is equal to the resources we have or not
   *
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
    ProjectList other = (ProjectList) obj;

    return projects.equals(other.projects);
  }

  /**
   * A string representation of ProjectList ,in order to make it look nice a new line is added after each project
   *
   * @return String
   */
  public String toString()
  {
    String returnStr = "";

    for (int i = 0; i < projects.size(); i++)
    {
      GeneralProject temp = projects.get(i);

      returnStr += temp + "\n";
    }
    return returnStr;
  }
}

