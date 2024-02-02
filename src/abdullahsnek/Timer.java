/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abdullahsnek;

import abdullahsnek.scenes.GameController;

/**
 *
 * @author Abdullah
 */

/*
    An instance of this class executes on another thread, where on a regular time interval, it notifies the GameController that 
    a certain amount of time has passed. This then allows the GameController to move ahead the logic or render things on screen.

    This is basically where FPS arises from. 
*/ 
public class Timer extends Thread
{
    GameController gc;
    SnakeGameLoop sgl;
    final int interval;
    
    public Timer(int interval, GameController gc, SnakeGameLoop sgl) 
    {
        this.gc = gc;
        this.sgl = sgl;
        this.interval = interval;
        this.setDaemon(true);
    }
    
    @Override
    public void run() 
    {
        while (true)
        {
            try {Thread.sleep(interval);} catch (InterruptedException ex) {System.out.println("!!!Oy Vey! The timer just ended!!!"); break;}  // exit the timer if it got interrupted, dunno wat to do if this ever happens
            
            sgl.step();
            gc.drawSnake();
            gc.notify();
        }
    }
    
}
