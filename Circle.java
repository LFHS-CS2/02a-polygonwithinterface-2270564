public class Circle implements Shape2D
 {
  public double radius;
  public Circle(double rad)
  {
    radius = rad;
  }
  public void setRadii(double rad)
  {
    radius = rad;
  }
  public double getArea()
  {
    return (radius*radius)*PI;
  }
  public double getPerimeter()
  {
    return 2*radius*PI;
  }
}
