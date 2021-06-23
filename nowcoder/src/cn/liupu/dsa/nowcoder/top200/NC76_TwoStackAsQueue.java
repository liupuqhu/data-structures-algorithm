package cn.liupu.dsa.nowcoder.top200;

import java.util.Stack;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/22 1:56 下午
 **/
public class NC76_TwoStackAsQueue {

    public static void main(String[] args) {

        NC76_TwoStackAsQueue demo = new NC76_TwoStackAsQueue();
        demo.push(1);
        demo.push(2);
        demo.push(3);
        System.out.println(demo.pop());
        demo.push(4);
        demo.push(5);
        System.out.println(demo.pop());
        System.out.println(demo.pop());
        System.out.println(demo.pop());
        System.out.println(demo.pop());
        System.out.println(demo.pop());
    }


    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
           stack2.push(stack1.pop());
        }
        return stack2.pop();
    }


}
