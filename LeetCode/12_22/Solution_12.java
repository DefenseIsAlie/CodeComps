import java.util.HashMap;

public class Solution_12 {

    HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int climbStairs(int n) {

        int ans = 0;

        if (n==1) {

            if (!memo.containsKey(1)) {
                memo.put(1, 1);
            }

            return 1;
        }

        if (n==2) {

            
            if (!memo.containsKey(2)) {
                memo.put(2, 2);
            }

            return 2;
        }

        int x = 0;
        int y = 0;

        if (memo.containsKey(n-1)) {
            x = memo.get(n-1);
        }else{
            x = climbStairs(n-1);
        }

        if (memo.containsKey(n-2)) {
            y = memo.get(n-2);
        }else{
            y = climbStairs(n-2);
        }

        ans = x + y;

        if (!memo.containsKey(n)) {
            memo.put(n, ans);
        }

        return ans;
    }
}
