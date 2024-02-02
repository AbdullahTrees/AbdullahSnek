/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abdullahsnek;

import abdullahsnek.Identifiers.Direction;
import abdullahsnek.scenes.GameController;
import abdullahsnek.utils.SceneSwitcher;
/**
 *
 * @author Abdullah
 */
public class SnakeGameLoop
{
    // player
    Snake playerSnek;

    // move right by default (maybe these inits are not necessary?)
    Direction prev_moving;
    Direction to_move;
    Direction cur_moving;
    
    public SnakeGameLoop() 
    {
        playerSnek = new Snake(3, new Coords(3, 3));
        
        prev_moving = Direction.RIGHT;
        to_move = Direction.RIGHT;
        cur_moving = Direction.RIGHT;
    }
    
    public void step()  // equivalent to updating the state of the game by 1 action/frame
    {
        switch (to_move)
        {
            case UP:
                if (prev_moving == Direction.DOWN)
                    to_move = prev_moving;
            case DOWN:
                if (prev_moving == Direction.UP)
                    to_move = prev_moving;
            case LEFT:
                if (prev_moving == Direction.RIGHT)
                    to_move = prev_moving;
            case RIGHT:
                if (prev_moving == Direction.LEFT)
                    to_move = prev_moving;
        }

        cur_moving = to_move;
        playerSnek.moveSnake(cur_moving);
        // after moving, it is now the previous direction in which it was moving
        prev_moving = cur_moving;
    }

    public void setDirection(Direction d) 
    {
        to_move = d;
    }

    public Snake getSnake() 
    {
        return playerSnek;
    }
}
