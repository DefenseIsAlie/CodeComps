public class Solution_13 {

    public static void main(String[] args) {
        Solution_13 s = new Solution_13();
        
        int[][] test = {{2,1,3}, {6,5,4}, {7,8,9}};

        System.out.println(s.minFallingPathSum(test));
    }

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        if ( m==1 || n==1) {
            return matrix[0][0];
        }

        Integer[][] dp = new Integer[m][n];
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < dp.length; i++) {
            ans = Math.min(ans, minPatn(matrix, 0, i, dp));
        }

        return ans;    
    }

    int minPatn(int[][] matrix, int row, int col, Integer[][] dp){

        int m = matrix.length;
        int n = matrix[0].length;

        if (dp[row][col] != null) {
            return dp[row][col];
        }

        if (row == n-1){
            return dp[row][col] = matrix[row][col];
        }

        int left = Integer.MAX_VALUE , right = Integer.MAX_VALUE;

        if (col > 0) {
            left = minPatn(matrix, row+1, col-1, dp);
        }

        if (col < n-1) {
            right = minPatn(matrix, row+1, col+1, dp);
        }

        int straight = minPatn(matrix, row+1, col, dp);

        dp[row][col] = Math.min(right, Math.min(straight, left)) + matrix[row][col];

        return dp[row][col];
    }
    
}


