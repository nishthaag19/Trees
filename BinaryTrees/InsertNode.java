package BinaryTree;

import java.util.Scanner;
// to insert nodes int the tree and preorder traverse it.
public class InsertNode {
    static Node root=null;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        InsertNode ob = new InsertNode();
        System.out.println("enter root data");
        Node root = new Node(s.nextInt());
        do
        {
            System.out.println("enter y or n for nodes");
        String x = s.next();
        if (x.charAt(0) == 'y') {
            System.out.println("enter l or r for nodes");
            String y = s.next();
            if (y.charAt(0) == 'l')
                root.left = ob.insert(root.left, s.nextInt());
            else if (y.charAt(0) == 'r')
                root.right = ob.insert(root.right, s.nextInt());
        }

        else if (x.charAt(0) == 'n') {
            break;
        }
            ob.preorder(root);
    }while(true);

    }
     Node insert(Node node,int data){
        if(node==null)
            return new Node(data);
        else{
            insert(root,data);
        }
        return node;
    }
    void preorder(Node root){
        if(root==null)
            return;
        System.out.print(root.data+"   ");
        preorder(root.left);
        preorder(root.right);
    }
}
