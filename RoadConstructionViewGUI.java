package GUIMain;

import Model.ProjectModelManager;
import Model.RoadConstruction;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class RoadConstructionViewGUI
{
  private Scene scene;
  private ViewHandlerGUI viewHandlerGUI;
  @FXML private ComboBox<String> projectTypes;
  @FXML private MenuItem backToMain;
  @FXML private MenuItem clear;
  @FXML private MenuItem save;
  @FXML private TextField time;
  @FXML private TextField bridgesAndTunnels;
  @FXML private TextField geoChallenges;
  @FXML private TextField projectName;
  @FXML private TextField budget;
  @FXML private TextField manHours;
  @FXML private TextField length;
  @FXML private TextField width;
  private RoadConstruction base;
  private ProjectModelManager manager;

  public void init(ViewHandlerGUI viewHandlerGUI, Scene scene, ProjectModelManager manager)
  {
    this.viewHandlerGUI = viewHandlerGUI;
    this.scene = scene;
    this.manager = manager;
  }

  //This is what initially adds the options to allow choosing of project types
  public void updateProjectTypes()
  {
    clearAll();
    projectTypes.getItems().clear();
    projectTypes.getItems().add("Select...");
    projectTypes.getItems().add("Residential Project");
    projectTypes.getItems().add("Commercial Project");
    projectTypes.getItems().add("Industrial Project");
    projectTypes.getSelectionModel().select(0);
    base = new RoadConstruction();
    String temp = "";
    temp += base.getTimeline();
    time.appendText(temp);
    temp = "";
    temp += base.getBridgesAndTunnels();
    bridgesAndTunnels.appendText(temp);
    geoChallenges.appendText(base.getGeoChallenges());
  }

  public Scene getScene()
  {
    return scene;
  }

  public void actionHandler(ActionEvent e)
  {
    if (e.getSource() == projectTypes)
    {
      if (projectTypes.getSelectionModel().getSelectedItem() != null
          && projectTypes.getSelectionModel().getSelectedItem()
          .equals("Residential Project"))
      {
        if(!projectName.getText().isEmpty() || !budget.getText().isEmpty() || !manHours.getText().isEmpty() || !length.getText().isEmpty() || !width.getText().isEmpty())
        {
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
              "Are you sure you want to switch?",
              ButtonType.YES, ButtonType.NO);
          alert.setTitle("Switch Projects");
          alert.setHeaderText(null);
          alert.showAndWait();
          if(alert.getResult() == ButtonType.YES)
          {
            viewHandlerGUI.openView("Residential");
          }
          else {
            projectTypes.getSelectionModel().select(0);
          }
        }
        else
        {
          viewHandlerGUI.openView("Residential");
        }

      }
      else if (projectTypes.getSelectionModel().getSelectedItem() != null
          && projectTypes.getSelectionModel().getSelectedItem()
          .equals("Commercial Project"))
      {
        if(!projectName.getText().isEmpty() || !budget.getText().isEmpty() || !manHours.getText().isEmpty() || !length.getText().isEmpty() || !width.getText().isEmpty())
        {
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
              "Are you sure you want to switch?",
              ButtonType.YES, ButtonType.NO);
          alert.setTitle("Switch Projects");
          alert.setHeaderText(null);
          alert.showAndWait();
          if(alert.getResult() == ButtonType.YES)
          {
            viewHandlerGUI.openView("Commercial");
          }
          else {
            projectTypes.getSelectionModel().select(0);
          }
        }
        else
        {
          viewHandlerGUI.openView("Commercial");
        }
      }
      else if (projectTypes.getSelectionModel().getSelectedItem() != null && projectTypes.getSelectionModel().getSelectedItem().equals("Industrial Project"))
      {
        if(!projectName.getText().isEmpty() || !budget.getText().isEmpty() || !manHours.getText().isEmpty() || !length.getText().isEmpty() || !width.getText().isEmpty())
        {
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
              "Are you sure you want to switch?",
              ButtonType.YES, ButtonType.NO);
          alert.setTitle("Switch Projects");
          alert.setHeaderText(null);
          alert.showAndWait();
          if(alert.getResult() == ButtonType.YES)
          {
            viewHandlerGUI.openView("Industrial");
          }
          else {
            projectTypes.getSelectionModel().select(0);
          }
        }
        else
        {
          viewHandlerGUI.openView("Industrial");
        }

      }
    }
    else if (e.getSource() == backToMain)
    {
      if(!projectName.getText().isEmpty() || !budget.getText().isEmpty() || !manHours.getText().isEmpty() || !length.getText().isEmpty() || !width.getText().isEmpty())
      {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
            "Are you sure you want to go back?",
            ButtonType.YES, ButtonType.NO);
        alert.setTitle("Back to Main Menu");
        alert.setHeaderText(null);
        alert.showAndWait();
        if(alert.getResult() == ButtonType.YES)
        {
          viewHandlerGUI.openView("MainView");
        }
      }
      else
      {
        viewHandlerGUI.openView("MainView");
      }
    }
    else if (e.getSource() == clear)
    {
      if(!projectName.getText().isEmpty() || !budget.getText().isEmpty() || !manHours.getText().isEmpty() || !length.getText().isEmpty() || !width.getText().isEmpty())
      {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
            "Are you sure you want to clear the values?",
            ButtonType.YES, ButtonType.NO);
        alert.setTitle("Clear");
        alert.setHeaderText(null);
        alert.showAndWait();
        if(alert.getResult() == ButtonType.YES)
        {
          updateProjectTypes();
        }
      }
    }
    else if (e.getSource() == save)
    {
      if(!projectName.getText().isEmpty() && !manager.isUnique(projectName.getText()))
      {
        Alert alert = new Alert(Alert.AlertType.ERROR,
            "This name already exists, please choose a different one.",
            ButtonType.OK);
        alert.setTitle("Not Unique");
        alert.setHeaderText(null);
        alert.showAndWait();
      }
      else if(!projectName.getText().isEmpty() && !budget.getText().isEmpty() && !manHours.getText().isEmpty() && !length.getText().isEmpty() && !width.getText().isEmpty() && !time.getText().isEmpty() && !bridgesAndTunnels.getText().isEmpty() && !geoChallenges.getText().isEmpty())
      {
        RoadConstruction temp = new RoadConstruction();
        temp.setProjectName(projectName.getText());
        temp.setGeoChallenges(geoChallenges.getText());
        try
        {
          temp.setBudget(Double.parseDouble(budget.getText()));
          temp.setTimeline(Integer.parseInt(time.getText()));
          temp.setManHours(Double.parseDouble(manHours.getText()));
          temp.setLength(Double.parseDouble(length.getText()));
          temp.setWidth(Double.parseDouble(width.getText()));
          temp.setBridgesAndTunnels(Integer.parseInt(bridgesAndTunnels.getText()));
          manager.saveAProject(temp);
          updateProjectTypes();
        }
        catch (NumberFormatException f)
        {
          Alert alert = new Alert(Alert.AlertType.ERROR,
              "The value of one of one or more fields are incorrect, please check.",
              ButtonType.YES);
          alert.setTitle("ERROR");
          alert.setHeaderText(null);
          alert.showAndWait();
        }

      }
      else
      {
        Alert alert = new Alert(Alert.AlertType.ERROR,
            "One or more fields are empty.",
            ButtonType.OK);
        alert.setTitle("ERROR: empty");
        alert.setHeaderText(null);
        alert.showAndWait();

      }
    }
  }

  //This was added to clear all textfields
  public void clearAll()
  {
    projectName.clear();
    budget.clear();
    manHours.clear();
    length.clear();
    width.clear();
    time.clear();
    bridgesAndTunnels.clear();
    geoChallenges.clear();
  }
}
