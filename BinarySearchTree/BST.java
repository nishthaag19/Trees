package BinarySearchTree;
//basic operations on binary search tree
class BSTNode{
    int data;
    BSTNode left,right;
    public BSTNode(int data){
        this.data=data;
    }
}

public class BST {
    static BSTNode root;
    public static void main(String[] args) {
       BST ob= new BST();

        ob.insert(45);
        ob.insert(10);
        ob.insert(7);
        ob.insert(90);
        ob.insert(12);
        ob.insert(50);
        ob.traverse(root);
        System.out.println("value is:    "+ob.search(root,45));
        ob.delete(12);
        System.out.println();
        ob.traverse(root);
        ob.delete(90);
        System.out.println();
        ob.traverse(root);
        System.out.println();
        System.out.println("max:   "+ob.findMax());
        System.out.println("min:    "+ob.findMin());
    }
    public void  insert(int data){
        this.root=insert(root,data);
    }
    public BSTNode insert(BSTNode root,int data){
        if(root==null){
            root=new BSTNode(data);
            return root;
        }
        if(root.data>data)
            root.left=insert(root.left,data);
        else if(data>root.data)
            root.right=insert(root.right,data);
        return root;
    }
    //inorder traversal
    void traverse(BSTNode root){
        if(root!=null) {
            traverse(root.left);
            System.out.print(root.data + "   ");
            traverse(root.right);

        }
    }
    public void delete(int data){
        delete(this.root,data);
    }

    BSTNode delete(BSTNode root,int data){
        if(root==null)
            return null;
        if(data<root.data)
            root.left=delete(root.left,data);
        else if(data>root.data)
            root.right=delete(root.right,data);


        else if(root.data==data){

            if (root.left != null && root.right != null) {
                int lmax = findMaxData(root.left);
                root.data = lmax;
                root.left = delete(root.left,lmax);
                return root;
            }

            else if (root.left != null) {
                return root.left;
            }

            else if (root.right != null) {
                return root.right;
            }

            else
                return null;
        }
        return root;

    }
    public int findMaxData(BSTNode root) {
        if (root.right != null) {
            return findMaxData(root.right);
        } else {
            return root.data;
        }
    }

    public  boolean search(BSTNode root, int data) {
        if (root == null) {
            return false;
        } else if (root.data == data) {
            return true;
        } else if (root.data > data) {
            return search(root.left, data);
        } else {
            return search(root.right, data);
        }
    }

    public int findMax() {
        if(root==null){
            return -1;
        }
        BSTNode current = this.root;
        while (current.right != null) {
            current = current.right;
        }
        return (current.data);
    }

    public int findMin() {
        if(root==null){
            return -1;
        }
        BSTNode current = this.root;
        while (current.left != null) {
            current = current.left;
        }
        return (current.data);
    }

}
