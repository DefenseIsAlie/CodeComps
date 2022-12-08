import java.util.HashMap;

/*  
 *   Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.
 *
 *   Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.
 *
 *   Note that you need to maximize the answer before taking the mod and not after taking it.
 * 
 */

public class Solution_1339 {

    public static void main(String[] args) {
        Solution_1339  s = new Solution_1339();

        int[] test = {1,2,3,4,5,6};
        BST tree = new BST(test);

        System.out.println(tree);
        System.out.println(s.postOrderProd(tree.root));
    }


    public int maxProduct(TreeNode root) {
        
        HashMap<Integer,Integer> rootProd = postOrderProd(root);

        

        return 0;
    }
    
    HashMap<Integer,Integer> postOrderProd(TreeNode root){

        HashMap<Integer,Integer> trv = new HashMap<Integer,Integer>();

        if (root != null) {
            trv.putAll(postOrderProd(root.left));

            trv.putAll(postOrderProd(root.right));

            int right = 0;
            int left = 0;
            int sum = 0;
            
            if (root.left==null && root.right==null) {
                sum = root.val;
            } else if (root.left!=null && root.right==null) {
                left = trv.get(root.left.val);
                sum = root.val + left;
            } else if (root.left==null && root.right!=null) {
                right = trv.get(root.right.val);
                sum = root.val + right;
            } else{
                left = trv.get(root.left.val);
                right = trv.get(root.right.val);
                sum = root.val + left + right;
            }

            trv.put(root.val, sum);
        }

        return trv;
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