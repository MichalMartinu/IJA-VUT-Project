package tests;

import org.junit.Assert;

import java.util.SortedMap;
import java.util.TreeMap;
import org.junit.Test;

import square.operations.*;
import rectangle.operations.*;
import triangle.operations.*;

public class Homework2Tests {


    @Test
    public void squareArea()
    {
        SortedMap<String, Double> square = new TreeMap<>();
        square.put("a", 3.2);
        SquareArea area = new SquareArea(square);
        area.execute();
        SortedMap<String, Double> result = area.objectActualValue();
        Assert.assertEquals((Double) 10.24, (Double)result.get("result"));
    }

    @Test
    public void squareCircumference()
    {
        SortedMap<String, Double> square = new TreeMap<>();
        square.put("a", 3.2);
        SquareCircumference circumference = new SquareCircumference(square);
        circumference.execute();
        SortedMap<String, Double> result = circumference.objectActualValue();
        Assert.assertEquals((Double) 12.8, result.get("result"));
    }

    @Test
    public void squareHeight()
    {
        SortedMap<String, Double> square = new TreeMap<>();
        square.put("a", 3.2);
        SquareHeight height = new SquareHeight (square);
        height.execute();
        SortedMap<String, Double> result = height.objectActualValue();
        Assert.assertEquals((Double) 3.2, result.get("result"));
    }

    @Test
    public void squareScale()
    {
        SortedMap<String, Double> square = new TreeMap<>();
        square.put("a", 3.2);
        SquareScale scale = new SquareScale (square, 3.0);
        scale.execute();
        SortedMap<String, Double> result = scale.objectActualValue();
        Assert.assertEquals((Double) 9.6, result.get("a"));
    }

    @Test
    public void squareDiagonal()
    {
        SortedMap<String, Double> square = new TreeMap<>();
        square.put("a", 3.2);
        SquareDiagonal diagonal = new SquareDiagonal (square);
        diagonal.execute();
        SortedMap<String, Double> result = diagonal.objectActualValue();
        Assert.assertEquals((Double) 4.525483, result.get("result"));
    }

    @Test
    public void rectangleArea()
    {
        SortedMap<String, Double> rectangle = new TreeMap<>();
        rectangle.put("a", 3.2);
        rectangle.put("b", 5.1);
        RectangleArea area = new RectangleArea(rectangle);
        area.execute();
        SortedMap<String, Double> result = area.objectActualValue();
        Assert.assertEquals((Double) 16.32, result.get("result"));
    }

    @Test
    public void rectangleCircumference()
    {
        SortedMap<String, Double> rectangle = new TreeMap<>();
        rectangle.put("a", 3.2);
        rectangle.put("b", 5.1);
        RectangleCircumference circumference = new RectangleCircumference(rectangle);
        circumference.execute();
        SortedMap<String, Double> result = circumference.objectActualValue();
        Assert.assertEquals((Double) 16.6, result.get("result"));
    }

    @Test
    public void rectangleDiagonal()
    {
        SortedMap<String, Double> rectangle = new TreeMap<>();
        rectangle.put("a", 3.2);
        rectangle.put("b", 5.1);
        RectangleDiagonal circumference = new RectangleDiagonal(rectangle);
        circumference.execute();
        SortedMap<String, Double> result = circumference.objectActualValue();
        Assert.assertEquals((Double) 6.020797, result.get("result"));
    }

    @Test
    public void rectangleHeight()
    {
        SortedMap<String, Double> rectangle = new TreeMap<>();
        rectangle.put("a", 3.2);
        rectangle.put("b", 5.1);
        RectangleHeight circumference = new RectangleHeight(rectangle);
        circumference.execute();
        SortedMap<String, Double> result = circumference.objectActualValue();
        Assert.assertEquals((Double) 5.1, result.get("result"));
    }

    @Test
    public void rectangleScale()
    {
        SortedMap<String, Double> rectangle = new TreeMap<>();
        rectangle.put("a", 3.2);
        rectangle.put("b", 5.1);
        RectangleScale circumference = new RectangleScale(rectangle, 2);
        circumference.execute();
        SortedMap<String, Double> result = circumference.objectActualValue();
        Assert.assertEquals((Double) 6.4, result.get("a"));
        Assert.assertEquals((Double) 10.2, result.get("b"));
    }

    @Test
    public void triangleCheckValid()
    {
        SortedMap<String, Double> triangle = new TreeMap<>();
        triangle.put("a", 7.0);
        triangle.put("b", 10.0);
        triangle.put("c", 5.0);

        TriangleArea triangleCheck = new TriangleArea (triangle);
    }

    @Test(expected = IllegalArgumentException.class)
    public void triangleCheckInvalid()
    {
        SortedMap<String, Double> triangle = new TreeMap<>();
        triangle.put("a", 1.0);
        triangle.put("b", 2.0);
        triangle.put("c", 3.0);

        TriangleArea triangleCheck = new TriangleArea (triangle);
    }

    @Test
    public void triangleArea()
    {
        SortedMap<String, Double> triangle = new TreeMap<>();
        triangle.put("a", 7.0);
        triangle.put("b", 10.0);
        triangle.put("c", 5.0);

        TriangleArea area = new TriangleArea (triangle);
        area.execute();
        SortedMap<String, Double> result = area.objectActualValue();
        Assert.assertEquals((Double) 16.248077, result.get("result"));
    }

