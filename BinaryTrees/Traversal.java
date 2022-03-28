package BinaryTree;

import java.util.Scanner;

// basic to print the nodes of binary tree
class Node{
    int data;
    Node left,right;
    public Node(int data){
        this.data=data;
    }
}
public class Traversal {
    static Node root=null;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Traversal t=new Traversal();

        t.root=new Node(s.nextInt());
        t.root.left=new Node(s.nextInt());
        t.root.right=new Node(s.nextInt());
        t.root.left.left=new Node(s.nextInt());
        t.root.left.right=new Node(s.nextInt());
        t.root.right.left=new Node(s.nextInt());
        t.root.right.right=new Node(s.nextInt());
        System.out.println("inorder :");
        t.inorder(root);
        System.out.println();
        System.out.println("preorder:");
        t.preorder(root);
        System.out.println();
        System.out.println("postorder:");
        t.postorder(root);
    }
    void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+"   ");
        inorder(root.right);
    }
    void preorder(Node root){
        if(root==null)
            return;
        System.out.print(root.data+"   ");
        preorder(root.left);
        preorder(root.right);
    }
    void postorder(Node root){
        if(root==null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+"    ");
    }
}
