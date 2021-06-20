package cn.liupu.dsa.nowcoder.top200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/5 6:07 下午
 **/
public class NC93_LRUCache {


    public static void main(String[] args) {
        NC93_LRUCache cacheDemo = new NC93_LRUCache(3);
        int[][] operators = new int[][]{{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};

        int[] results = cacheDemo.lru(operators, 3);
        System.out.println(Arrays.toString(results));

    }

    private Map<Integer, Node> cache;

    private Node head;

    private Node tail;

    private int capacity;

    public NC93_LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int[] lru(int[][] operators, int k) {
        // write code here
        int size = (int) Arrays.stream(operators).filter(operator -> operator[0] == 2).count();
        int[] result = new int[size];
        for (int i = 0, j = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {
                set(operators[i][1], operators[i][2]);
            } else {
                result[j++] = get(operators[i][1]);
            }
        }
        return result;
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            moveToHead(node);
        } else {
            if (cache.size() == this.capacity) {
                int removeKey = tail.prev.key;
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
                cache.remove(removeKey);
            }
            Node node = new Node(key, value);
            cache.put(key,node);
            moveToHead(node);
        }
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.next.prev = node.prev;
            node.prev.next = node.next;
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    private void moveToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }


    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
