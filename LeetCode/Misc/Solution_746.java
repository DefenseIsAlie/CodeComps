public class Solution_746 {

    public static void main(String[] args) {
        Solution_746 s = new Solution_746();
        int[] test = {1,100,1,1,1,100,1,1,100,1};

        System.out.println(s.minCostClimbingStairs(test));

    }

    public int minCostClimbingStairs(int[] cost) {
        
        int minCost = Integer.MAX_VALUE;

        
        minCost = recursiveSoln(cost.length - 2, cost);


        return minCost;
    }

    int recursiveSoln(int n, int[] cost){
        int minCost = Integer.MAX_VALUE;
           
        if (n == 0) {
            return cost[0];
        } else if (n == 1) {
            return cost[1];
        } 

        int cost1 = recursiveSoln(n-1, cost) + cost[n];
        int cost2 = recursiveSoln(n-2, cost) + cost[n];
        minCost = Math.min(cost1, cost2);

        return minCost;
    }

}