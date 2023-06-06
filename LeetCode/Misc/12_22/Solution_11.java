
public class Solution_11 {
    
    public static void main(String[] args) {
        Solution_11 s = new Solution_11();

        int[] test = {3,5,1,6,2,9,8,7,4};
        BST tree = new BST(test);

        System.out.println(s.maxPathSum(tree.root));

    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        maxPAth(root);

        return max;
    }

    int maxPAth(TreeNode root){
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, maxPAth(root.left));
        int right = Math.max(0, maxPAth(root.right));

        max = Math.max(max, left + right + root.val);

        return Math.max(left, right) + root.val;
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