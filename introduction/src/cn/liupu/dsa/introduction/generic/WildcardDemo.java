package cn.liupu.dsa.introduction.generic;

import java.util.Arrays;
import java.util.Collection;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/6/27 11:16 PM
 **/
public class WildcardDemo {

    public static void main(String[] args) {
        Shape[] shArr = {
                new Circle(2.0),
                new Square(3.0),
                new Rectangle(3.0, 4.0)
        };

        System.out.println(totalArea(shArr));

        Collection<Shape> shCollec = Arrays.asList(
                new Circle(2.0),
                new Square(3.0),
                new Rectangle(3.0, 4.0)
        );
        System.out.println(totalArea(shCollec));
    }

    public static double totalArea(Shape[] arr) {
        double total = 0;

        for (Shape s : arr) {
            if (s != null) {
                total += s.area();
            }
        }

        return total;
    }

    public static double totalArea(Collection<? extends Shape> collec) {
        double total = 0;

        for (Shape s : collec) {
            if (s != null) {
                total += s.area();
            }
        }

        return total;
    }
}


class Shape implements Comparable {

    @Override
    public int compareTo(Object o) {
        Shape other = (Shape) o;
        return this.area() < other.area() ? -1 : this.area() == other.area() ? 0 : 1;
    }

    public double area() {
        return 0;
    }

}

class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

}

class Square extends Shape {

    private double length;

    public Square(double length) {
        this.length = length;
    }

    @Override
    public double area() {
        return this.length * this.length;
    }
}


class Rectangle extends Shape {

    private double length;

    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return this.length * this.width;
    }
}
