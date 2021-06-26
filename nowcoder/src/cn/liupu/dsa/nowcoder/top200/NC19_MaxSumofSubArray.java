package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/26 11:44 上午
 **/
public class NC19_MaxSumofSubArray {

    public static void main(String[] args) {
        NC19_MaxSumofSubArray demo = new NC19_MaxSumofSubArray();
        int[] arr = new int[]{1, -2, 3, 5, -2, 6, -1};
        int i = demo.maxsumofSubarray(arr);
        System.out.println(i);
    }

    public int maxsumofSubarray(int[] arr) {
        // write code here
        int sum = 0;
        int tmp = 0;

        for (int i = 0; i < arr.length; i++) {
            tmp += arr[i];
            if (tmp < 0) {
                tmp = 0;
            }
            if (tmp > sum) {
                sum = tmp;
            }
        }
        return sum;
    }
}
