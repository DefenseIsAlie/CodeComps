import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] test = {5,4,3,2,1};

        System.out.println(s.minimumAverageDifference(test));    
       // System.out.println((int)9.9);
    }

    public int minimumAverageDifference(int[] nums) {

        float firstIplus1 = nums[0];
        float lastNminusIminus1 = -nums[0];

        for (int num : nums){
            lastNminusIminus1 += num;
        }

        lastNminusIminus1 = (lastNminusIminus1/(nums.length-1));


        int minimumAverageDifference =  Math.abs(Math.round(firstIplus1) - Math.round(lastNminusIminus1));
        int minIndex = 0;

        System.out.println(minimumAverageDifference);

        for (int i = 1; i < nums.length - 1; i++){

            firstIplus1 = (firstIplus1 * (i) + nums[i])/(i+1);
            lastNminusIminus1 = (lastNminusIminus1 * (nums.length - i) - nums[i])/(nums.length - i - 1);
            
            int movingAverageDifference = Math.abs(Math.round(firstIplus1) - Math.round(lastNminusIminus1));
            //System.out.println(movingAverageDifference);
        
            if (movingAverageDifference < minimumAverageDifference) {

                minimumAverageDifference = movingAverageDifference;
                minIndex = i;
                
            }

            System.out.println(movingAverageDifference);
        }

        //System.out.println(" ");
        return minIndex;
    }
    
    
}
