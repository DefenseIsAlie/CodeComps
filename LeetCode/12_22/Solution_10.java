import java.util.ArrayList;
import java.util.List;

public class Solution_10 {

    public static void main(String[] args) {
        Solution_10  s = new Solution_10();

        int[] test = {3,5,1,6,2,9,8,7,4};
        BST tree = new BST(test);

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