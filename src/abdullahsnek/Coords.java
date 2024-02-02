/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abdullahsnek;

/**
 *
 * @author Abdullah
 */
public class Coords 
{
    public int x;
    public int y;

    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // copy constructor, apparently java's .clone is broken and the only reliable way to copy something is to do it from inside the class
    public Coords(Coords c) {
        this.x = c.x;
        this.y = c.y;
    }
}
