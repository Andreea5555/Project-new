package GUIMain;

import Model.GeneralProject;
import Model.ProjectModelManager;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

import java.io.IOException;

public class ViewHandlerGUI
{
  private Stage stage;
  private MainViewGUI mainViewGUI;
  private CreateProjectsGUI createProjectsGUI;
  private RoadConstructionViewGUI roadConstructionViewGUI;
  private ResidentialViewGUI residentialViewGUI;
  private CommercialViewGUI commercialViewGUI;
  private IndustrialViewGUI industrialViewGUI;
  private EditIndustrialViewGUI editIndustrialViewGUI;
  private EditCommercialViewGUI editCommercialViewGUI;
  private EditResidentialViewGUI editResidentialViewGUI;
  private EditRoadConstructionViewGUI editRoadConstructionViewGUI;
  private ProjectModelManager manager;

  public ViewHandlerGUI(Stage stage)
  {
    this.stage = stage;
  }

  public void openView(String id)
  {
    switch (id)
    {
      case "CreateProjects":
        stage.setScene(createProjectsGUI.getScene());
        createProjectsGUI.updateProjectTypes();
        stage.setTitle("New Project");
        break;
      case "MainView":
        stage.setScene(mainViewGUI.getScene());
        stage.setTitle("Main Page");
        mainViewGUI.updateProjectsView();
        break;
      case "RoadConstruction":
        stage.setScene(roadConstructionViewGUI.getScene());
        roadConstructionViewGUI.updateProjectTypes();
        stage.setTitle("New Project: Road Construction");
        break;
      case "Residential":
        stage.setScene(residentialViewGUI.getScene());
        stage.setTitle("New Project: Residential Project");
        residentialViewGUI.updateProjectTypes();
        break;
      case "Commercial":
        stage.setScene(commercialViewGUI.getScene());
        stage.setTitle("New Project: Commercial Project");
        commercialViewGUI.updateProjectTypes();
        break;
      case "Industrial":
        stage.setScene(industrialViewGUI.getScene());
        stage.setTitle("New Project: Industrial Project");
        industrialViewGUI.updateProjectTypes();
        break;
    }
  }
  public void openEditView(String id, GeneralProject editing)
  {
    if(id.equals("EditIndustrial"))
    {
      stage.setScene(editIndustrialViewGUI.getScene());
      stage.setTitle("Edit Industrial Project");
      editIndustrialViewGUI.setEditing(editing);
      editIndustrialViewGUI.loadValues();
    }
    else if (id.equals("EditCommercial"))
    {
      stage.setScene(editCommercialViewGUI.getScene());
      stage.setTitle("Edit Commercial Project");
      editCommercialViewGUI.setEditing(editing);
      editCommercialViewGUI.loadValues();
    }
    else if(id.equals("EditResidential"))
    {
      stage.setScene(editResidentialViewGUI.getScene());
      stage.setTitle("Edit Residential Project");
      editResidentialViewGUI.setEditing(editing);
      editResidentialViewGUI.loadValues();
    }
    else if (id.equals("EditRoadConstruction"))
    {
      stage.setScene(editRoadConstructionViewGUI.getScene());
      stage.setTitle("Edit Road Construction Project");
      editRoadConstructionViewGUI.setEditing(editing);
      editRoadConstructionViewGUI.loadValues();
    }
  }

  private void loadMainView()
  {
    try{
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("MainView.fxml"));
      Region root = loader.load();
      mainViewGUI = loader.getController();
      mainViewGUI.init(this, new Scene(root));
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }
  }

  private void loadCreateProject()
  {
    try{
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("CreateProjects.fxml"));
      Region root = loader.load();
      createProjectsGUI = loader.getController();
      createProjectsGUI.init(this, new Scene(root));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

  }

  private void loadRoadConstruction()
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("RoadConstructionView.fxml"));
      Region root = loader.load();
      roadConstructionViewGUI = loader.getController();
      roadConstructionViewGUI.init(this, new Scene(root), manager);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void loadResidential()
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("ResidentialView.fxml"));
      Region root = loader.load();
      residentialViewGUI = loader.getController();
      residentialViewGUI.init(this, new Scene(root), manager);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void loadCommercial()
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("CommercialView.fxml"));
      Region root = loader.load();
      commercialViewGUI = loader.getController();
      commercialViewGUI.init(this, new Scene(root), manager);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void loadIndustrial()
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("IndustrialView.fxml"));
      Region root = loader.load();
      industrialViewGUI = loader.getController();
      industrialViewGUI.init(this, new Scene(root), manager);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void loadEditIndustrial()
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("EditIndustrialView.fxml"));
      Region root = loader.load();
      editIndustrialViewGUI = loader.getController();
      editIndustrialViewGUI.init(this, new Scene(root), manager);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void loadEditCommercial()
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("EditCommercialView.fxml"));
      Region root = loader.load();
      editCommercialViewGUI = loader.getController();
      editCommercialViewGUI.init(this, new Scene(root), manager);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void loadEditResidential()
  {
    try{
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("EditResidentialView.fxml"));
      Region root = loader.load();
      editResidentialViewGUI = loader.getController();
      editResidentialViewGUI.init(this, new Scene(root), manager);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void loadEditRoadConstruction()
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("EditRoadConstructionView.fxml"));
      Region root = loader.load();
      editRoadConstructionViewGUI = loader.getController();
      editRoadConstructionViewGUI.init(this, new Scene(root), manager);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  public void start()
  {
    manager = new ProjectModelManager("Projects");
    loadMainView();
    loadCreateProject();
    loadRoadConstruction();
    loadResidential();
    loadCommercial();
    loadIndustrial();
    loadEditIndustrial();
    loadEditCommercial();
    loadEditResidential();
    loadEditRoadConstruction();
    openView("MainView");
  }

}
