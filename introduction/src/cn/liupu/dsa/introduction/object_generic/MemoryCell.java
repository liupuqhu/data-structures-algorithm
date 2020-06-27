package cn.liupu.dsa.introduction.object_generic;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/6/27 10:38 PM
 **/
public class MemoryCell {

    private Object storedValue;

    public Object read() {
        return storedValue;
    }

    public void write(Object x) {
        storedValue = x;
    }
}
