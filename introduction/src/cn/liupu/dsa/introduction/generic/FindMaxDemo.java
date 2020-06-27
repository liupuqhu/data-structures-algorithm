package cn.liupu.dsa.introduction.generic;

import java.util.Comparator;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/6/27 10:49 PM
 **/
public class FindMaxDemo {

    public static <AnyType extends Comparable<? super AnyType>> AnyType findMax(AnyType[] arr) {
        int maxIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(arr[maxIndex]) > 0) {
                maxIndex = i;
            }
        }

        return arr[maxIndex];
    }


    public static <AnyType> AnyType findMax(AnyType[] arr, Comparator<? super AnyType> cmp) {
        int maxIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (cmp.compare(arr[i], arr[maxIndex]) > 0) {
                maxIndex = i;
            }
        }

        return arr[maxIndex];

    }


    public static void main(String[] args) {

        String[] stl = {"Joe", "Bob", "bill", "Zeke"};

        System.out.println(findMax(stl));

        System.out.println(findMax(stl, new CaseInsensitiveComparator()));

    }
}

class CaseInsensitiveComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);
    }
}

