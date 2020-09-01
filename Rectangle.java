
/**
 * Polygon with four sides and right angles
 */
public class Rectangle extends Polygon
{

  /**
  * Constructs a rectangles with given side lengths
  **/
  public Rectangle(int width, int height)
  {
    addSide(width);
    addSide(height);
    addSide(width);
    addSide(height);
       
  }
    
  /**
   * Multiplies the sides together to find the area of the rectangle
  */
  public double getArea()
  {
    return getSide(0) * getSide(1);
      
  }
   
}
