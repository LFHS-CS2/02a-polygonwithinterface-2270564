
/**
 * A shape with three sides that is a polygon
 */
public class Triangle extends Polygon
{

    public Triangle(int side1, int side2, int side3)
    {
      addSide(side1);
      addSide(side2);
      addSide(side3);

    }

  /**
   * returns true if at least two of the sides have the same length
   */
  public boolean isIsosceles()
  {
    return Math.abs(getSide(0) - getSide(1)) < .0001 ||
           Math.abs(getSide(0) - getSide(2)) < .0001 ||
           Math.abs(getSide(1) - getSide(2)) < .0001;

       
  }

  /**
   * returns the area of the triangle
   * HINT:  Use Herons formula from geometry.  If you do not remember it, look it up.
   */
  public double getArea()
  {
    double semi = (getSide(0) + getSide(1) + getSide(2))/2.0;
    return Math.sqrt(semi*(semi - getSide(0)) * (semi - getSide(1)) *(semi - getSide(2)));
      
  }

}
