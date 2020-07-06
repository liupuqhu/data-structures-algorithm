package cn.liupu.dsa.algorithm.analysis.binarysearch;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/7/6 10:44 PM
 **/
public class BinarySearchDemo {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

        int res = binarySearch(arr, 4);
        System.out.println(res);

    }

    public static int binarySearch(int[] arr, int x) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (x > arr[mid]) {
                low = mid + 1;
            } else if (arr[mid] < x) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
