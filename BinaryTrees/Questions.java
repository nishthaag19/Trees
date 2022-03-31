package BinaryTree;

import java.util.Scanner;

public class Questions {
    static Node root=null;
    public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
  Questions t= new Questions();
        t.root=new Node(s.nextInt());
        t.root.left=new Node(s.nextInt());
        t.root.right=new Node(s.nextInt());
        t.root.left.left=new Node(s.nextInt());
        t.root.left.right=new Node(s.nextInt());
        t.root.right.left=new Node(s.nextInt());
        t.root.right.right=new Node(s.nextInt());
        System.out.println(t.count(root));
        System.out.println(t.sum(root));
        System.out.println(t.height(root));
        System.out.println(t.diameter(root));

    }
   //height of BT
    int  height(Node root){
        if(root==null)
            return -1;
        int leftheight=height(root.left);
        int rightheight=height(root.right);
        return(Math.max(leftheight,rightheight)+1);
    }
   //diameter of BT
    int  diameter(Node root){
        if(root==null)
            return 0;

        int lefheight = height(root.left);
        int righheight = height(root.right);

        int leftdiameter = diameter(root.left);
        int rightdiameter = diameter(root.right);
        return Math.max(lefheight + righheight + 1,
                Math.max(leftdiameter, rightdiameter));
    }

    //count nodes
    int  count(Node root){
      if(root==null)
          return 0;
      int c=0;
      c+= (count(root.left)+count(root.right));
      return c+1;
    }

    //sum of all nodes in BT
    int  sum(Node root){
        if(root==null)
            return 0;
        return(sum(root.left)+sum(root.right)+root.data);
    }

}
