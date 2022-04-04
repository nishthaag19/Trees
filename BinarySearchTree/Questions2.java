package BinarySearchTree;

import java.util.Scanner;

class BSNode {
    int data;
    BSNode left;
    BSNode  right;
    public BSNode(){

    }
    public BSNode(int data){
        this.data=data;
    }
}
public class Questions2 {
     static BSNode root;
    static BSNode p= new BSNode();
    static BSNode suc= new BSNode();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Questions2 ob= new Questions2();
        root= new BSNode(s.nextInt());
        root.left= new BSNode(s.nextInt());
        root.right= new BSNode(s.nextInt());
        root.left.left= new BSNode(s.nextInt());
        root.left.right= new BSNode(s.nextInt());
        root.right.left= new BSNode(s.nextInt());
        root.right.right= new BSNode(s.nextInt());
        System.out.println("enter data");
        int n=s.nextInt();
        ob.find(root,n);
        System.out.println("predecessor is"+ p.data);
        System.out.println("successor is"+ suc.data);

    }

    //find inorder predecessor and inorder successor
    void find(BSNode root,int data){

        if(root==null)
            return;
        if(root.data==data){
            if(root.left!=null){
                BSNode curr=root.left;
                while(curr.right!=null){
                    curr=curr.right;
                }
                p=curr;
            }

            if(root.right!=null){
                BSNode curr=root.right;
                while(curr.left!=null){
                    curr=curr.left;
                }
                suc=curr;
            }
            return;
        }

        if(root.data>data){
            suc=root;
            find(root.left,data);
        }
        else{
            p=root;
            find(root.right,data);
        }

    }

}
