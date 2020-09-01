
import java.util.ArrayList;

public class Polygon
{
  private ArrayList<Double> sides;
  
  public Polygon() {
    sides = new ArrayList<Double>();
  }
  
  /**
   * add the given side to sides
   */
  public void addSide(double sideLength)
  {
      sides.add(sideLength);
  }

  /**
   * return the perimeter of the polygon
   */
  public double getPerimeter()
  {
    double perim = 0;
    for (double side : sides)
      perim += side;
    return perim;
  }

  /**
   * return number of sides of polygon
   */
  public int getNumSides()
  {
    return sides.size();
  }

  /**
   * returns the side length at the given index in sides
   */
  public double getSide(int index)
  {
    return sides.get(index);
  }
  
  /**
   * returns true only if all sides are the same length
  */
  public boolean isRegular()
  {
    if (sides.size() > 0)
    {
      for (int i = 1; i < sides.size(); i++) {
        if (Math.abs(sides.get(i)-sides.get(0)) > .000001)
          return false;
      }
    }
        
    return true;
  }
  
  /** 
   * returns each side (in sides)separated by a space
   */
  public String toString() 
  {
    String ans = "";
    for (double side : sides)
      ans += side + " ";
      
    return ans.trim();
  }

  /**
   * return true if the polygons are the same size with the same sides in the same order.
   */
  public boolean equals(Object obj)
  {
    Polygon other = (Polygon)obj;
    if (sides.size() != other.sides.size())
      return false;
    for (int i = 0; i < sides.size(); i++)
      if (Math.abs(sides.get(i)-other.sides.get(i)) > .00001)
        return false;
        
    return true;
  }

}
