package cn.liupu.dsa.introduction.object_generic;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/6/27 10:49 PM
 **/
public class FindMaxDemo {

    public static Comparable findMax(Comparable[] arr) {
        int maxIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(arr[maxIndex]) > 0) {
                maxIndex = i;
            }
        }

        return arr[maxIndex];
    }


    public static void main(String[] args) {

        Shape[] shl = {
                new Circle(2.0),
                new Square(3.0),
                new Rectangle(3.0, 4.0)
        };

        String[] stl = {"Joe", "Bob", "Bill", "Zeke"};

        System.out.println(findMax(shl));
        System.out.println(findMax(stl));

        //编译通过，运行时报错
        Shape[] arr = new Square[5];
        arr[0] = new Circle(1.0);

        System.out.println("协变数组类型 covariant array type");
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
