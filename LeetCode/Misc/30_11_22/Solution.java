import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] test = {1,2};

        System.out.println(s.uniqueOccurrences(test));    
    }

    public boolean uniqueOccurrences(int[] arr) {
        
        HashMap<Integer,Integer> count = new HashMap<Integer, Integer>();

        for (int x : arr){
            if (count.containsKey(x)){
                count.put(x,count.get(x)+1);
            }else{
                count.put(x, 1);
            }
        }

        
        
        HashMap<Integer,Integer> countMap = new HashMap<Integer, Integer>();
        
        
        for(int key : count.keySet()){
            if (countMap.containsKey(count.get(key))){
                return false;
            }else{
                countMap.put(count.get(key), key);
            }
        }
        
        return true;
    }
}