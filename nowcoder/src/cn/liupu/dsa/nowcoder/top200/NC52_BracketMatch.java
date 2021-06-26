package cn.liupu.dsa.nowcoder.top200;

import java.util.Stack;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/26 2:47 下午
 **/
public class NC52_BracketMatch {

    public static void main(String[] args) {
        NC52_BracketMatch demo = new NC52_BracketMatch();
        System.out.println(demo.isValid("[]{[{}]}()"));

        System.out.println(demo.isValid('[', ']'));
    }

    public boolean isValid(String s) {
        // write code here
        Stack<Character> stack = new Stack();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
                continue;
            }
            Character peek = stack.peek();
            if (isValid(peek, chars[i])) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }

        return stack.isEmpty();
    }

    private boolean isValid(Character a, Character b) {
        switch (a) {
            case '(':
                return b.equals(')');
            case '[':
                return b.equals(']');
            case '{':
                return b.equals('}');
            default:
                return false;
        }
    }
}
