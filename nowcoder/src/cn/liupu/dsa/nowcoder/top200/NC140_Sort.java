package cn.liupu.dsa.nowcoder.top200;

import java.util.Arrays;

/**
 * @description: 数组排序
 * @author: liupu1
 * @create: 2021/6/5 3:59 下午
 * https://www.nowcoder.com/practice/2baf799ea0594abd974d37139de27896?tpId=117&&tqId=37851&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 **/
public class NC140_Sort {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 5, 3, 7, 9, 2};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(quickSort(arr)));
    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }

    public static int[] quickSort(int[] arr) {
        return quickSortInternal(arr, 0, arr.length - 1);
    }

    public static int[] quickSortInternal(int[] arr, int left, int right) {
        if (left >= right) {
            return arr;
        }

        int index = partation(arr, left, right);
        quickSortInternal(arr, left, index - 1);
        quickSortInternal(arr, index + 1, right);

        return arr;
    }


    public static int partation(int[] arr, int left, int right) {
        int pivot = arr[right];

        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i++;
                }
            }
        }

        int tmp = arr[right];
        arr[right] = arr[i];
        arr[i] = tmp;

        return i;
    }
}
