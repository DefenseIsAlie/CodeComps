import java.util.Arrays;
import java.util.HashMap;

/**
 * Solution_18_12_22
 */
public class Solution_18_12_22 {

    public static void main(String[] args) {
        Solution_18_12_22 s = new Solution_18_12_22();
        String[] test = {"aba","aabb","abcd","bac","aabc"};
        System.out.println(s.similarPairs(test));
    }

    
    //Integer[][] isSimilar;
    public int similarPairs(String[] words) {
        //isSimilar = new Integer[words.length][words.length];
        int ans = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (similarString(words[i], words[j])) {
                    ans += 1;
                }
            }
        }

        return ans;
    }

    boolean similarString(String s1, String s2){
        HashMap<Character, Character> x = new HashMap<>();
        HashMap<Character, Character> y = new HashMap<>();
        
        int j = 0;
        for( int i = 0; i < s1.length(); i++){
            if (j < s2.length()) {
                y.put(s2.charAt(j), s2.charAt(j));
                j+=1;
            }

            x.put(s1.charAt(i), s1.charAt(i));
        }

        return x.keySet().equals(y.keySet());        
    }
}
