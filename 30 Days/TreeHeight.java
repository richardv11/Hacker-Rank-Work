import java.util.Scanner;

// Using input form the command line, build a BST and find the height of it.
public class TreeHeight {
    public static int getHeight(Node root){
        //Write your code here
        if(root == null)
            return -1;
        else{
            // Get heights for left/right subtrees to see the largest
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);

            // Return the call depending which subtree is larger.
            if(leftHeight > rightHeight)
                return 1 + leftHeight;
            else
                return 1 + rightHeight;
        }
    }

    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        System.out.println(height);
    }
}
