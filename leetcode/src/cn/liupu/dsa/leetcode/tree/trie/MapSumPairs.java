package cn.liupu.dsa.leetcode.tree.trie;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/9/3 9:00 AM
 * 677 前缀求和
 * https://leetcode.com/problems/map-sum-pairs/
 **/
public class MapSumPairs {

    public static void main(String[] args) {

        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("apple", 5);
        System.out.println(mapSum.sum("ap"));
    }
}


class MapSum {

    class Node {
        Node[] childs = new Node[26];
        int value;
    }

    public MapSum() {

    }

    private Node root = new Node();

    public void insert(String key, int val) {
        insert(root, key, val);
    }

    public void insert(Node node, String key, int val) {
        if (key.length() == 0) {
            node.value = val;
            return;
        }
        int index = indexForChar(key.charAt(0));
        if (node.childs[index] == null) {
            node.childs[index] = new Node();
        }
        insert(node.childs[index], key.substring(1), val);
    }


    public int sum(String prefix) {
        return sum(root, prefix);
    }

    public int sum(Node node, String prefix) {
        if (node == null) return 0;
        if (prefix.length() != 0) {
            int index = indexForChar(prefix.charAt(0));
            return sum(node.childs[index], prefix.substring(1));
        }
        int sum = node.value;
        for (Node child : node.childs) {
            sum += sum(child, prefix);
        }
        return sum;
    }


    private int indexForChar(char c) {
        return c - 'a';
    }

}
//自己第一反应的写法（时间空间复杂度过高）
//class MapSum {
//
//    class Node {
//        Node[] childs = new Node[26];
//        boolean isLeaf;
//        int value;
//    }
//
//    private Node root = new Node();
//
//    public MapSum() {
//
//    }
//
//    public void insert(String key, int val) {
//        Integer oldValue = getKeyLeafValue(key);
//        if (oldValue != null) {
//            val -= oldValue;
//        }
//        insert(root, key, val);
//    }
//
//    public void insert(Node node, String key, int val) {
//        if (key.length() == 0) {
//            node.isLeaf = true;
//            node.value += val;
//            return;
//        }
//        node.value += val;
//        int index = indexForChar(key.charAt(0));
//        if (node.childs[index] == null) {
//            node.childs[index] = new Node();
//        }
//        insert(node.childs[index], key.substring(1), val);
//    }
//
//    public int sum(String prefix) {
//        Node node = root;
//        for (char c : prefix.toCharArray()) {
//            int index = indexForChar(c);
//            if (node.childs[index] == null) {
//                return 0;
//            }
//            node = node.childs[index];
//        }
//        if (node != null) return node.value;
//        return 0;
//    }
//
//    private Integer getKeyLeafValue(String key) {
//        Node node = root;
//        for (char c : key.toCharArray()) {
//            int index = indexForChar(c);
//            if (node.childs[index] == null) {
//                return null;
//            }
//            node = node.childs[index];
//        }
//        if (node != null && node.isLeaf) {
//            return node.value;
//        }
//        return null;
//    }
//
//
//    private int indexForChar(char c) {
//        return c - 'a';
//    }
//
//}