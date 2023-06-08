// 42. Trapping Rain Water
// Hard
// 26.8K
// 366
// Companies
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

/**
 * TrappingRainWater
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        Solution_q42 soln = new Solution_q42();
        System.out.println(soln.trap(height));
    }
}

class Solution_q42 {
    public int trap(int[] height) {

        int prev_barrier = 0;

        for (int current_y : height){

        }

        return 0;
    }
}