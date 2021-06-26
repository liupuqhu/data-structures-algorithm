package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/26 4:21 下午
 **/
public class NC103_ReverseString {

    public static void main(String[] args) {

        NC103_ReverseString demo = new NC103_ReverseString();


        System.out.println(demo.solve("abcd"));
        System.out.println(demo.solve("abcde"));
    }

    public String solve(String str) {
        // write code here
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[len - 1 - i];
            chars[len - 1 - i] = tmp;
        }
        return String.valueOf(chars);
    }
}
