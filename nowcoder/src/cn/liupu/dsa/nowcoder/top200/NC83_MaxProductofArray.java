package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/8/3 11:31 下午
 **/
public class NC83_MaxProductofArray {

    public static void main(String[] args) {

        NC83_MaxProductofArray demo = new NC83_MaxProductofArray();

        double[] arr = new double[]{5.0,-0.5,-4.0};
        double result = demo.maxProduct(arr);
        System.out.println(result);
    }


    public double maxProduct(double[] arr) {

        double[] maxArr = new double[arr.length];
        double[] minArr = new double[arr.length];

        maxArr[0] = arr[0];
        minArr[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 0) {
                maxArr[i] = Math.max(arr[i], arr[i] * maxArr[i - 1]);
                minArr[i] = Math.min(arr[i], arr[i] * minArr[i - 1]);
            } else {
                maxArr[i] = Math.max(arr[i], arr[i] * minArr[i - 1]);
                minArr[i] = Math.min(arr[i], arr[i] * maxArr[i - 1]);
            }
        }

        double max = maxArr[0];
        for (int i = 1; i < maxArr.length; i++) {
            if (maxArr[i] > max) {
                max = maxArr[i];
            }
        }

        return max;
    }
}