    @Test
    public void triangleCircumference()
    {
        SortedMap<String, Double> triangle = new TreeMap<>();
        triangle.put("a", 7.0);
        triangle.put("b", 10.0);
        triangle.put("c", 5.0);

        TriangleCircumference circumference = new TriangleCircumference(triangle);
        circumference.execute();
        SortedMap<String, Double> result = circumference.objectActualValue();
        Assert.assertEquals((Double) 22.0, result.get("result"));
    }

    @Test
    public void triangleScale()
    {
        SortedMap<String, Double> triangle = new TreeMap<>();
        triangle.put("a", 7.0);
        triangle.put("b", 10.0);
        triangle.put("c", 5.0);

        TriangleScale scale = new TriangleScale(triangle, 2);
        scale.execute();
        SortedMap<String, Double> result = scale.objectActualValue();
        Assert.assertEquals((Double) 14.0, result.get("a"));
        Assert.assertEquals((Double) 20.0, result.get("b"));
        Assert.assertEquals((Double) 10.0, result.get("c"));
    }

    @Test
    public void triangleGetAngleAlpha()
    {
        SortedMap<String, Double> triangle = new TreeMap<>();
        triangle.put("a", 7.0);
        triangle.put("b", 10.0);
        triangle.put("c", 5.0);

        TriangleGetAngle angle = new TriangleGetAngle(triangle, "alpha");
        angle.execute();
        SortedMap<String, Double> result = angle.objectActualValue();
        Assert.assertEquals((Double) 0.707483, result.get("result"));
    }

    @Test
    public void triangleGetAngleBeta()
    {
        SortedMap<String, Double> triangle = new TreeMap<>();
        triangle.put("a", 7.0);
        triangle.put("b", 10.0);
        triangle.put("c", 5.0);

        TriangleGetAngle angle = new TriangleGetAngle(triangle, "beta");
        angle.execute();
        SortedMap<String, Double> result = angle.objectActualValue();
        Assert.assertEquals((Double) 0.482766, result.get("result"));
    }
    @Test
    public void triangleGetAngleDelta()
    {
        SortedMap<String, Double> triangle = new TreeMap<>();
        triangle.put("a", 7.0);
        triangle.put("b", 10.0);
        triangle.put("c", 5.0);

        TriangleGetAngle angle = new TriangleGetAngle(triangle, "delta");
        angle.execute();
        SortedMap<String, Double> result = angle.objectActualValue();
        Assert.assertEquals((Double) 1.951344, result.get("result"));
    }

    @Test
    public void triangleHeight_A()
    {
        SortedMap<String, Double> triangle = new TreeMap<>();
        triangle.put("a", 7.3);
        triangle.put("b", 6.4);
        triangle.put("c", 10.2);

        TriangleHeight height = new TriangleHeight(triangle, "a");
        height.execute();
        SortedMap<String, Double> result = height.objectActualValue();
        Assert.assertEquals((Double) 6.364775, result.get("result"));
    }

    @Test
    public void triangleHeight_B()
    {
        SortedMap<String, Double> triangle = new TreeMap<>();
        triangle.put("a", 7.3);
        triangle.put("b", 6.4);
        triangle.put("c", 10.2);

        TriangleHeight height = new TriangleHeight(triangle, "b");
        height.execute();
        SortedMap<String, Double> result = height.objectActualValue();
        Assert.assertEquals((Double)  7.259822, result.get("result"));
    }

    @Test
    public void triangleHeight_C()
    {
        SortedMap<String, Double> triangle = new TreeMap<>();
        triangle.put("a", 7.3);
        triangle.put("b", 6.4);
        triangle.put("c", 10.2);

        TriangleHeight height = new TriangleHeight(triangle, "c");
        height.execute();
        SortedMap<String, Double> result = height.objectActualValue();
        Assert.assertEquals((Double) 4.555182, result.get("result"));
    }

    @Test
    public void triangleHeight_A2()
    {
        SortedMap<String, Double> triangle = new TreeMap<>();
        triangle.put("a", 7.0);
        triangle.put("b", 10.0);
        triangle.put("c", 5.0);

        TriangleHeight height = new TriangleHeight(triangle, "a");
        height.execute();
        SortedMap<String, Double> result = height.objectActualValue();
        Assert.assertEquals((Double) 4.642308, result.get("result"));
    }

    @Test
    public void triangleHeight_B2()
    {
        SortedMap<String, Double> triangle = new TreeMap<>();
        triangle.put("a", 7.0);
        triangle.put("b", 10.0);
        triangle.put("c", 5.0);

        TriangleHeight height = new TriangleHeight(triangle, "b");
        height.execute();
        SortedMap<String, Double> result = height.objectActualValue();
        Assert.assertEquals((Double) 3.249615, result.get("result"));
    }

    @Test
    public void triangleHeight_C2()
    {
        SortedMap<String, Double> triangle = new TreeMap<>();
        triangle.put("a", 7.0);
        triangle.put("b", 10.0);
        triangle.put("c", 5.0);

        TriangleHeight height = new TriangleHeight(triangle, "c");
        height.execute();
        SortedMap<String, Double> result = height.objectActualValue();
        Assert.assertEquals((Double) 6.499231, result.get("result"));
    }
}

