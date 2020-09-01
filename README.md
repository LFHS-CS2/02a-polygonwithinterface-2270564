[![Work in Repl.it](https://classroom.github.com/assets/work-in-replit-14baed9a392b3a25080506f3b7b6d57f295ec2978f6f33ec97e36a161684cbe9.svg)](https://classroom.github.com/online_ide?assignment_repo_id=3049719&assignment_repo_type=AssignmentRepo)
Polygon, Triangle and Rectangle are variations of the classes you wrote last year in the Polygon Lab.  
This time, all the sides are doubles, not integers.  Also, the sides are not kept in ascending order, just in the order that they were added.
Remember that when comparing doubles, you cannot just use ```num1 == num``` since there is roundoff error.  
Instead, you have to use: ```Math.abs(num1 - num2) < .000001``` (or whatever your tolerance is for how close they should be).

1. In Rectangle and Triangle, where the methods ```getSide(0)```, ```getSide(1)``` and ```getSide(2)``` are called, replace them with ```sides.get(0)```,  ```sides.get(1)``` and ```sides.get(2)``` respectively.  Try to "run" the code now.  It won't compile showing that a child class cannot access a private variable in its parent class as we saw many times last year.
  
2. In the Polygon class, change:

        private ArrayList<Double> sides;

    to

        protected ArrayList<Double> sides;

    Now everything should compile since protected variables give access to all child classes.

3.  Create a file called Shape2D.java with an interface Shape2D that has the following methods:

        double getArea();

        double getPerimeter();


4.  To this interface, add a constant called PI that equals 3.1415927.

5.  Change Polygon so that it implements the Shape2D interface.  Hit the "run" button and see that it no longer compiles.  

6.  Since we are not going to be able to write ```getArea()``` for Polygon, make it an abstract class so it will compile.  Since Triangle and Rectangle have the ```getArea``` method, they should be fine and are now officially implementing the Shape2D interface because their parent does.

7.  Create a Circle class in Circle.java with a ``double radius`` instance variable and a constructor that takes a parameter to set this radius.

8.  Have the Circle class implement the Shape2D interface. Hit the "run" button and see that the Circle will not compile.  

9.  Fix it so that Circle will compile by implementing the Shape2D interface successfully.

10.  In the  Main.java file, write a method:

        ```public static Shape2D[] getShapes()```

that creates a triangle, rectangle, and circle and puts them in the a newly created array.

11.  Try to create a Shape2D object to see if you can also add it to the array.   Were you successful?

12.  I hope not. Because you cannot instantiate an interface as an object.  They do not have constructors!  But in ```getShapes()``` we were able to return an array of interfaces. That's okay because the array list just contains pointers to objects that were previously created.  If that doesn't make sense, ask somebody!
    
