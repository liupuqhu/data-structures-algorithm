package cn.liupu.dsa.introduction.generic;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/6/27 11:13 PM
 **/
public class BoxingDemo {

    public static void main(String[] args) {

        GenericMemoryCell<Integer> m = new GenericMemoryCell<>();

        m.write(37);
        int val = m.read();
        System.out.println("Contents are: " + val);
    }
}
