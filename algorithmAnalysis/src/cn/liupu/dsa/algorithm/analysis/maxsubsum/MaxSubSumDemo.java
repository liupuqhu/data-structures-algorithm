package cn.liupu.dsa.algorithm.analysis.maxsubsum;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/7/6 9:49 PM
 **/
public class MaxSubSumDemo {

    public static void main(String[] args) {

        int[] array = new int[]{2, -4, 3, 5, -1, 7, -5, 4, -2, 6, 1};

        int sum1 = maxSubSum1(array);
        System.out.println(sum1);

        int sum2 = maxSubSum2(array);
        System.out.println(sum2);

        int sum3 = maxSubSum3(array);
        System.out.println(sum3);

        int sum4 = maxSubSum4(array);
        System.out.println(sum4);


    }

    //n^3
    public static int maxSubSum1(int[] arr) {

        int maxSum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {

                int thisSum = 0;

                for (int k = i; k <= j; k++) {
                    thisSum += arr[k];
                }

                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    //n^2
    public static int maxSubSum2(int[] arr) {
        int maxSum = 0;

        for (int i = 0; i < arr.length; i++) {

            int thisSum = 0;

            for (int j = i; j < arr.length; j++) {

                thisSum += arr[j];

                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }

        return maxSum;
    }


    //nlogn
    public static int maxSubSum3(int[] arr) {

        return maxSubRec(arr, 0, arr.length - 1);

    }

    private static int maxSubRec(int[] arr, int left, int right) {
        if (left == right) {
            if (arr[left] > 0) {
                return arr[left];
            } else {
                return 0;
            }
        }

        int center = (left + right) / 2;
        int maxLeftSum = maxSubRec(arr, left, center);
        int maxRightSum = maxSubRec(arr, center + 1, right);

        int maxLeftBorderSum = 0;
        int leftBorderSum = 0;

        for (int i = center; i >= left; i--) {
            leftBorderSum += arr[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0;
        int rightBorderSum = 0;

        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += arr[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }


        return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
    }

    private static int max3(int a, int b, int c) {
        return a > b ? ((a > c) ? a : c) : ((b > c) ? b : c);
    }


    //n
    public static int maxSubSum4(int[] arr) {
        int maxSum = 0;
        int thisSum = 0;

        for (int i = 0; i < arr.length; i++) {
            thisSum += arr[i];

            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }

        return maxSum;
    }

}
