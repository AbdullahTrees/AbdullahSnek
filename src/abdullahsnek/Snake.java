/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abdullahsnek;

import abdullahsnek.Identifiers.Direction;
import java.util.LinkedList;

/**
 *
 * @author Abdullah
 */
public class Snake
{
    LinkedList<Coords> snakeparts;  // parts of a snake which should all be rendered...
    int growing = 0;
    
    // create a new snek with provided len
    public Snake(int len, Coords x)
    {    
        this.snakeparts = new LinkedList<Coords>();
        this.snakeparts.add(x);
        
        // ensure valid len
        if (len > 0)
            this.growing = len - 1;
        else
            this.growing = 3; // default len is 3.
    }
    
    public void moveSnake(Direction d) // advance all snakeparts by one step depending on the direction moved
    {
        // depending on the direction, add a new snakepart to the top of the list
        Coords newpart = new Coords(snakeparts.getFirst());
        switch (d)
        {
            case UP:
                newpart.y--;
                break;
            case DOWN:
                newpart.y++;
                break;
            case LEFT:
                newpart.x--;
                break;
            case RIGHT:
                newpart.x++;
                break;
        }
        snakeparts.addFirst(newpart);
        
        if (growing > 0)   // grows from the end.
            growing--;
        else   // remove the last part cause it moved
            snakeparts.removeLast();
    }
    
    public void growSnake(int changeInSize)
    {
        if (changeInSize >= 0)
            growing = changeInSize;
    }

    public LinkedList<Coords> getSnakeparts() {
        return snakeparts;
    }
}
