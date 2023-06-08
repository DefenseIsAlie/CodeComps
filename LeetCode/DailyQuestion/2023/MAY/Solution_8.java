// public class Solution_8 {
//     public static void main(String[] args) {
//         int[][] testcase = { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } };
//         int[][] new_case = new int[5000][5000];

//         for (int i = 0; i < new_case.length; i++) {
//             for (int j = 0; j < new_case.length; j++) {
//                 if (j == new_case.length - 1) {
//                     new_case[i][j] = -1;
//                 } else {
                    
//                 }
//             }
//         }

//         Solution_day8 soln = new Solution_day8();
//         System.out.println(soln.countNegatives(new_case));
//     }
// }

/**
 * Solution_d8
 */
class Solution_day8 {
    public int countNegatives(int[][] grid) {
        int ans = 0;

        int m = grid.length;
        int n = grid[0].length;

        if (grid[m - 1][n - 1] >= 0) {
            return 0;
        }

        // O(m*n)
        // for (int i = 0; i < m; i++) {
        // for (int j = n-1; j>=0; ){
        // if (grid[i][j] < 0) {
        // j--;
        // ans++;
        // continue;
        // } else {
        // break;
        // }
        // }
        // // System.out.println("search i = " + i + " ans = " + ans);
        // }

        // O(m+n) not working
        for (int i = 0; i < grid.length; i++) {

            int j = n - 1;
            int direction = -1;
            for (;;) {
                if (j < 0) {
                    ans += n;
                    break;
                }

                if (grid[i][j] < 0 && direction == -1) {
                    j = j + direction;
                    continue;
                } else if (grid[i][j] > 0 && direction == 1) {
                    j = j + direction;
                    continue;
                } else {
                    if (direction == -1) {
                        ans += n - j - 1;
                        // System.out.println(n - j - 1);
                    } else {
                        ans += n - j;
                        // System.out.println(n - j);
                    }

                    if (i + 1 < m) {
                        if (grid[i + 1][j] > 0) {
                            direction = 1;
                        } else {
                            direction = -1;
                        }
                    }

                    break;
                }

            }
            // System.out.println("i = " + i);
        }

        return ans;
    }
}