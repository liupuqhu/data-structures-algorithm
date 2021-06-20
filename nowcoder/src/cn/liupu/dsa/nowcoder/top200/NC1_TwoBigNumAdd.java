package cn.liupu.dsa.nowcoder.top200;

import java.util.Arrays;
import java.util.Stack;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/20 3:20 下午
 **/
public class NC1_TwoBigNumAdd {

    public static void main(String[] args) {

        NC1_TwoBigNumAdd demo = new NC1_TwoBigNumAdd();
        String result = demo.solve2("9", "99999999999999999999999999999999999999999999999999999999999994");
        System.out.println(result);
    }


    public String solve2(String s, String t) {
        Stack<Integer> stack = new Stack<>();
        int i = s.length() - 1;
        int j = t.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0){
            carry += (i >= 0) ? (s.charAt(i--) - '0') : 0;
            carry += (j >= 0) ? (t.charAt(j--) - '0') : 0;
            stack.push(carry % 10);
            carry = carry / 10;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int minLen = ch1.length < ch2.length ? ch1.length : ch2.length;

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= minLen; i++) {
            int add = (ch1[ch1.length - i] - '0') + (ch2[ch2.length - i] - '0') + carry;
            int num = add % 10;
            carry = add / 10;
            sb.append(num);
        }

        char[] remainCh = new char[0];
        if (ch1.length > minLen) {
            remainCh = Arrays.copyOfRange(ch1, 0 , ch1.length - minLen);
        } else if (ch2.length > minLen) {
            remainCh = Arrays.copyOfRange(ch2, 0 , ch2.length - minLen );
        }

        if (remainCh.length > 0) {
            for (int i = remainCh.length-1; i >= 0; i--) {
                int add = (remainCh[i] - '0') + carry;
                int num = add % 10;
                carry = add / 10;
                sb.append(num);
            }
        }

        if(carry > 0){
            sb.append(carry);
        }

        return sb.reverse().toString();
    }


}
