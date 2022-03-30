package BinaryTree;
//binary tree implementation by using array.
import java.util.Scanner;

//class Node{
//    int data;
//    Node left,right;
//    public Node(int data){
//        this.data=data;
//    }
//}
public class BinaryTreeByArray {
    int arr[];
    int lastusedindex;
    public BinaryTreeByArray(int size){
        arr= new int[size+1];
        lastusedindex=0;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter no of nodes");
        int n= s.nextInt();
        BinaryTreeByArray ob= new BinaryTreeByArray(n);
        for (int i = 1; i < ob.arr.length; i++) {
            ob.insert(s.nextInt());

        }
        ob.preorderTraverse(s.nextInt());
        ob.delete(s.nextInt());
        ob.preorderTraverse(s.nextInt());
    }

    public void insert(int val){
        if(lastusedindex>arr.length-1)
            return;

        arr[lastusedindex]=val;
        lastusedindex++;
    }

    public void preorderTraverse(int index){
       if(index>lastusedindex)
             return;
        System.out.println(arr[index]+"   ");
        preorderTraverse(2*index);
        preorderTraverse(2*index+1);

    }

  public int search(int value){
      for (int i = 1; i <=lastusedindex ; i++) {
          if(arr[i]==value)
              return i;
      }
      return -1;
  }

  public void delete(int value){
        int index=search(value);
        if(index==-1)
            return;
        arr[index]=arr[lastusedindex];
        lastusedindex--;
  }

}
