/* FILE NAME   : Coordinates.java
 * PROGRAMMER  : DS6
 * @author     : Sokolov Dmitry
 * LAST UPDATE : 10.03.2023
 * PURPOSE     : Coordinates Organization
 */

package Organization;

public class Coordinates {
    private long x; //Максимальное значение поля: 890
    private double y;

    public Coordinates(long x, double y){
        if (x >= 890)
            this.x = 890;
        this.x = x;
        this.y = y;
    }
    public void print(){
        System.out.println("Coordinates 'x' = " + this.x);
        System.out.println("Coordinates 'y' = " + this.y);
    }

    public String getCoordinatesinXML(){
        String start = "\t\t<Coordinates>\n";
        String x = "\t\t\t<x>" + String.valueOf(this.x) + "</x>\n";
        String y = "\t\t\t<y>" + String.valueOf(this.y) + "</y>\n";
        String end = "\t\t</Coordinates>\n";
        return start + x + y + end;
    }
}