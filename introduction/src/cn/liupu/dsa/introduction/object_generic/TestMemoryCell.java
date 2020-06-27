package cn.liupu.dsa.introduction.object_generic;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/6/27 10:40 PM
 **/
public class TestMemoryCell {

    public static void main(String[] args) {

        MemoryCell m = new MemoryCell();

        m.write("37");

        String val = (String) m.read();
        System.out.println("Contents are: " + val);
    }
}
