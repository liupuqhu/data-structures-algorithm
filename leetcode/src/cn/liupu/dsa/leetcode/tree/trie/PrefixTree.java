package cn.liupu.dsa.leetcode.tree.trie;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/9/1 9:26 AM
 * 208 实现trie树
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 **/
public class PrefixTree {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));


        System.out.println("=====================");

        trie.insert("app");
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));


    }

}

class Trie {

    private class Node {
        Node[] child = new Node[26];
        boolean isleaf;
    }

    private Node root = new Node();


    public Trie() {

    }


    public void insert(String word) {
        insert(word, root);
    }

    public void insert(String word, Node node) {
        if (node == null) return;
        if (word.length() == 0) {
            node.isleaf = true;
            return;
        }
        int index = indexForChar(word.charAt(0));
        if (node.child[index] == null) {
            node.child[index] = new Node();
        }
        insert(word.substring(1), node.child[index]);
    }

    private int indexForChar(char c) {
        return c - 'a';
    }


    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, Node node) {
        if (node == null) return false;
        if (word.length() == 0) return node.isleaf;
        int index = indexForChar(word.charAt(0));
        return search(word.substring(1), node.child[index]);
    }

    public boolean startsWith(String prefix) {
        return startsWith(prefix, root);
    }

    private boolean startsWith(String prefix, Node node) {
        if (node == null) return false;
        if (prefix.length() == 0) return true;
        int index = indexForChar(prefix.charAt(0));
        return startsWith(prefix.substring(1), node.child[index]);
    }
}
