import java.util.*;

public class Solution{

    public static void main(String[] args) {

        char[][] board = {{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}} ;
        String[] words = {"oath","pea","eat","rain"};
        
        Solution s = new Solution();
        var w =s.findWords(board, words);

        for (String word : w) {
            System.out.println(word);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> result = new ArrayList<String>();
        
        for (String word_in : words) {
            
            char start = word_in.charAt(0);
            int indx = 0;
            for (char[] row_in : board) {
                
                String row_str = new String(row_in);
                int indy = row_str.indexOf(start);
                boolean ispresent = false;
                boolean isused[][] = new boolean[board.length][board[0].length];

                while (indy>=0) {
                    isused[indx][indy] = true;
                    ispresent = isWordPresent(board, word_in.substring(1), indx, indy, isused);
                    if (ispresent) {
                        result.add(word_in);    
                        break;
                    }
                    indy = row_str.indexOf(start, indy + 1);
                }

                if (ispresent) {
                    break;
                }
                
                indx+=1;
            }

        }
        return result;
    }

    public boolean isWordPresent(char[][] board, String word, int indx, int indy, boolean[][] isused ) {
        boolean result = false;
        isused[indx][indy] = true;

        if (word.length() == 0){
            return true;
        }

        char start = word.charAt(0);
        int min = 0, maxx = board.length, maxy = board[0].length;

        if (word.length() == 1){
            if (indy-1>=min) {
                if (board[indx][indy-1] == start && !isused[indx][indy-1]){
                    result = true;
                }
            }
    
            if (indy+1<maxy) {
                if (board[indx][indy+1] == start && !isused[indx][indy+1]){
                    result = true;
                }
            }
    
            if (indx+1<maxx) {
                if (board[indx+1][indy] == start && !isused[indx+1][indy]){
                    result = true;
                }
            }
    
            if (indx-1>=min) {
                if (board[indx-1][indy] == start && !isused[indx-1][indy]){
                    result = true;
                }
            }
        }else{

        if (indy-1>=min) { 
            if (board[indx][indy-1] == start && !isused[indx][indy-1]){
                result = result || isWordPresent(board, word.substring(1), indx, indy-1, isused); //todo
            }
        }

        if (indy+1<maxy) {
            if (board[indx][indy+1] == start && !isused[indx][indy+1]){
                result = result || isWordPresent(board, word.substring(1), indx, indy+1, isused);
            }
        }

        if (indx+1<maxx) {
            if (board[indx+1][indy] == start && !isused[indx+1][indy]){
                result = result || isWordPresent(board, word.substring(1), indx+1, indy, isused);
            }
        }

        if (indx-1>=min) {
            if (board[indx-1][indy] == start && !isused[indx-1][indy]){
                result = result || isWordPresent(board, word.substring(1), indx-1, indy, isused);
            }
        }

        }
        return result;
    }

}