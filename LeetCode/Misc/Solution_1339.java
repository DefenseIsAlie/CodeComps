import java.util.ArrayList;
import java.util.*;

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
        System.out.println(s.maxProduct(tree.root));
    }


    public int maxProduct(TreeNode root) {

        List<Long> sumsList = new ArrayList<Long>();

        long total = rootSum(root, sumsList);

        long max = 0;
        long prod = 0;

        for (int i = 0; i < sumsList.size() - 1; i++) {
            prod = (sumsList.get(i)) * (total - sumsList.get(i));
            max = Math.max(max, prod);
        }

        return (int) (max % 1000000007);
    }

    long rootSum(TreeNode root, List<Long> rootSums){

        if (root == null) {
            return 0;
        }

        long leftChild = rootSum(root.left, rootSums);
        long rightChild = rootSum(root.right, rootSums);

        long sum = leftChild + rightChild + root.val;

        rootSums.add(sum);

        return sum;
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