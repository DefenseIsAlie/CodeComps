import java.util.ArrayList;
import java.util.List;

public class Solution_8 {

    public static void main(String[] args) {
        Solution_8  s = new Solution_8();

        int[] test = {3,5,1,6,2,9,8,7,4};
        BST tree = new BST(test);

        System.out.println(s.LeafSeq(tree.root));

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        List<Integer> l1 = LeafSeq(root1);
        List<Integer> l2 = LeafSeq(root2);


        return l1.equals(l2);
    }

    List<Integer> LeafSeq(TreeNode root){
        List<Integer> seq = new ArrayList<Integer>();

        if (root!=null) {

            seq.addAll(LeafSeq(root.left));

            if (root.left == null && root.right == null) {
                seq.add(root.val);
            }

            seq.addAll(LeafSeq(root.right));
            
        }

        return seq;
    }
    
}



class BST {
    TreeNode root;

    BST(int[] values){
        if (values != null) {
            this.root = new TreeNode(values[0]);

            
            for (int i = 1; i < values.length; i++) {
                    insertNode(root, values[i]);
            }

        }
    }

    TreeNode insertNode(TreeNode node, int val){
        
        if (node == null) {
            return new TreeNode(val);
        }

        if (val < node.val) {
            node.left = insertNode(node.left, val);
        } else {
            node.right = insertNode(node.right, val);
        }

        return node;
    }

    String inorder(TreeNode root){
        
        String trv = "";
        if (root != null) {

            trv += inorder(root.left);

            trv += Integer.toString(root.val) + " ";

            trv += inorder(root.right);
        } 

        return trv;
    }

    @Override
    public String toString(){
        String trv = "";

        trv = inorder(this.root);
        
        return trv;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString(){
        return Integer.toString(this.val);
    }
}