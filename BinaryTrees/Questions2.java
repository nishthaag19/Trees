package BinaryTree;

import java.util.Scanner;

public class Questions2 {
   static  Node root=null;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Questions2 t = new Questions2();
        t.root = new Node(s.nextInt());
        t.root.left = new Node(s.nextInt());
        t.root.right = new Node(s.nextInt());
        t.root.left.left = new Node(s.nextInt());
        t.root.left.right = new Node(s.nextInt());
        t.root.right.left = new Node(s.nextInt());
        t.root.right.right = new Node(s.nextInt());
        t.levelorder();
        System.out.println("reverse");
        t.reverselevelorder();
        System.out.println(t.max(root));
        System.out.println(t.CSP(root));
        t.printKNodes(root, 2);
        System.out.println();
        Node head= t.convertDLL(root);
        t.print(head);
    }
    //level order traversal
    void levelorder(){
        int h=height(root);
        for (int i = 0; i < h; i++) {
            CurrentLevel(root,i);
            System.out.println();
        }
    }
   // find  height for traversal
    int height(Node root){
        if(root==null)
            return 0;
        else{
            int lh=height(root.left);
            int rh= height(root.right);
            return(Math.max(lh,rh)+1);
        }
    }
    //to print the data of traversal
    void CurrentLevel(Node root,int level){
        if (root == null)
            return;
        if (level == 0) {
            System.out.print(root.data + " ");
        }
        else if (level > 0) {
            CurrentLevel(root.left, level - 1);
            CurrentLevel(root.right, level - 1);
        }

    }
    //reverse level order traversal
    void reverselevelorder(){
        int h= height(root);
        for (int i = h; i>=0 ; i--) {
            CurrentLevel(root,i);
            System.out.println();
        }

    }
    //maximum data in the BT
    int  max(Node root){
        if(root==null)
            return Integer.MIN_VALUE;
        else
            return Math.max(root.data,Math.max(max(root.left),max(root.right)));
    }
    // check children sum property ie root=left+right data
    boolean CSP(Node root){
        if(root==null)
            return true;
        if(root.left==null&&root.right==null)
            return true;
        int sum=0;
        if(root.left!=null)
            sum+= root.left.data;
        if(root.right!=null)
            sum+= root.right.data;
        return (root.data==sum && CSP(root.left)&&CSP(root.right));
    }
    //print nodes at k level
    void printKNodes(Node root,int k){
        if(root==null)
            return;
        if(k==0)
            System.out.print(root.data+"   ");
        else{
            printKNodes(root.left,k-1);
            printKNodes(root.right,k-1);
        }
    }
    //convert binary tree to doubly linked list
    static Node pre=null;
    Node  convertDLL(Node root){
        if(root==null)
            return null;
        Node head=convertDLL(root.left);
        if(pre==null){
            head=root;
        }else{
            root.left=pre;
            pre.right=root;
        }
        pre=root;
        convertDLL(root.right);
        return head;
    }
    // to print nodes of doubly linked list.
    void print(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+"    ");
            curr=curr.right;
        }
    }

}
