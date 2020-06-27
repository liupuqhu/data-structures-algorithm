package cn.liupu.dsa.introduction.generic;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/6/27 11:24 PM
 **/
public class TestGenericMemoryCell {

    public static void main(String[] args) {

//        test1();

        test2();
    }


    public static void test1() {
        GenericMemoryCell<Integer> cell1 = new GenericMemoryCell<>();
        cell1.write(4);
        Object cell = cell1;

        GenericMemoryCell<String> cell2 = (GenericMemoryCell<String>) cell;
        String s = cell2.read();

        System.out.println(s);
    }

    public static void test2() {
        GenericMemoryCell<String>[] arr1 = new GenericMemoryCell[10];
        GenericMemoryCell<Double> cell = new GenericMemoryCell<>();
        cell.write(4.5);
        Object[] arr2 = arr1;
        arr2[0] = cell;

        GenericMemoryCell<String>[] arr3 = (GenericMemoryCell<String>[]) arr2;

        String s = arr3[0].read();

        System.out.println(s);

    }

}
