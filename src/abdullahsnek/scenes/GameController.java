/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package abdullahsnek.scenes;

import abdullahsnek.Coords;
import static abdullahsnek.Identifiers.BOARD_HEIGHT;
import abdullahsnek.Identifiers.Direction;
import abdullahsnek.Snake;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import abdullahsnek.Identifiers.Direction;
import static abdullahsnek.Identifiers.BOARD_WIDTH;
import abdullahsnek.SnakeGameLoop;
import abdullahsnek.Timer;
import abdullahsnek.utils.HKPEController;
import abdullahsnek.utils.SceneSwitcher;

/**
 * FXML Controller class
 *
 * @author Abdullah
 */
public class GameController extends HKPEController implements Initializable
{
    @FXML
    private GridPane GameBoardDisplay;
    @FXML
    private Rectangle PlayerSquare;
    @FXML
    private Label Label_ScoreView;
    @FXML
    private Line ScoreBoard_Border;
    @FXML
    private BorderPane rootborderpane;
    @FXML
    private Label wait_for_start;
    
    
    
    // game information
    SnakeGameLoop SGL;
    
    // test, toggle label visibility
    boolean startgame = false;
    
    /**
     * Initializes the controller class.
     */
    public GameController() 
    {
        HKPE = new HandleKeyPressEvents();
        SGL = new SnakeGameLoop();
    }

    public class HandleKeyPressEvents extends HKPE_super
    {
        @Override
        public void handle(KeyEvent k)
        {
            // direction (moving based on the user input)
            Direction movingTo = Direction.RIGHT;
            //  view key xd
            //System.out.println(k);
            
            if (!startgame)
                startgame = true;
            
            switch (k.getCode())
            {
                case ESCAPE:
                    Platform.exit();
                    break;
                case UP:
                    movingTo = Direction.UP;
                    break;
                case DOWN:
                    movingTo = Direction.DOWN;
                    break;
                case LEFT:
                    movingTo = Direction.LEFT;
                    break;
                case RIGHT:
                    movingTo = Direction.RIGHT;
                    break;
            }
            
            SGL.setDirection(movingTo);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // init board
        ScoreBoard_Border.endXProperty().bind(rootborderpane.widthProperty());
        removeSquareAt(11, 8);
        
        Timer t = new Timer(300, this, SGL);
        t.start();
    }    
    
    public synchronized void drawSnake()
    {
        GameBoardDisplay.getChildren().clear();
        for (Coords c: SGL.getSnake().getSnakeparts())
        {
            drawSquareAt(c.x, c.y);
        }
    }
    
    private synchronized void drawSquareAt(int x, int y)
    {
        // don't allow drawing square at wierd x/y
        if ((x < 0 || x > BOARD_WIDTH) || (y < 0 || y > BOARD_HEIGHT))
            return; // nop
        
        Rectangle SnakeSquares = new Rectangle();
        SnakeSquares.widthProperty().bind(GameBoardDisplay.widthProperty().divide(BOARD_WIDTH));
        SnakeSquares.heightProperty().bind(GameBoardDisplay.heightProperty().divide(BOARD_HEIGHT));
        
        GameBoardDisplay.add(SnakeSquares, x, y);
    }
    
    private void removeSquareAt(int x, int y)
    {
        if ((x < 0 || x > 16) || (y < 0 || y > 16))
            return; // nop
        
        int col = x, row = y;
        // doesnt work
        //GameBoardDisplay.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row);
    
        //System.out.print(GameBoardDisplay.getChildren());
        for (final Node n : GameBoardDisplay.getChildren())
        {
//            System.out.println(n);
//            // experiment to find out what the heck is a group
//            Group k = new Group();
//            if (n.getClass() == k.getClass())
//            {
//                System.out.println(((Group)n).getChildren()); 
//            }
                
            if (n != null && n.getClass() != Group.class)   // what the hell is this group thing??? 
                if (GridPane.getColumnIndex(n) == col && GridPane.getRowIndex(n) == row)
                {
                    GameBoardDisplay.getChildren().remove(n);
                    return;
                }
        }
    }


}
