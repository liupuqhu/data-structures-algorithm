package cn.liupu.dsa.nowcoder.top200;

import java.util.Arrays;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/26 2:02 下午
 **/
public class NC22_MergeTwoSortedArray {

    public static void main(String[] args) {
        NC22_MergeTwoSortedArray demo = new NC22_MergeTwoSortedArray();
        int[] a = new int[]{1, 2, 3, 0, 0, 0};
        int[] b = new int[]{2, 5, 6};
        System.out.println(Arrays.toString(a));
        demo.merge(a, 3, b, 3);
        System.out.println(Arrays.toString(a));
    }

    public void merge(int[] A, int m, int[] B, int n) {
        int start = 0;

        for (int j = 0; j < n; j++) {
            while (B[j] > A[start] && start < m + j) {
                start++;
            }
            int end = m + j;
            for (int i = end; i > start; i--) {
                A[i] = A[i - 1];
            }
            A[start] = B[j];
        }
    }
}
