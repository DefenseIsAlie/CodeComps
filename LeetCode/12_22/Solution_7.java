public class Solution_7 {

    public static void main(String[] args) {
        Solution_7  s = new Solution_7();

        int[] test = {10,5,15,3,7,13,18,1,6};
        BST tree = new BST(test);

        System.out.println(s.rangeSumBST(tree.root, 6, 10));
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;

        if (root != null) {
            sum += rangeSumBST(root.left, low, high);

            if(root.val >=low && root.val <= high){
                sum += root.val;
            }

            sum += rangeSumBST(root.right, low, high);
        }

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