package GUIMain;

import Model.*;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;


public class MainViewGUI
{
  private Scene scene;
  private ViewHandlerGUI viewHandlerGUI;
  @FXML private MenuItem createProject;
  @FXML private MenuItem deleteAll;
  @FXML private ListView<GeneralProject> projects;
  @FXML private MenuItem deleteProject;
  @FXML private MenuItem editProject;
  @FXML private ComboBox<String> display;
  @FXML private ComboBox<String> howToOrder;
  @FXML private MenuItem pushToWebsite;
  private ProjectModelManager manager;

  public void init(ViewHandlerGUI viewHandlerGUI, Scene scene){
    this.viewHandlerGUI =viewHandlerGUI;
    this.scene = scene;
    manager = new ProjectModelManager("Projects");
    display.getItems().add("All projects");
    display.getItems().add("Road Construction Projects");
    display.getItems().add("Industrial Projects");
    display.getItems().add("Commercial Projects");
    display.getItems().add("Residential Projects");
    display.getSelectionModel().select(0);
    howToOrder.getItems().add("Select sorting...");
    howToOrder.getItems().add("By Budget");
    howToOrder.getItems().add("By Timeline");
    howToOrder.getSelectionModel().select(0);
     }

  public void updateProjectsView()
  {
    ProjectList projectList = manager.getAllProjects();
    projects.getItems().clear();
    for (int i = 0; i < projectList.size() ; i++)
    {
      projects.getItems().add(projectList.get(i));
    }
    display.getSelectionModel().select(0);
    howToOrder.getSelectionModel().select(0);
  }

  public Scene getScene()
  {
    return scene;
  }

  public void handleActions(ActionEvent e)
  {
    if(e.getSource() == createProject)
    {
      viewHandlerGUI.openView("CreateProjects");
    }
    else if (e.getSource() == deleteAll)
    {
      Alert alert = new Alert(Alert.AlertType.WARNING,
          "Are you sure you want to delete all the projects?",
          ButtonType.YES, ButtonType.NO);
      alert.setTitle("Clear");
      alert.setHeaderText(null);
      alert.showAndWait();
      if(alert.getResult() == ButtonType.YES)
      {
        ProjectList temp = new ProjectList();
        manager.saveProjects(temp);
        updateProjectsView();
      }
    }
    else if (e.getSource() == deleteProject)
    {
      Alert alert = new Alert(Alert.AlertType.WARNING,
          "Are you sure you want to delete this project?",
          ButtonType.YES, ButtonType.NO);
      alert.setTitle("Clear");
      alert.setHeaderText(null);
      alert.showAndWait();
      if(alert.getResult() == ButtonType.YES)
      {
        ProjectList temp = manager.getAllProjects();
        ObservableList<GeneralProject> selected = projects.getSelectionModel().getSelectedItems();
        for (int i = 0; i < selected.size(); i++)
        {
          temp.remove((GeneralProject) selected.get(i));
        }
        manager.saveProjects(temp);
        updateProjectsView();
      }
    }
    else if (e.getSource() == editProject)
    {
      ObservableList<GeneralProject> selected = projects.getSelectionModel().getSelectedItems();
      if(selected != null && selected.size() > 0 &&(GeneralProject) selected.get(0) instanceof IndustrialProject)
      {
        viewHandlerGUI.openEditView("EditIndustrial", (GeneralProject) selected.get(0));
      }
      else if (selected != null && selected.size() > 0 && (GeneralProject) selected.get(0) instanceof RoadConstruction)
      {
        viewHandlerGUI.openEditView("EditRoadConstruction", (GeneralProject) selected.get(0));
      }
      else if (selected != null && selected.size() > 0 && (GeneralProject) selected.get(0) instanceof Residential)
      {
        viewHandlerGUI.openEditView("EditResidential", (GeneralProject) selected.get(0));
      }
      else if (selected != null && selected.size() > 0 && (GeneralProject) selected.get(0) instanceof Commercial)
      {
        viewHandlerGUI.openEditView("EditCommercial", (GeneralProject) selected.get(0));
      }
    }
    else if(e.getSource() == display)
    {
      if(display.getSelectionModel().getSelectedItem().equals("All projects"))
      {
        updateProjectsView();
      }
      else if(display.getSelectionModel().getSelectedItem().equals("Road Construction Projects"))
      {
        ProjectList projectList = manager.getAllProjects().getAllRoadConstruction();
        projects.getItems().clear();
        for (int i = 0; i < projectList.size() ; i++)
        {
          projects.getItems().add(projectList.get(i));
        }
      }
      else if (display.getSelectionModel().getSelectedItem().equals("Industrial Projects"))
      {
        ProjectList projectList = manager.getAllProjects().getAllIndustrial();
        projects.getItems().clear();
        for (int i = 0; i < projectList.size() ; i++)
        {
          projects.getItems().add(projectList.get(i));
        }
      }
      else if (display.getSelectionModel().getSelectedItem().equals("Commercial Projects"))
      {
        ProjectList projectList = manager.getAllProjects().getAllCommercial();
        projects.getItems().clear();
        for (int i = 0; i < projectList.size() ; i++)
        {
          projects.getItems().add(projectList.get(i));
        }
      }
      else if (display.getSelectionModel().getSelectedItem().equals("Residential Projects"))
      {
        ProjectList projectList = manager.getAllProjects().getAllResidential();
        projects.getItems().clear();
        for (int i = 0; i < projectList.size() ; i++)
        {
          projects.getItems().add(projectList.get(i));
        }
      }
    }
    else if (e.getSource() == howToOrder)
    {
      ProjectList temp = new ProjectList();
      for (int i = 0; i < projects.getItems().size(); i++)
      {
        temp.add((GeneralProject) projects.getItems().get(i));
      }
      if(howToOrder.getSelectionModel().getSelectedItem().equals("None"))
      {
        projects.getItems().clear();
        for (int i = 0; i < temp.size(); i++)
        {
          projects.getItems().add(temp.get(i));
        }
      }
      else if (howToOrder.getSelectionModel().getSelectedItem().equals("By Budget"))
      {
        temp.sortByBudget();
        projects.getItems().clear();
        for (int i = 0; i < temp.size(); i++)
        {
          projects.getItems().add(temp.get(i));
        }
      }
      else if (howToOrder.getSelectionModel().getSelectedItem().equals("By Timeline"))
      {
        temp.sortByTimeline();
        projects.getItems().clear();
        for (int i = 0; i < temp.size(); i++)
        {
          projects.getItems().add(temp.get(i));
        }
      }
    }
    else if (e.getSource() == pushToWebsite)
    {
      ObservableList<GeneralProject> selected = projects.getSelectionModel().getSelectedItems();
      if(selected != null && selected.size() > 0)
      {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
            "Do you want to push " + selected.get(0).getProjectName() + " to the website?",
            ButtonType.YES, ButtonType.NO);
        alert.setTitle("Push to Website");
        alert.setHeaderText(null);
        alert.showAndWait();

        if(alert.getResult() == ButtonType.YES)
        {
          ProjectList temp = new ProjectList();
          for(int i = 0; i < selected.size(); i++)
          {
            temp.add(selected.get(i));
          }
          manager.saveXML(temp);
        }
      }

    }
  }


  
}
