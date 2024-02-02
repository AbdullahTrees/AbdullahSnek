/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package abdullahsnek.scenes;

import abdullahsnek.SnakeGameLoop;
import abdullahsnek.utils.HKPEController;
import abdullahsnek.utils.SceneSwitcher;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Abdullah
 */
public class MenuController extends HKPEController implements Initializable {

    @FXML
    private Button Btn_NewGame;

    public MenuController() 
    {
        HKPE = new HandleKeyPressEvents();
    }
    
    public class HandleKeyPressEvents extends HKPE_super implements EventHandler<KeyEvent>
    {
        @Override
        public void handle(KeyEvent k)
        {
            System.out.println(k);
        }  
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void click_NewGame(ActionEvent event)
    {
        // try to start a new game here...
        SceneSwitcher.switchToScene("/abdullahsnek/scenes/Game.fxml");
    }
    
}
