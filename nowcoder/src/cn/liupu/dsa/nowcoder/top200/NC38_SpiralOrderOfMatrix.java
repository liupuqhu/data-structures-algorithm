package cn.liupu.dsa.nowcoder.top200;

import java.util.Arrays;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/26 4:28 下午
 **/
public class NC38_SpiralOrderOfMatrix {

    public static void main(String[] args) {
        NC38_SpiralOrderOfMatrix demo = new NC38_SpiralOrderOfMatrix();

//        int[][] matrix = new int[5][5];
//        matrix[0] = new int[]{1, 2, 3, 4, 5};
//        matrix[1] = new int[]{6, 7, 8, 9, 10};
//        matrix[2] = new int[]{11, 12, 13, 14, 15};
//        matrix[3] = new int[]{16, 17, 18, 19, 20};
//        matrix[4] = new int[]{21, 22, 23, 24, 25};
//
        int m = 5;
        int n = 5;
        int num = 1;
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = num++;
            }
        }


        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        int[] list = demo.spiralOrder(matrix);
        System.out.println(Arrays.toString(list));
    }

    public int[] spiralOrder(int[][] matrix) {


        int row = 0;
        int col = 0;

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int[] arr = new int[rowLen * colLen];
        int count = 0;

        int mode = 1;

        arr[count++] = matrix[0][0];

        while (count < rowLen * colLen) {
            switch (mode) {
                case 1:
                    for (; col < colLen - row - 1; ) {
                        arr[count++] = matrix[row][++col];
                    }
                    mode = 2;
                    break;
                case 2:
                    for (; row < rowLen - (colLen - col); ) {
                        arr[count++] = matrix[++row][col];
                    }
                    mode = 3;
                    break;
                case 3:
                    for (; col > rowLen - 1 - row; ) {
                        arr[count++] = matrix[row][--col];
                    }
                    mode = 4;
                    break;
                case 4:
                    for (; row > col + 1; ) {
                        arr[count++] = matrix[--row][col];
                    }
                    mode = 1;
                    break;
            }
        }

        return arr;
    }
}
