package cn.liupu.dsa.introduction.object_generic;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/6/27 10:43 PM
 **/
public class WrapperDemo {

    public static void main(String[] args) {

        MemoryCell m = new MemoryCell();

        m.write(new Integer(37));

        Integer wrapperVal = (Integer) m.read();
        int val = wrapperVal.intValue();
        System.out.println("Contents are: " + val);
    }
}
