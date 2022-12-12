import java.util.ArrayList;
import java.util.List;

public class Solution_9 {

    public static void main(String[] args) {
        Solution_9  s = new Solution_9();

        int[] test = {3,5,1,6,2,9,8,7,4};
        BST tree = new BST(test);

        System.out.println(s.maxAncestorDiff(tree.root));

    }


    /*\
     *  
     *  O(N^2) brute force approach works  with 298ms
     * 
     */
    public int maxAncestorDiff(TreeNode root) {

        List<TreeNode> NodesList = preOrderNodes(root);

        int max = 0;

        for (TreeNode node : NodesList) {
            
            int diff = recmaxDiff(node, node.val);

            if (diff >= max) {
                max = diff;
            }

        }
        
        return max;
    }


    /*
     * 
     * O(N) solution
     * 
     */

     int maxAncestorDiff(TreeNode root, int diff){
        if (root == null) {
            return 0;
        }
        return recursiveMaxAncestorDiff(root, root.val, root.val);
     }

    List<TreeNode> preOrderNodes(TreeNode root){
        List<TreeNode> preOrder = new ArrayList<TreeNode>();

        if (root!=null) {
            preOrder.addAll(preOrderNodes(root.right));

            preOrder.add(root);

            preOrder.addAll(preOrderNodes(root.left));

        }

        return preOrder;
    }

    List<Integer> leftVal(TreeNode root){
        List<Integer> ans = new ArrayList<Integer>();

        if (root!=null) {
            ans.addAll(leftVal(root.left));

            ans.add(root.val);

        }

        return ans;
    }

    int maxdiff(TreeNode node){

        int ans = 0;

        List<Integer> leftIntegers = leftVal(node);

        for (Integer integer : leftIntegers) {
            int diff = Math.abs(node.val  - integer);

            if (diff > ans){
                ans = diff;
            }

        }
        
        return ans;
    }


    int recmaxDiff(TreeNode node, int val){
        int recmaxDiff = 0;

        if (node != null) {
            int d1 = recmaxDiff(node.left, val);
            int d2 = recmaxDiff(node.right, val);
            int d3 = Math.abs(val - node.val);

            recmaxDiff = Math.max(d2, d3);
            
            recmaxDiff = Math.max(recmaxDiff, d1);
        }

        return recmaxDiff;
    }

    /*
     *  Recursive O(N) approach
     *  
     */
    int recursiveMaxAncestorDiff(TreeNode node, int pathMax, int pathMin){
        
        if (node==null) {
            return pathMax - pathMin;
        }

        pathMax = Math.max(pathMax, node.val);
        pathMin = Math.min(node.val, pathMin);

        int left = recursiveMaxAncestorDiff(node.left, pathMax, pathMin);
        int right = recursiveMaxAncestorDiff(node.right, pathMax, pathMin);

        return Math.max(left, right);
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
