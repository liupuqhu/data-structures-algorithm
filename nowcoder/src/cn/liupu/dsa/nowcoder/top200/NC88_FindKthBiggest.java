package cn.liupu.dsa.nowcoder.top200;


/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/20 4:09 下午
 **/
public class NC88_FindKthBiggest {

    public static void main(String[] args) {

        int[] nums = new int[]{10, 10, 9, 8, 7, 5, 6, 4, 3, 4, 2};
        int n = 11;
        int k = 4;

        int index = n - k;

        int left = 0;
        int right = nums.length - 1;
        int partation = 0;
        while (partation != index) {
            partation = partation(nums, left, right);
            if (partation < index) {
                left = partation + 1;
                partation = partation(nums, left, right);
            } else if (partation > index) {
                right = partation - 1;
                partation = partation(nums, left, right);
            }
        }

        System.out.println(nums[index]);


    }

    private static int partation(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;

        for(int j = left; j < right; j++){
            if(arr[j] < pivot){
                if(i == j){
                    i++;
                }else{
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
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
