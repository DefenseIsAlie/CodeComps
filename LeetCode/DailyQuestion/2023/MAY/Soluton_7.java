import java.util.Arrays;

public record Soluton_7() {
    public static void main(String[] args) {
        int[] testcase = {1,2,4};
        Solution_d7 soln = new Solution_d7();
        System.out.println(soln.canMakeArithmeticProgression(testcase));
    }
}

/**
 * Solution_d7
 */
class Solution_d7 {

    public boolean canMakeArithmeticProgression(int[] arr) {
        
        Arrays.sort(arr);
        int prev_d;
        int curr_d;

        curr_d = arr[1] - arr[0];
        prev_d = curr_d;


        for (int i = 1; i < arr.length - 1; i++) {
            
            curr_d = arr[i+1] - arr[i];

            if (curr_d != prev_d) {
                return false;
            }

            prev_d = curr_d;
        }


        return true;
    }
    
}