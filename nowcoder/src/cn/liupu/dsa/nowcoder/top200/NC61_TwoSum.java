package cn.liupu.dsa.nowcoder.top200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/20 11:22 下午
 **/
public class NC61_TwoSum {

    public static void main(String[] args) {

        NC61_TwoSum demo = new NC61_TwoSum();
        int[] numbers = new int[]{20, 70, 110, 150};
        int target = 90;

        System.out.println(Arrays.toString(demo.twoSum(numbers, target)));

    }


    /**
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int tmp = numbers[i];
            if (map.containsKey(target - tmp)) {
                return new int[]{map.get(target - tmp) + 1, i + 1};
            }
            map.put(tmp, i);
        }
        throw new IllegalArgumentException("输入参数有误,无解");
    }
}
