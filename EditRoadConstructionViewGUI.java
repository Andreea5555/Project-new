package GUIMain;

import Model.GeneralProject;
import Model.ProjectModelManager;
import Model.RoadConstruction;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

import java.nio.file.attribute.AttributeView;

public class EditRoadConstructionViewGUI
{
  private Scene scene;
  private ViewHandlerGUI viewHandlerGUI;
  @FXML private MenuItem backToMain;
  @FXML private MenuItem save;
  @FXML private TextField time;
  @FXML private TextField bridgesAndTunnels;
  @FXML private TextField geoChallenges;
  @FXML private TextField budget;
  @FXML private TextField manHours;
  @FXML private TextField length;
  @FXML private TextField width;
  private GeneralProject editing;
  private ProjectModelManager manager;

  public void init(ViewHandlerGUI viewHandlerGUI, Scene scene, ProjectModelManager manager)
  {
    this.viewHandlerGUI = viewHandlerGUI;
    this.scene = scene;
    this.manager = manager;
  }

  public void setEditing(GeneralProject editing)
  {
    this.editing = editing;
  }
  public Scene getScene()
  {
    return scene;
  }

  public void loadValues()
  {
    RoadConstruction temp = (RoadConstruction) editing;
    String forNumbers = "";
    forNumbers += temp.getResources().getActualBudget();
    budget.setText(forNumbers);
    forNumbers = "";
    forNumbers += temp.getResources().getTimeSpent();
    time.setText(forNumbers);
    forNumbers = "";
    forNumbers += temp.getResources().getManHoursUsed();
    manHours.setText(forNumbers);
    forNumbers = "";
    forNumbers += temp.getLength();
    length.setText(forNumbers);
    forNumbers = "";
    forNumbers += temp.getWidth();
    width.setText(forNumbers);
    forNumbers = "";
    forNumbers += temp.getBridgesAndTunnels();
    bridgesAndTunnels.setText(forNumbers);
    geoChallenges.setText(temp.getGeoChallenges());
  }

  public void actionHandler(ActionEvent e)
  {
    if (e.getSource() == save)
    {
      if(!budget.getText().isEmpty() && !manHours.getText().isEmpty() && !length.getText().isEmpty() && !width.getText().isEmpty() && !time.getText().isEmpty() && !bridgesAndTunnels.getText().isEmpty() && !geoChallenges.getText().isEmpty())
      {
        RoadConstruction temp = new RoadConstruction();
        temp.setGeoChallenges(geoChallenges.getText());
        try
        {
          temp.setActualBudget(Double.parseDouble(budget.getText()));
          temp.setTimeSpent(Integer.parseInt(time.getText()));
          temp.setManHoursUsed(Double.parseDouble(manHours.getText()));
          temp.setLength(Double.parseDouble(length.getText()));
          temp.setWidth(Double.parseDouble(width.getText()));
          temp.setBridgesAndTunnels(Integer.parseInt(bridgesAndTunnels.getText()));
          RoadConstruction toUpdate = (RoadConstruction) editing;
          manager.editRoadConstructionProjects(temp.getResources().getActualBudget(), temp.getResources().getTimeSpent(), temp.getProjectType(), temp.getResources().getManHoursUsed(), toUpdate.getProjectName(), temp.getLength(), temp.getWidth(), temp.getBridgesAndTunnels(), temp.getGeoChallenges());
          viewHandlerGUI.openView("MainView");
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
    else if (e.getSource() == backToMain)
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
  }
}
