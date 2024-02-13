package GUIMain;

import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;

public class CreateProjectsGUI
{
  private Scene scene;
  private ViewHandlerGUI viewHandlerGUI;
  @FXML private ComboBox<String> projectTypes;
  @FXML private MenuItem backToMain;


  public void init(ViewHandlerGUI viewHandlerGUI, Scene scene)
  {
    this.viewHandlerGUI = viewHandlerGUI;
    this.scene = scene;
  }

  public void updateProjectTypes()
  {
    projectTypes.getItems().clear();
    projectTypes.getItems().add("Select...");
    projectTypes.getItems().add("Road Construction Project");
    projectTypes.getItems().add("Residential Project");
    projectTypes.getItems().add("Commercial Project");
    projectTypes.getItems().add("Industrial Project");
    projectTypes.getSelectionModel().select(0);
  }



  public Scene getScene()
  {
    return scene;
  }


  public void handleActions(ActionEvent e)
  {
    if(e.getSource() == backToMain)
    {
      viewHandlerGUI.openView("MainView");
    }
    else if(e.getSource() == projectTypes)
    {
      if(projectTypes.getSelectionModel().getSelectedItem() != null && projectTypes.getSelectionModel().getSelectedItem().equals("Road Construction Project"))
      {
        viewHandlerGUI.openView("RoadConstruction");
      }
      else if (projectTypes.getSelectionModel().getSelectedItem() != null && projectTypes.getSelectionModel().getSelectedItem().equals("Residential Project"))
      {
        viewHandlerGUI.openView("Residential");
      }
      else if (projectTypes.getSelectionModel().getSelectedItem() != null && projectTypes.getSelectionModel().getSelectedItem().equals("Commercial Project"))
      {
        viewHandlerGUI.openView("Commercial");
      }
      else if (projectTypes.getSelectionModel().getSelectedItem() != null && projectTypes.getSelectionModel().getSelectedItem().equals("Industrial Project"))
      {
        viewHandlerGUI.openView("Industrial");
      }
    }
  }
}
