/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abdullahsnek.utils;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author Abdullah
 */
public class SceneSwitcher
{
    public static Class<?> global_class_handle;
    public static Stage mainstage;
    
    // Changes the window(in cur_stage) to the Scene(in fxml_url). No other properties are changed. 
    public static Initializable switchToScene(String fxml_url)
    {
        // remove previous eventhandlers if there are any
        try
        {
            HKPEController hkpe_c = (HKPEController) mainstage.getScene().getRoot().getUserData();
            mainstage.removeEventHandler(KeyEvent.KEY_PRESSED, hkpe_c.HKPE);
        }
        catch (Throwable t)
        {
            // do nothing, an exception probably means there was no controller class or handler wasnt set bla bla bla
        }
                
        try
        {
            FXMLLoader loader = new FXMLLoader(global_class_handle.getResource(fxml_url));
            Parent root = loader.load();
            
            // set keypress handler
            HKPEController hkpe_c = loader.getController();
            //System.out.println(hkpe_c);
            mainstage.addEventHandler(KeyEvent.KEY_PRESSED, hkpe_c.HKPE);
            root.setUserData(hkpe_c); // keep the loader instance cause why not, we need a way to remove event handlers just in case
            
            Scene scene = new Scene(root);
            mainstage.setScene(scene);
            mainstage.show();
            
            return (Initializable)hkpe_c;
        }
        catch (Throwable t)
        { 
            t.printStackTrace();
            if (global_class_handle.getResource(fxml_url) == null)
            {
                System.out.println("\n-----getResource failed! Ensure fxml_url is correct...\nfxml_url: " + fxml_url + "\n");
            }
        }
        
        return null;
    }
    
    public static Parent getRootNodeFromURL(String fxml_url)
    {
        try
        {
            Parent root = FXMLLoader.load(global_class_handle.getResource(fxml_url));
            
            return root;
        }
        catch (Throwable t)
        { 
            t.printStackTrace();
            if (global_class_handle.getResource(fxml_url) == null)
            {
                System.out.println("\n-----getResource failed! Ensure fxml_url is correct...\nfxml_url: " + fxml_url + "\n");
            }
            return null;
        }
    }
    
    public static Stage getStageFromEvent(Event event)
    {
        return (Stage)((Node)event.getSource()).getScene().getWindow();
    }
    
    public static Stage getStageFromNode(Node n)
    {
        return (Stage)(n.getScene().getWindow());
    }
    
    public static void raiseAlert_NotImplemented()
    {
        Alert win = new Alert(AlertType.WARNING);
        win.setContentText("This feature has not been implemented yet.");
    
        win.showAndWait();
    }
    
    public static void raiseAlert_BugCheck(String errorstr)
    {
        Alert win = new Alert(AlertType.WARNING);
        win.setHeaderText("Oh no! A bug!");
        win.setContentText("You shouldn't be seeing this dialog box! If you see this, let the developers know.\nHere's some additional information that could help them...\n\n\n" + errorstr);
        
        win.showAndWait();
    }
    
    public static void raiseAlert_GenericError(String title, String header, String content)
    {
        Alert win = new Alert(AlertType.ERROR);
        if (title != null && !title.equals(""))
            win.setTitle(title);
        
        if (header != null && !header.equals(""))
            win.setHeaderText(header);
        
        if (content != null && !content.equals(""))
            win.setContentText(content);
        
        win.showAndWait();
    }
    
    public static void raiseAlert_GenericWarning(String title, String header, String content)
    {
        Alert win = new Alert(AlertType.WARNING);
        if (title != null && !title.equals(""))
            win.setTitle(title);
        
        if (header != null && !header.equals(""))
            win.setHeaderText(header);
        
        if (content != null && !content.equals(""))
            win.setContentText(content);
        
        win.showAndWait();
    }
}
