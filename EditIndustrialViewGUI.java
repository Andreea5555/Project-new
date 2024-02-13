package GUIMain;


import Model.GeneralProject;
import Model.IndustrialProject;
import Model.ProjectList;
import Model.ProjectModelManager;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class EditIndustrialViewGUI
{
  private Scene scene;
  private ViewHandlerGUI viewHandlerGUI;
  @FXML private MenuItem backToMain;
  @FXML private MenuItem save;
  @FXML private TextField budget;
  @FXML private TextField time;
  @FXML private TextField manHours;
  @FXML private TextField size;
  @FXML private TextField typeOfFacility;
  private ProjectModelManager manager;
  private GeneralProject editing;

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
    IndustrialProject temp = (IndustrialProject) editing;
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
    forNumbers += temp.getSize();
    size.setText(forNumbers);
    typeOfFacility.setText(temp.getTypeOfFacility());
  }

  public void actionHandler(ActionEvent e)
  {
    if(e.getSource() == save)
    {

      if(!budget.getText().isEmpty() && !time.getText().isEmpty() && !manHours.getText().isEmpty() && !size.getText().isEmpty() && !typeOfFacility.getText().isEmpty())
      {

        IndustrialProject temp = new IndustrialProject();
        temp.setTypeOfFacility(typeOfFacility.getText());
        try
        {
          temp.setActualBudget(Double.parseDouble(budget.getText()));
          temp.setTimeSpent(Integer.parseInt(time.getText()));
          temp.setManHoursUsed(Double.parseDouble(manHours.getText()));
          temp.setSize(Double.parseDouble(size.getText()));
          IndustrialProject toUpdate = (IndustrialProject) editing;
          manager.editIndustrialProjects(temp.getResources().getActualBudget(), temp.getResources().getTimeSpent(), temp.getProjectType(), temp.getResources().getManHoursUsed(), toUpdate.getProjectName(), temp.getSize(), temp.getTypeOfFacility());
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
