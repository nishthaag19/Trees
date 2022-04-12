//AVL tree implementation
// Methods : insert,delete,display,update,leftrotate,rightrotate,rotate .

class AVLNode{
    int data;
    int height;
    int bal;
    AVLNode left,right;
    public AVLNode(int data){
        this.data=data;
    }
}
public class AVL {
    public static void main(String[] args) {
        AVL ob= new AVL();
         AVLNode n1=new AVLNode(30);
        AVLNode n2=new AVLNode(20);
        AVLNode n3=new AVLNode(10);
        ob.insert(null,n1);
        AVLNode root=ob.insert(n1,n2);
        root=ob.insert(root,new AVLNode(25));
        root=ob.insert(root,n3);
        root=ob.insert(root,new AVLNode(11));
        root=ob.insert(root,new AVLNode(5));
        ob.display(root);
        ob.delete(root,11);
        System.out.println("after deletion");
        ob.display(root);
    }
    public AVLNode insert(AVLNode root,AVLNode node){
        if(root==null)
            return node;
        else if(root.data>node.data){
            root.left=insert(root.left,node);
        }
        else if(root.data<node.data){
            root.right=insert(root.right,node);

        }
        root= rotate(root);
        return root;

    }
    public AVLNode rightrotate(AVLNode A){
        AVLNode B = A.left;
        AVLNode Bright=B.right;
        B.right=A;
        A.left=Bright;
        update(A);
        update(B);
        return B;
    }
    public AVLNode leftrotate(AVLNode A){
        AVLNode B = A.right;
        AVLNode Bleft=B.left;
        B.left=A;
        A.right=Bleft;
        update(A);
        update(B);
        return B;
    }
    AVLNode rotate(AVLNode root){
        update(root);
        if(root.bal==2){
            if(root.left.bal!=1)
                root.left=leftrotate(root.left);
            return rightrotate(root);
        }
        else if(root.bal==-2){
            if(root.right.bal!=-1)
                root.right=rightrotate(root.right);
            return leftrotate(root);
        }
        return root;
    }
    public void update(AVLNode root){
        int l=-1;
        int r=-1;
        if(root.left!=null)
            l=root.left.height;
        if(root.right!=null)
            r=root.right.height;
        root.bal=l-r;
        root.height=Math.max(l,r)+1;

    }
    public AVLNode  delete(AVLNode root,int data){
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
        update(root);
        return root;
    }
    public int findMaxData(AVLNode root) {
        if (root.right != null) {
            return findMaxData(root.right);
        } else {
            return root.data;
        }
    }

    public void display(AVLNode root) {
        if(root==null)
            return;
        String str="";
        str += root.left!=null ? root.left.data+" ":".";
        str+="<-"+root.data+"->";
        str += root.right!=null ? root.right.data+" ":".";
        System.out.println(str);
        display(root.left);
        display(root.right);
    }
}
