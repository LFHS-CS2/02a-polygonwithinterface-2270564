import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.*;
/**
 * @author  Steve Aronson
 */
public class TestMain
{
    public static void main(String args[]) {
        TestMain test = new TestMain();
        test.testProtected();
        test.testShape2D();
        test.testCircle();
        test.testGetShapes();
    }

    @Test
    public void testProtected() {
        try
        {
            Class<?> shape2D = Class.forName("Polygon");
            Field[] fields = shape2D.getDeclaredFields();
            if(fields.length == 0 || !fields[0].toString().contains("protected"))
                fail("sides needs to be protected in Polygon ");

        }
        catch (Exception e)
        {
            fail(e.toString());
        }
    }

    @Test
    public void testShape2D() {
        try
        {
            Class<?> shape2D = Class.forName("Shape2D");
            Field[] fields = shape2D.getDeclaredFields();
            if(fields.length == 0 || !fields[0].toString().endsWith("Shape2D.PI") || !fields[0].toString().contains("double"))
                fail("Shape2D does not have double PI");
            else if (Math.abs((double)fields[0].getDouble(shape2D) - 3.1415927) > .000000001)
                fail("PI does not equal 3.1415927");

            Method m = shape2D.getDeclaredMethod("getArea");
            m = shape2D.getDeclaredMethod("getPerimeter");

            Class<?> polygon = Class.forName("Polygon");
            Class<?>[] interfaces = polygon.getInterfaces();
            if (interfaces.length == 0 || !interfaces[0].equals(shape2D))
                fail("Polygon does not implement Shape2D as its only interface");

        }
        catch (Exception e)
        {
            fail(e.toString());
        }
    }

    @Test
    public void testCircle() {
        try
        {
            Class<?> shape2D = Class.forName("Shape2D");

            Class<?> polygon = Class.forName("Polygon");
            Class<?>[] interfaces = polygon.getInterfaces();

            Class<?> circle = Class.forName("Circle");
            interfaces = circle.getInterfaces();
            if (interfaces.length == 0 || !interfaces[0].equals(shape2D))
                fail("Circle does not implement Shape2D as its only interface");
            else {
                Constructor c = circle.getConstructor(new Class[] {double.class});
                Object[] cArgs = {5.0};
                Object obj = c.newInstance(cArgs);
                Method m = circle.getDeclaredMethod("getPerimeter");
                double perimeter = (Double)m.invoke(obj);

                if (Math.abs(perimeter- 31.415927) > .000000001)
                    fail("getPerimeter of Circle is not working properly.");

                m = circle.getDeclaredMethod("getArea");
                double area = (Double)m.invoke(obj);

                if (Math.abs(area- 78.5398) > .0001)
                    fail("getArea of Circle is not working properly.");

            }
        }
        catch (Exception e)
        {
            fail(e.toString());
        }
    }

    @Test
    public  void testGetShapes() {
        try {

            Class<?> main = Class.forName("Main");

            Method m = main.getDeclaredMethod("getShapes");
            Object shapes = m.invoke(null);

            if (shapes.getClass().isArray()) {
                int length = Array.getLength(shapes);
                if (length != 3) 
                    fail("getShapes did not return 3 objects");
                else {
                    for (int i = 0; i < length; i ++) {
                        Object arrayElement = Array.get(shapes, i);
                        String name = arrayElement.getClass().toString();
                        if (!name.contains("Triangle") && !name.contains("Rectangle") && !name.contains("Circle"))
                            fail("getShapes did not return a Triangle, Rectangle and Circle.");
                    }
                }
            } else {
                fail("getShapes does not return an array");
            }
        }
        catch (Exception e)
        {
            fail(e.toString());
        }
    }
}
