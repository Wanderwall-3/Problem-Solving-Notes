package Binary_Search_Tree; //Completed it have "find" and "insert" methods

import java.util.*;

public class Binary_Search_Tree {

    class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    Node root;

    public Binary_Search_Tree(int key) {
        root = new Node(key);
    }

    public Binary_Search_Tree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    public Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        // System.out.println(root.key);
        return root;
    }

    public Node find(int key) {
        return findRec(root, key);
    }

    public Node findRec(Node root, int key) {
        if (root.key == key)
            return root;
        if (root.left != null && root.key > key)
            return findRec(root.left, key);
        else if (root.right != null && root.key < key)
            return findRec(root.right, key);
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Binary_Search_Tree bst = new Binary_Search_Tree();

        String input = sc.nextLine();
        String[] inputs = input.split(" ");
        for (String value : inputs) {
            int val = Integer.parseInt(value);
            bst.insert(val);
        }

        // System.out.println(bst.root);
        int find = sc.nextInt();
        Node ans = bst.find(find);
        if (ans.right != null)
            System.out.println(ans.right.key);
        if (ans.left != null)
            System.out.println(ans.left.key);

        sc.close();
    }
}