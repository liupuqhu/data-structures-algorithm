package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/26 3:20 下午
 **/
public class NC41_MaxLengthSerialSubArray {

    public static void main(String[] args) {
        NC41_MaxLengthSerialSubArray demo = new NC41_MaxLengthSerialSubArray();

        int[] arr = new int[]{1, 2, 3, 1, 2, 3, 4, 2};

        System.out.println(demo.maxLength(arr));
    }

    public int maxLength(int[] arr) {
        // write code here
        int maxLen = 0;
        int start = 0;
        int end = 0;
        for (int i = start; i < arr.length; ) {
            boolean flag = false;
            for (int j = start; j < i; j++) {
                if (arr[j] == arr[i]) {
                    int len = end - start + 1;
                    if (len > maxLen) {
                        maxLen = len;
                    }
                    start = j + 1;
                    end = start;
                    i = start;
                    flag = true;
                }
            }

            if (!flag) {
                end = i;
                i++;
                int len = end - start + 1;
                if (len > maxLen) {
                    maxLen = len;
                }
            }

        }
        return maxLen;
    }
}
