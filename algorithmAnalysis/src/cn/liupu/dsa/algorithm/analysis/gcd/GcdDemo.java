package cn.liupu.dsa.algorithm.analysis.gcd;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/7/6 10:53 PM
 **/
public class GcdDemo {

    public static void main(String[] args) {

        long res = gcd(24, 200);
        System.out.println(res);


    }

    public static long gcd(long m, long n) {

        while (n != 0) {
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }
}
