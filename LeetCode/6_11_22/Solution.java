import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        String test = "Shaky";
        int k = 1;
        System.out.println(s.orderlyQueue(test, k));
        System.out.println(); 
    }

    public String orderlyQueue(String s, int k) {

        String ret = s;
        
        if (k==1){

            for (int i = 0; i < s.length(); i++) {
                String temp = s.substring(i) + s.substring(0, i);
                if (temp.compareTo(ret)<0){
                    ret = temp;
                }
            }

            return ret;
        }

        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        ret = new String(temp);

        return ret;
    }
}