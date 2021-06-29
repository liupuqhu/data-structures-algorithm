package cn.liupu.dsa.nowcoder.top200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/28 1:55 下午
 **/
public class NC54_ThreeSumOfArray {

    public static void main(String[] args) {

        NC54_ThreeSumOfArray demo = new NC54_ThreeSumOfArray();

        int[] num = new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        System.out.println(Arrays.toString(num));
        demo.quickSortArray(num);
        System.out.println(Arrays.toString(num));

        ArrayList<ArrayList<Integer>> list = demo.threeSum2(num);

        System.out.println();
    }


    public ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        if (num == null || num.length < 3) return resultList;

        Arrays.sort(num);

        for (int i = 0; i < num.length - 2; i++) {
            if (num[i] > 0) break;
            if (i > 0 && num[i] == num[i - 1]) continue;
            int left = i + 1;
            int right = num.length - 1;

            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    ArrayList<Integer> result = new ArrayList<>();
                    result.add(num[i]);
                    result.add(num[left]);
                    result.add(num[right]);
                    resultList.add(result);
                    while (left < right && num[left + 1] == num[left]) {
                        left++;
                    }
                    while (left < right && num[right - 1] == num[right]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }

        return resultList;
    }


    private void quickSortArray(int[] num) {
        quickSortArray(num, 0, num.length - 1);
    }

    private void quickSortArray(int[] num, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partation(num, left, right);
        quickSortArray(num, left, p - 1);
        quickSortArray(num, p + 1, right);
    }

    private int partation(int[] num, int left, int right) {
        int j = left;
        int pivot = num[right];
        for (int i = left; i < right; i++) {
            if (num[i] < pivot) {
                if (i > j) {
                    int tmp = num[i];
                    num[i] = num[j];
                    num[j] = tmp;
                }
                j++;
            }
        }

        int tmp = num[j];
        num[j] = pivot;
        num[right] = tmp;

        return j;
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        Set<String> set = new HashSet<>();

        if (num == null || num.length < 3) {
            return resultList;
        }

        for (int i = 0; i < num.length - 2; i++) {
            for (int j = i + 1; j < num.length - 1; j++) {
                for (int k = j + 1; k < num.length; k++) {
                    int sum = num[i] + num[j] + num[k];
                    if (sum > 0) {
                        break;
                    }
                    if (sum == 0) {
                        String key = num[i] + "," + num[j] + "," + num[k];
                        if (set.contains(key)) {
                            continue;
                        }
                        set.add(key);

                        ArrayList<Integer> result = new ArrayList<>(3);
                        result.add(num[i]);
                        result.add(num[j]);
                        result.add(num[k]);
                        resultList.add(result);
                    }
                }
            }
        }
        return resultList;
    }
}
