package GUIMain;

import javafx.application.Application;
import javafx.stage.Stage;

public class StartGUI extends Application
{
  public void start(Stage window)
  {
    ViewHandlerGUI viewHandlerGUI = new ViewHandlerGUI(window);
    viewHandlerGUI.start();
    window.show();
  }
}
