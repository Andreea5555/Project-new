package GUIMain;

import Model.GeneralProject;
import Model.ProjectModelManager;
import Model.Residential;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
public class EditResidentialViewGUI
{
  private Scene scene;
  private ViewHandlerGUI viewHandlerGUI;
  @FXML private MenuItem backToMain;
  @FXML private MenuItem save;
  @FXML private TextField budget;
  @FXML private TextField time;
  @FXML private TextField manHours;
  @FXML private TextField numOfKitchens;
  @FXML private TextField numOfBathrooms;
  @FXML private TextField withPlumbing;
  @FXML private TextField projectState;
  @FXML private TextField size;
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
    Residential temp = (Residential) editing;
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
    forNumbers += temp.getNumberOfKitchens();
    numOfKitchens.setText(forNumbers);
    forNumbers = "";
    forNumbers += temp.getNumberOfBathrooms();
    numOfBathrooms.setText(forNumbers);
    forNumbers = "";
    forNumbers += temp.getOtherRoomsWithPlumbing();
    withPlumbing.setText(forNumbers);
    projectState.setText(temp.getProjectState());
    forNumbers = "";
    forNumbers += temp.getSize();
    size.setText(forNumbers);
  }

  public void handleActions(ActionEvent e)
  {
    if(e.getSource() == save)
    {
      if(!budget.getText().isEmpty() && !time.getText().isEmpty() && !manHours.getText().isEmpty() && !numOfKitchens.getText().isEmpty() && !numOfBathrooms.getText().isEmpty() && !withPlumbing.getText().isEmpty() && !projectState.getText().isEmpty() && !size.getText().isEmpty())
      {
        Residential temp = new Residential();
        temp.setProjectState(projectState.getText());
        try
        {
          temp.setActualBudget(Double.parseDouble(budget.getText()));
          temp.setTimeSpent(Integer.parseInt(time.getText()));
          temp.setManHoursUsed(Double.parseDouble(manHours.getText()));
          temp.setNumberOfKitchens(Integer.parseInt(numOfKitchens.getText()));
          temp.setNumberOfBathrooms(Integer.parseInt(numOfBathrooms.getText()));
          temp.setOtherRoomsWithPlumbing(Integer.parseInt(withPlumbing.getText()));
          temp.setSize(Double.parseDouble(size.getText()));
          Residential toUpdate = (Residential) editing;
          manager.editResidentialProjects(temp.getResources().getActualBudget(),temp.getResources().getTimeSpent(), temp.getProjectType(), temp.getResources().getManHoursUsed(), toUpdate.getProjectName(), temp.getNumberOfBathrooms(), temp.getNumberOfKitchens(), temp.getProjectState(), temp.getOtherRoomsWithPlumbing(), temp.getSize());
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
