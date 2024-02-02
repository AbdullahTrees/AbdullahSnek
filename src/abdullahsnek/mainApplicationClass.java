/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package abdullahsnek;

import abdullahsnek.utils.SceneSwitcher;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Abdullah
 */
public class mainApplicationClass extends Application {
    
    @Override
    public void start(Stage stage) throws Exception
    {
        SceneSwitcher.mainstage = stage;
        SceneSwitcher.global_class_handle = getClass();
        
        
        SceneSwitcher.switchToScene("/abdullahsnek/scenes/Menu.fxml");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
