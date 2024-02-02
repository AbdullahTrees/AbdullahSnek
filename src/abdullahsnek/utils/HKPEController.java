/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abdullahsnek.utils;

import abdullahsnek.Identifiers;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Abdullah
 */
public abstract class HKPEController 
{
    public class HKPE_super implements EventHandler<KeyEvent>
    {
        @Override
        public void handle(KeyEvent k)
        {
            throw new UnsupportedOperationException("An implementing KeyPress Handling Controller must override this function to suit their own needs");
        }
    }
    
    // this variable is meant to be written to by the constructor of the controller class.
    public HKPE_super HKPE;
}
