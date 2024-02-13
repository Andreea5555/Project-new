package GUIMain;

import Model.ProjectModelManager;
import Model.Residential;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class ResidentialViewGUI
{
  private Scene scene;
  private ViewHandlerGUI viewHandlerGUI;
  @FXML private MenuItem backToMain;
  @FXML private MenuItem clear;
  @FXML private MenuItem save;
  @FXML private ComboBox<String> projectTypes;
  @FXML private TextField projectName;
  @FXML private TextField budget;
  @FXML private TextField time;
  @FXML private TextField manHours;
  @FXML private TextField numOfKitchens;
  @FXML private TextField numOfBathrooms;
  @FXML private TextField withPlumbing;
  @FXML private TextField projectState;
  @FXML private TextField size;
  private Residential base;
  private ProjectModelManager manager;

  public void init(ViewHandlerGUI viewHandlerGUI, Scene scene, ProjectModelManager manager)
  {
    this.viewHandlerGUI = viewHandlerGUI;
    this.scene = scene;
    this.manager = manager;
  }

  public void updateProjectTypes()
  {
    clearAll();
    projectTypes.getItems().clear();
    projectTypes.getItems().add("Select...");
    projectTypes.getItems().add("Road Construction Project");
    projectTypes.getItems().add("Commercial Project");
    projectTypes.getItems().add("Industrial Project");
    projectTypes.getSelectionModel().select(0);
    base = new Residential();
    String temp = "";
    temp += base.getTimeline();
    time.appendText(temp);
    temp = "";
    temp += base.getNumberOfKitchens();
    numOfKitchens.appendText(temp);
    temp = "";
    temp += base.getNumberOfBathrooms();
    numOfBathrooms.appendText(temp);
    temp = "";
    temp += base.getOtherRoomsWithPlumbing();
    withPlumbing.appendText(temp);
    projectState.appendText(base.getProjectState());
  }

  public Scene getScene()
  {
    return scene;
  }

  public void handleActions(ActionEvent e)
  {
    if(e.getSource() == backToMain)
    {
      if(!projectName.getText().isEmpty() || !budget.getText().isEmpty() || !manHours.getText().isEmpty() || !size.getText().isEmpty())
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
    else if(e.getSource() == projectTypes)
    {
      if(projectTypes.getSelectionModel().getSelectedItem() != null && projectTypes.getSelectionModel().getSelectedItem().equals("Road Construction Project"))
      {
        if(!projectName.getText().isEmpty() || !budget.getText().isEmpty() || !manHours.getText().isEmpty() || !size.getText().isEmpty())
        {
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
              "Are you sure you want to switch?",
              ButtonType.YES, ButtonType.NO);
          alert.setTitle("Switch Projects");
          alert.setHeaderText(null);
          alert.showAndWait();
          if(alert.getResult() == ButtonType.YES)
          {
            viewHandlerGUI.openView("RoadConstruction");
          }
          else {
            projectTypes.getSelectionModel().select(0);
          }
        }
        else
        {
          viewHandlerGUI.openView("RoadConstruction");
        }
      }
      else if (projectTypes.getSelectionModel().getSelectedItem() != null && projectTypes.getSelectionModel().getSelectedItem().equals("Commercial Project"))
      {
        if(!projectName.getText().isEmpty() || !budget.getText().isEmpty() || !manHours.getText().isEmpty() || !size.getText().isEmpty())
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
        if(!projectName.getText().isEmpty() || !budget.getText().isEmpty() || !manHours.getText().isEmpty() || !size.getText().isEmpty())
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
    else if (e.getSource() == clear)
    {
      if(!projectName.getText().isEmpty() || !budget.getText().isEmpty() || !manHours.getText().isEmpty() || !size.getText().isEmpty())
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
      else if(!projectName.getText().isEmpty() && !budget.getText().isEmpty() && !time.getText().isEmpty() && !manHours.getText().isEmpty() && !numOfKitchens.getText().isEmpty() && !numOfBathrooms.getText().isEmpty() && !withPlumbing.getText().isEmpty() && !projectState.getText().isEmpty() && !size.getText().isEmpty())
      {
        Residential temp = new Residential();
        temp.setProjectName(projectName.getText());
        temp.setProjectState(projectState.getText());
        try
        {
          temp.setBudget(Double.parseDouble(budget.getText()));
          temp.setTimeline(Integer.parseInt(time.getText()));
          temp.setManHours(Double.parseDouble(manHours.getText()));
          temp.setNumberOfKitchens(Integer.parseInt(numOfKitchens.getText()));
          temp.setNumberOfBathrooms(Integer.parseInt(numOfBathrooms.getText()));
          temp.setOtherRoomsWithPlumbing(Integer.parseInt(withPlumbing.getText()));
          temp.setSize(Double.parseDouble(size.getText()));
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
  public void clearAll()
  {
    projectName.clear();
    budget.clear();
    time.clear();
    manHours.clear();
    numOfKitchens.clear();
    numOfBathrooms.clear();
    withPlumbing.clear();
    projectState.clear();
    size.clear();
  }
}
