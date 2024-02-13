package Model;

import Utils.MyFileHandler;
import parser.ParserException;
import parser.XmlJsonParser;

import javax.sound.sampled.Port;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
/**
 * A class that manages projects and provides methods for accessing, editing, and saving project details.
 * @author Andreea Caisim
 * version 1.0
 */
public class ProjectModelManager
{
  private String fileName;
  private final String XMLFILELOCATION = "../Website/xml/OngoingProject.xml";
  /**
   * Constructor to initialize the ProjectModelManager with a file name.
   *
   * @param fileName The name of the file used to store project details.
   */
  public ProjectModelManager(String fileName)
  {
    this.fileName = fileName;
  }
  /**
   * Retrieve all projects from the binary file.
   *
   * @return A list of all projects stored in the binary file.
   */
  public ProjectList getAllProjects()
  {
    ProjectList projects = new ProjectList();
    try
    {
      projects = (ProjectList) Utils.MyFileHandler.readFromBinaryFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class not Found");
    }
    return projects;
  }

  /**
   * Saves a singular project given in the function and adds it to the list of projects
   * @param project
   */
  public void saveAProject(GeneralProject project)
  {
    ProjectList temp = new ProjectList();
    temp = getAllProjects();
    temp.add(project);
    saveProjects(temp);
  }
  /**
   * Save the provided projects to the binary file.
   *
   * @param projects The list of projects to be saved.
   */
  public void saveProjects(ProjectList projects)
  {
    try
    {
      MyFileHandler.writeToBinaryFile(fileName, projects);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
  }

  /**
   * saves a project to a specific location as an XML file
   * @param toSave
   */
  public void saveXML(ProjectList toSave)
  {
    XmlJsonParser parser = new XmlJsonParser();
    try
    {
      parser.toXml(toSave, XMLFILELOCATION);
    }
    catch (ParserException e)
    {
      System.out.println("XML writing error");
    }
  }
  /**
   * Get projects of a specific type from all projects.
   *
   * @param projectType The type of projects to retrieve (e.g., Residential, Road Construction).
   * @return A list of projects of the specified type.
   */
  public ProjectList getProjects(String projectType)
  {
    ProjectList all = getAllProjects();
    ProjectList type = new ProjectList();
    for (int i = 0; i < all.size(); i++)
    {
      if (all.getType(i).equals(projectType))
      {
        type.add(all.get(i));
      }
    }
    return type;
  }

  /**
   *Checks if the given name is unique in the project list
   * @param name
   * @returns false if the name is not unique and true if the name is unique
   */
  public boolean isUnique(String name)
  {
    ProjectList all = getAllProjects();
    for (int i = 0; i <all.size(); i++)
    {
      if(all.get(i).getProjectName().equals(name))
      {
        return false;
      }
    }
    return true;
  }


  /**
   * Edit details of Residential Projects.
   *
   * @param budget The new budget for the project.
   * @param timeline The new timeline for the project.
   * @param projectType The new project type.
   * @param manHours The new man-hours required for the project.
   * @param projectName The name of the project to edit.
   * @param numberOfBathrooms The new number of bathrooms for Residential projects.
   * @param numberOfKitchens The new number of kitchens for Residential projects.
   * @param projectState The new state of the project.
   * @param otherRoomsWithPlumbing The new number of other rooms with plumbing for Residential projects.
   * @param size The new size of the project.
   */
  public void editResidentialProjects(double budget, int timeline, String projectType, double manHours, String projectName,
      int numberOfBathrooms, int numberOfKitchens, String projectState, int otherRoomsWithPlumbing,
      double size)
  {
    ProjectList all = getAllProjects();
    for (int i = 0; i < all.size(); i++)
    {
      if (all.get(i) instanceof Residential && all.get(i).getProjectName().equals(projectName))
      {
        all.get(i).setActualBudget(budget);
        all.get(i).setProjectType(projectType);
        all.get(i).setManHoursUsed(manHours);
        all.get(i).setTimeSpent(timeline);
        all.getResidential(i).setNumberOfBathrooms(numberOfBathrooms);
        all.getResidential(i).setNumberOfKitchens(numberOfKitchens);
        all.getResidential(i).setProjectState(projectState);
        all.getResidential(i).setOtherRoomsWithPlumbing(otherRoomsWithPlumbing);
        all.getResidential(i).setSize(size);
      }
    }
    saveProjects(all);
  }
  /**
   * Edit details of Road Construction Projects.
   *
   * @param budget The new budget for the project.
   * @param timeline The new timeline for the project.
   * @param projectType The new project type.
   * @param manHours The new man-hours required for the project.
   * @param projectName The name of the project to edit.
   * @param length The new length of Road Construction projects.
   * @param width The new width of Road Construction projects.
   * @param bridgesAndTunnels The new number of bridges and tunnels for Road Construction projects.
   * @param geoChallenges The new geo challenges for Road Construction projects.
   */
  public void editRoadConstructionProjects(double budget, int timeline, String projectType, double manHours, String projectName,
      double length, double width, int bridgesAndTunnels, String geoChallenges)
  {
    ProjectList all = getAllProjects();
    for (int i = 0; i < all.size(); i++)
    {
      if (all.get(i) instanceof RoadConstruction && all.get(i).getProjectName().equals(projectName))
      {
        all.get(i).setActualBudget(budget);
        all.get(i).setProjectType(projectType);
        all.get(i).setManHoursUsed(manHours);
        all.get(i).setTimeSpent(timeline);
        all.getRoadConstruction(i).setBridgesAndTunnels(bridgesAndTunnels);
        all.getRoadConstruction(i).setGeoChallenges(geoChallenges);
        all.getRoadConstruction(i).setLength(length);
        all.getRoadConstruction(i).setWidth(width);
      }
    }
    saveProjects(all);
  }
  /**
   * Edit details of Industrial Projects.
   *
   * @param budget The new budget for the project.
   * @param timeline The new timeline for the project.
   * @param projectType The new project type.
   * @param manHours The new man-hours required for the project.
   * @param projectName The name of the project to edit.
   * @param size The new size of Industrial projects.
   * @param typeOfFacility The new type of facility for Industrial projects.
   */
  public void editIndustrialProjects(double budget, int timeline, String projectType, double manHours, String projectName,
      double size, String typeOfFacility)
  {
    ProjectList all = getAllProjects();
    for (int i = 0; i < all.size(); i++)
    {
      if (all.get(i) instanceof IndustrialProject && all.get(i).getProjectName().equals(projectName))
      {
        all.get(i).setActualBudget(budget);
        all.get(i).setProjectType(projectType);
        all.get(i).setManHoursUsed(manHours);
        all.get(i).setTimeSpent(timeline);
        all.getIndustrialProject(i).setSize(size);
        all.getIndustrialProject(i).setTypeOfFacility(typeOfFacility);
      }
    }
    saveProjects(all);
  }
  /**
   * Edit details of Commercial Projects.
   *
   * @param budget The new budget for the project.
   * @param timeline The new timeline for the project.
   * @param projectType The new project type.
   * @param manHours The new man-hours required for the project.
   * @param projectName The name of the project to edit.
   * @param size The new size of Commercial projects.
   * @param useOfBuilding The new use of the building for Commercial projects.
   * @param numberOfFloors The new number of floors for Commercial projects.
   */
  public void editCommercialProjects(double budget, int timeline, String projectType, double manHours, String projectName,
      double size, String useOfBuilding, int numberOfFloors)
  {
    ProjectList all = getAllProjects();
    for (int i = 0; i < all.size(); i++)
    {
      if (all.get(i) instanceof Commercial && all.get(i).getProjectName().equals(projectName))
      {
        all.get(i).setActualBudget(budget);
        all.get(i).setProjectType(projectType);
        all.get(i).setManHoursUsed(manHours);
        all.get(i).setTimeSpent(timeline);
        all.getCommercial(i).setSize(size);
        all.getCommercial(i).setUseOfBuilding(useOfBuilding);
        all.getCommercial(i).setNumberOfFloors(numberOfFloors);
      }
    }
    saveProjects(all);
  }
}
