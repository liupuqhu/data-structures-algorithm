package cn.liupu.dsa.nowcoder.top200;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/20 12:34 下午
 *
 * 参考文章：
 * [java实现最大堆](https://blog.csdn.net/qq_37044026/article/details/86714130)
 * [最大堆的构建过程](https://blog.csdn.net/qq_42199781/article/details/97134570)
 **/
public class NC119_KSmallestNums {

    public static void main(String[] args) {

        int[] nums = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;

        NC119_KSmallestNums demo = new NC119_KSmallestNums();
        ArrayList<Integer> result = demo.GetLeastNumbers_Solution(nums, k);
        System.out.println(result);

    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length == 0 || k == 0 || k > input.length) {
            return result;
        }

        int[] leastNums = new int[k];
        for (int i = 0; i < k; i++) {
            leastNums[i] = input[i];
        }
        heapify(leastNums);

        for (int i = k; i < input.length; i++) {
            if (input[i] < leastNums[0]) {
                leastNums[0] = input[i];
                shiftDown(leastNums, 0);
            }
        }

        for (int num : leastNums) {
            result.add(num);
        }

        return result;
    }

    private void heapify(int[] arr) {
        for (int i = parentIndex(arr.length - 1); i >= 0; i--) {
            shiftDown(arr, i);
        }
    }

    private void shiftUp(int[] arr,int index){
        while(index > 0 && arr[index] > arr[parentIndex(index)]){
            swap(arr,index,parentIndex(index));
            index = parentIndex(index);
        }
    }

    private void shiftDown(int[] arr, int index) {
        while (leftChildIndex(index) < arr.length) {
            int j = leftChildIndex(index);
            if (rightChildIndex(index) < arr.length && arr[rightChildIndex(index)] > arr[leftChildIndex(index)]) {
                j = rightChildIndex(index);
            }

            if (arr[index] >= arr[j]) {
                break;
            }

            swap(arr, index, j);
            index = j;
        }
    }


    private int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int leftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int rightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
