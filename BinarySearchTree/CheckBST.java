package BinarySearchTree;

import java.util.Scanner;
// check binary tree is binary search tree or not.
public class CheckBST {
  static BSTNode root;
    public boolean isBSTOrNot() {
        return isBSTOrNot(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTOrNot(BSTNode root, int minValue, int maxValue) {

        if (root == null)
            return true;

        // check for current node value with left node value and right node value and recursively check for left sub tree and right sub tree
        return(root.data >= minValue && root.data <= maxValue && isBSTOrNot(root.left, minValue, root.data) && isBSTOrNot(root.right, root.data, maxValue));

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        CheckBST ob= new CheckBST();
        ob.root= new BSTNode(s.nextInt());
        ob.root.left= new BSTNode(s.nextInt());
        ob.root.right= new BSTNode(s.nextInt());
        ob.root.left.left= new BSTNode(s.nextInt());
        ob.root.left.right= new BSTNode(s.nextInt());
        ob.root.right.left= new BSTNode(s.nextInt());
        ob.root.right.right= new BSTNode(s.nextInt());
        System.out.println(ob.isBSTOrNot());
    }

}
