package cn.liupu.dsa.introduction.generic;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/6/27 11:12 PM
 **/
public class GenericMemoryCell<AnyType> {

    private AnyType storedValue;

    public AnyType read() {
        return storedValue;
    }

    public void write(AnyType storedValue) {
        this.storedValue = storedValue;
    }
}
