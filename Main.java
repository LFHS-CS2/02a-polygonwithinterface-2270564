import java.util.*;

class Main {
  public static void main(String[] args) {
  }
public static Shape2D[] getShapes()
{
  Circle circ = new Circle(4.0);
  Rectangle rect = new Rectangle(4, 2);
  Triangle tri = new Triangle(3, 3, 3);
  Shape2D[] shapey= new Shape2D[3];
  shapey[0] = circ;
  shapey[1] = tri;
  shapey[2] = rect;
  return shapey;
}
}
