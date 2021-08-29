package cn.liupu.dsa.nowcoder.top200;

import java.util.Arrays;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/8/29 1:45 下午
 **/
public class NC86_FindElementInMatrix {

    public static void main(String[] args) {

        NC86_FindElementInMatrix demo = new NC86_FindElementInMatrix();

        int[][] matrix = new int[][]{new int[]{1, 2, 5, 9}, new int[]{3, 6, 7, 11}, new int[]{4, 8, 10, 12}};

        int[] element = demo.findElement(matrix, 3, 4, 6);
        System.out.println(Arrays.toString(element));
    }


    public int[] findElement(int[][] mat, int n, int m, int x) {
        // write code here
        int[] result = new int[]{-1, -1};
        if (n == 0 || m == 0) {
            return result;
        }
        for (int i = n - 1, j = 0; i >= 0 && j < m; ) {
            if (mat[i][j] == x) {
                return new int[]{i, j};
            } else if (mat[i][j] > x) {
                i--;
            } else {
                j++;
            }
        }
        return result;
    }


}
