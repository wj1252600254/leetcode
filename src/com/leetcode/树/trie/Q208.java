package com.leetcode.树.trie;

public class Q208 {
    public static void main(String[] args) {
        int[] a = new int[10];
        a[9] = 100;
        for (int t : a) {
            System.out.println(t);
        }
    }

    class Trie {
        class Node {
            Node[] clilds = new Node[26];
            boolean isLeaf;
        }

        Node root = new Node();

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            insert(word, root);
        }

        private int indexForChar(char c) {
            return c - 'a';
        }

        public void insert(String word, Node node) {
            if (node == null) {
                return;
            }
            //说明是叶子节点，也就是说单词的结尾
            if (word.length() == 0) {
                node.isLeaf = true;
                return;
            }
            int index = indexForChar(word.charAt(0));
            if (node.clilds[index] == null) {
                node.clilds[index] = new Node();
            }
            insert(word.substring(1), node.clilds[index]);
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            return search(word, root);
        }

        public boolean search(String word, Node node) {
            if (node == null) {
                return false;
            }
            if (word.length() == 0) {
                return node.isLeaf;
            }
            int index = indexForChar(word.charAt(0));
            return search(word.substring(1), node.clilds[index]);
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return startsWith(prefix, root);
        }

        public boolean startsWith(String prefix, Node node) {
            if (node == null) {
                return false;
            }
            if (prefix.length() == 0) {
                return true;
            }
            int index = indexForChar(prefix.charAt(0));
            return startsWith(prefix.substring(1), node.clilds[index]);
        }
    }
}
