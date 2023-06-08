public class Solution_8 {
    public static void main(String[] args) {
        int[][] testcase = {{4,3,2,-1}, {3,2,1,-1}, {1,1,-1,-2}, {-1,-1,-2,-3}};
        Solution_day8 soln = new Solution_day8();
        System.out.println(soln.countNegatives(testcase));
    }
}

/**
 * Solution_d8
 */
class Solution_day8 {
    public int countNegatives(int[][] grid) {
        int ans = 0;

        int m = grid.length;
        int n = grid[0].length;

        if (grid[m-1][n-1] >= 0) {
            return 0;
        }



        // O(m*n)
        // for (int i = 0; i < m; i++) {
        //     for (int j = n-1; j>=0; ){
        //         if (grid[i][j] < 0) {
        //             j--;
        //             ans++;
        //             continue;                    
        //         } else {
        //             break;
        //         }
        //     }
        //     // System.out.println("search i = " + i + " ans = " + ans);
        // }

        // O(m+n)
        for (int i = 0; i < grid.length; i++) {
            
            // int j = n-1;
            // int direction = -1;
            // for( ; ; ){
            //     if (grid[i][j] < 0) {
            //         j = j + direction;
            //         ans++;
            //         continue;
            //     } else{

            //     }
            // }
        }

        return ans;
    }
}