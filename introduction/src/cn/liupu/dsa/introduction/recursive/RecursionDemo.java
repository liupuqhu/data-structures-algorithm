package cn.liupu.dsa.introduction.recursive;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/6/27 10:27 PM
 **/
public class RecursionDemo {

    public static void main(String[] args) {
        int n = 12345;
        printOut(n);

    }

    public static void printOut(int n) {
        if (n >= 10) {
            printOut(n / 10);
        }
        printDigit(n % 10);
    }

    private static void printDigit(int i) {
        System.out.println(i);
    }
}
